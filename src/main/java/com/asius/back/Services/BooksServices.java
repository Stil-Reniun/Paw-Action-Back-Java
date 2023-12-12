package com.asius.back.Services;


import com.asius.back.Entity.Books;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BooksServices {
    Books agregarLibro(Books books);

    Books actualizarLibro(Books books);

    Set<Books> obtenerLibros();

    Books obtenerLibros(Long idBooks);

    void eliminarLibros(Long idBooks);
}
