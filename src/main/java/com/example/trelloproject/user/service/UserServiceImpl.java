package com.example.trelloproject.user.service;

import com.example.trelloproject.user.config.auth.UserDetailsImpl;
import com.example.trelloproject.user.dto.UserLoginRequestDto;
import com.example.trelloproject.user.dto.UserLoginResponseDto;
import com.example.trelloproject.user.dto.UserSignUpRequestDto;
import com.example.trelloproject.user.dto.UserSignUpResponseDto;
import com.example.trelloproject.user.entity.User;
import com.example.trelloproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public UserSignUpResponseDto createUser(UserSignUpRequestDto userSignUpRequestDto) throws DuplicateKeyException {

        boolean dup = this.userRepository.findByEmail(userSignUpRequestDto.getEmail()).isPresent();

        if(dup) {
            throw new DuplicateKeyException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(userSignUpRequestDto.getPassword());
        User user = new User(
                userSignUpRequestDto.getName(),
                userSignUpRequestDto.getEmail(),
                encodedPassword,
                userSignUpRequestDto.getUserRole());

        userRepository.save(user);

        return new UserSignUpResponseDto(user.getName(), user.getEmail(), user.getUserRole());
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {

        User user = userRepository.findByEmail(userLoginRequestDto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("사용자가 존재하지 않습니다."));
        validatePassword(userLoginRequestDto.getPassword(), user.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequestDto.getEmail(), userLoginRequestDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new UserLoginResponseDto(user.getName(), user.getEmail());
    }

    //세션에서 로그인한 사용자의 정보 가져오기
    public User getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        return user;
    }

    private void validatePassword(String rawPassword, String encodedPassword) throws IllegalArgumentException {
        if(!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }
    }
}
