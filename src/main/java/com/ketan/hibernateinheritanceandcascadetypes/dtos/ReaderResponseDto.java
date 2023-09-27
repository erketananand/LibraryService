package com.ketan.hibernateinheritanceandcascadetypes.dtos;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReaderResponseDto {
    private String name;
    private List<String> bookNames;
}
