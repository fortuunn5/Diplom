package com.example.Diplom.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String role;
    private String lastname;
    private String firstname;
    private String middlename;
    private String email;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @Builder.Default
    private Set<Order> orders = new LinkedHashSet<>();

}
