package org.example.calendario.controller;

import org.example.calendario.model.Evento;
import org.example.calendario.repository.EventoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoRepository repository;

    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Evento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Evento crear(@RequestBody Evento evento) {
        return repository.save(evento);
    }

    @PutMapping("/{id}")
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return repository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
