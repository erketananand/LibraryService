package com.ketan.hibernateinheritanceandcascadetypes.dtos;

import java.util.List;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private String name;
    private List<String> books;
}
