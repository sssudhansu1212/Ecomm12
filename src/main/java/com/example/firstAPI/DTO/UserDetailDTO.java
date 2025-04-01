package com.example.firstAPI.DTO;

import java.util.List;
import com.example.firstAPI.Model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDTO {

    private String name;
    private String email;
    private List<Role> roles;
}
