package com.ketan.hibernateinheritanceandcascadetypes.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String name;
}
