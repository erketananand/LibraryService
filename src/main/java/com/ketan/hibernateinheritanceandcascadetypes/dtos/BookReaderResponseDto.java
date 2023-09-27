package com.ketan.hibernateinheritanceandcascadetypes.dtos;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReaderResponseDto {
    private String title;
    private String authorName;
    private List<String> readers;
}
