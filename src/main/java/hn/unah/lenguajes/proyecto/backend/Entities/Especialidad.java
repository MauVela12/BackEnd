package hn.unah.lenguajes.proyecto.backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "especialidad")
@Data
public class Especialidad {
    
    @Id
    @Column(name = "idespecialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;

    private String nombre;

    private String descripcion;
}
