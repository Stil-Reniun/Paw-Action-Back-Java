package com.asius.back.Services.implement;

import com.asius.back.Entity.Events;
import com.asius.back.Repository.EventsRepository;
import com.asius.back.Services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class EventsSI  implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;


    @Override
    public Events agregarEvento(Events events) {
      return eventsRepository.save(events);
    }

    @Override
    public Events actualizarEvento(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    public Set<Events> obtenerEvento() {
        return new LinkedHashSet<>(eventsRepository.findAll());
    }

    @Override
    public Events obtenerEvento(Long idEvents) {
        return eventsRepository.findById(idEvents).get();
    }

    @Override
    public void eliminarEvento(Long idEvents) {
        Events events = new Events();
        events.setIdEvents(idEvents);
        eventsRepository.delete(events);
    }
}
