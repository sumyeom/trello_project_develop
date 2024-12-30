package com.example.trelloproject.card.dto.addManager;

import lombok.Getter;

@Getter
public class AddManagerRequestDto {
    private Long userId;
    private String ManagerName;

    public AddManagerRequestDto(Long userId, String managerName) {
        this.userId = userId;
        this.ManagerName = managerName;
    }
}
