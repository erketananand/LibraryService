package com.ketan.hibernateinheritanceandcascadetypes.services;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.BookReaderResponseDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.ReaderRequestDto;
import com.ketan.hibernateinheritanceandcascadetypes.dtos.ReaderResponseDto;

import java.util.List;

public interface ReaderService {

    ReaderResponseDto createReader(ReaderRequestDto reader);

    List<String> getAllReaders();

    ReaderResponseDto getReaderById(Long id);

    ReaderResponseDto updateReader(Long id, ReaderRequestDto reader);

    void deleteReader(Long id);

    List<String> getBooksByReader(Long id);
}
