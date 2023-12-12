package com.asius.back.Controllers;


import com.asius.back.Entity.Books;
import com.asius.back.Entity.exceptions.ResourceNotFoundException;
import com.asius.back.Services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BooksControllers {

    @Autowired
    private BooksServices booksServices;

    @PostMapping("/agregar")
    public ResponseEntity<Books> guardarLibro(@RequestBody Books books){
        Books libroGuardado = booksServices.agregarLibro(books);
        return ResponseEntity.ok(libroGuardado);
    }


    @GetMapping("/{idBooks}")
    public ResponseEntity<Books> listarLibrosPorId(@PathVariable(value = "idBooks") Long idBooks)
            throws ResourceNotFoundException {
        Books libro = booksServices.obtenerLibros(idBooks);
        if (libro == null) {
            throw new ResourceNotFoundException("Libro no encontrado con el ID: " + idBooks);
        }
        return ResponseEntity.ok(libro);
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listarLibro(){
        return ResponseEntity.ok(booksServices.obtenerLibros());
    }

    @PutMapping("/modificar")
    public Books actualizarLibro(@RequestBody Books books){
        return booksServices.actualizarLibro(books);
    }

    @DeleteMapping("/eliminar/{idBooks}")
    public void eliminarLibro(@PathVariable("idBooks") Long idBooks){
        booksServices.eliminarLibros(idBooks);
    }


}
