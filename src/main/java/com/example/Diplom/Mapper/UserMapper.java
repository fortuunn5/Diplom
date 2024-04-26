package com.example.Diplom.Mapper;

import com.example.Diplom.Dto.UserDto;
import com.example.Diplom.Model.User;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public static User map(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .role(userDto.getRole())
                .lastname(userDto.getLastname())
                .middlename(userDto.getMiddlename())
                .email(userDto.getEmail())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .orders(OrderMapper.map(userDto.getOrders()))
                .build();
        return user;
    }

    public static UserDto map(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .role(user.getRole())
                .lastname(user.getLastname())
                .middlename(user.getMiddlename())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword())
                .orders(OrderMapper.mapToDtoSet(user.getOrders()))
                .build();
        return userDto;
    }

    public static Set<User> map(Set<UserDto> userDtoSet) {
        Set<User> userSet = userDtoSet.stream().map(UserMapper::map).collect(Collectors.toSet());
        return userSet;
    }

    public static Set<UserDto> mapToDtoSet(Set<User> userSet) {
        Set<UserDto> userDtoSet = userSet.stream().map(UserMapper::map).collect(Collectors.toSet());
        return userDtoSet;
    }
}
