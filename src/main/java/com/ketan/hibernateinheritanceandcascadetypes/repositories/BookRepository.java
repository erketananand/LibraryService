package com.ketan.hibernateinheritanceandcascadetypes.repositories;

import com.ketan.hibernateinheritanceandcascadetypes.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
