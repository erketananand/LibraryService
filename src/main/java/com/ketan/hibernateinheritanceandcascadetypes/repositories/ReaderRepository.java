package com.ketan.hibernateinheritanceandcascadetypes.repositories;

import com.ketan.hibernateinheritanceandcascadetypes.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
