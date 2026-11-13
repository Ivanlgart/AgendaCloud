package org.example.calendario.controller;

import org.example.calendario.model.Categoria;
import org.example.calendario.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}