package com.ketan.hibernateinheritanceandcascadetypes.dtos;

import lombok.*;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBookReaderCountDto {
    private String bookTitle;
    private long readerCount;
}

