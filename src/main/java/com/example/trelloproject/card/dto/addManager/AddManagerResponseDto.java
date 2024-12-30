package com.example.trelloproject.card.dto.addManager;

import lombok.Getter;

@Getter
public class AddManagerResponseDto {
    private Long ManagerId;
    private String ManagerName;

    public AddManagerResponseDto(Long managerId, String managerName) {
        this.ManagerId = managerId;
        this.ManagerName = managerName;
    }
}
