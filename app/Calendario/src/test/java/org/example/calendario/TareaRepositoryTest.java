package org.example.calendario;

import org.example.calendario.model.EstadoTarea;
import org.example.calendario.model.Tarea;
import org.example.calendario.repository.TareaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TareaRepositoryTest {

    @Autowired
    private TareaRepository repository;

    @Test
    void guardaUnaTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo("Crear cuenta de AWS");

        Tarea guardada = repository.save(tarea);

        assertNotNull(guardada.getId());
        assertEquals(EstadoTarea.PENDIENTE, guardada.getEstado());
    }

    @Test
    void borraUnaTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo("Escribir el Dockerfile");
        Tarea guardada = repository.save(tarea);

        repository.deleteById(guardada.getId());

        assertFalse(repository.existsById(guardada.getId()));
    }
}