package com.harsh.garagebookingbackend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String role;
}