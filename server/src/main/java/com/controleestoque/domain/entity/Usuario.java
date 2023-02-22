package com.controleestoque.domain.entity;

import com.controleestoque.domain.entity.enums.Role;
import jakarta.persistence.Entity;


@Entity
public class Usuario {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private Role role;
}
