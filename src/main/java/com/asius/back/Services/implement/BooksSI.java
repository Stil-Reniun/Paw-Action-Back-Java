package com.asius.back.Services.implement;


import com.asius.back.Entity.Books;
import com.asius.back.Repository.BooksRepository;
import com.asius.back.Services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class BooksSI implements BooksServices {
    @Autowired
    private BooksRepository booksRepository;
    @Override
    public Books agregarLibro(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Books actualizarLibro(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Set<Books> obtenerLibros() {
        return new LinkedHashSet<>(booksRepository.findAll());
    }

    @Override
    public Books obtenerLibros(Long idBooks) {
        return booksRepository.findById(idBooks).get();
    }

    @Override
    public void eliminarLibros(Long idBooks) {
        Books books = new Books();
        books.setIdBooks(idBooks);
        booksRepository.delete(books);
    }
}
