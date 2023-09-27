package com.ketan.hibernateinheritanceandcascadetypes.dtos;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRequestDto {
    private String name;
    private List<BaseObjectDto> books;
}
