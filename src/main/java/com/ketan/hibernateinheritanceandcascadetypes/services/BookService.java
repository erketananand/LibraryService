package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.BookRequestDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.BookReaderResponseDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.BookResponseDto;

import java.util.List;

public interface BookService {
    BookReaderResponseDto createBook(BookRequestDto book);

    List<BookResponseDto> getAllBooks();

    BookReaderResponseDto getBookById(Long id);

    BookReaderResponseDto updateBook(Long id, BookRequestDto book);

    void deleteBook(Long id);

    List<String> getReadersByBook(Long id);
}
