package com.controleestoque.auth.dto;

import com.controleestoque.domain.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegiterRequest {


    private String email;
    private String password;
}