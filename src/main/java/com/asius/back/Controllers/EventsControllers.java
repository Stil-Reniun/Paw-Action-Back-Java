package com.asius.back.Controllers;


import com.asius.back.Entity.Events;
import com.asius.back.Entity.exceptions.ResourceNotFoundException;
import com.asius.back.Services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
@CrossOrigin("*")
public class EventsControllers {

    @Autowired
    private EventsService eventoService;

    @PostMapping("/agregar")
    public ResponseEntity<Events> guardarEvento(@RequestBody Events events){
        Events eventoGuardado = eventoService.agregarEvento(events);
        return ResponseEntity.ok(eventoGuardado);
    }

    @GetMapping("/{idEvents}")
    public ResponseEntity<Events> listarEventoPorId(@PathVariable(value = "idEvents") Long idEvents)
            throws ResourceNotFoundException {
        Events evento = eventoService.obtenerEvento(idEvents);
        if (evento == null) {
            throw new ResourceNotFoundException("Evento no encontrado con el ID: " + idEvents);
        }
        return ResponseEntity.ok(evento);
    }



    @GetMapping("/listar")
    public ResponseEntity<?> listarEvento(){
        return ResponseEntity.ok(eventoService.obtenerEvento());
    }

    @PutMapping("/modificar")
    public Events actualizarEvento(@RequestBody Events events){
        return eventoService.actualizarEvento(events);
    }

    @DeleteMapping("/eliminar/{idEvents}")
    public void eliminarEvento(@PathVariable("idEvents") Long idEvents){
        eventoService.eliminarEvento(idEvents);
    }







}
