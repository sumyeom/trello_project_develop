package com.example.trelloproject.list.repository;

import com.example.trelloproject.list.entity.BoardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<BoardList, Long> {

    Integer countByBoardId(Long boardId);
}
