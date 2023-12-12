package com.asius.back.Repository;



import com.asius.back.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
