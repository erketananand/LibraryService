package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.AuthorBookReaderCountDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.AuthorRequestDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    public List<AuthorResponseDto> getAllAuthors();

    AuthorResponseDto createAuthor(AuthorRequestDto author);

    List<String> getAllAuthorNames();

    AuthorResponseDto getAuthorById(Long id);

    AuthorResponseDto updateAuthor(Long id, AuthorRequestDto author);

    void deleteAuthor(Long id);

    List<String> getBooksByAuthor(Long id);

    List<AuthorBookReaderCountDto> getReaderCountPerBook(Long authorId);
}
