package com.ketan.hibernateinheritanceandcascadetypes.dtos;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String title;
    private String authorName;
}
