package com.ketan.hibernateinheritanceandcascadetypes.repositories;

import com.ketan.hibernateinheritanceandcascadetypes.dtos.AuthorBookReaderCountDto;
import com.ketan.hibernateinheritanceandcascadetypes.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(CustomQuery.FIND_READERS_COUNT_PER_BOOK_BY_AUTHOR_ID)
    List<AuthorBookReaderCountDto> getReaderCountPerBook(@Param("authorId") Long authorId);
}
