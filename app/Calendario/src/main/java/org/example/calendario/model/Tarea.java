package org.example.calendario.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    private Categoria categoria;

    private LocalDate fechaLimite;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad = Prioridad.MEDIA;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado = EstadoTarea.PENDIENTE;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    public EstadoTarea getEstado() {
        return estado;
    }
    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
