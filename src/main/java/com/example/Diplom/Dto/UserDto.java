package com.example.Diplom.Dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String role;
    private String lastname;
    private String firstname;
    private String middlename;
    private String email;
    private String login;
    private String password;
    private Set<OrderDto> orders;
}
