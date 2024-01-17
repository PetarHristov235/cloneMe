package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeqGenerator")
    @SequenceGenerator(name = "userIdSeqGenerator", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false, length = 32)
    private String username;
    @Column(nullable = false, unique = true, length = 128)
    private String email;
    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 128)
    private String password;
    private boolean active = true;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<RoleEntity> roles = new ArrayList<>();
}