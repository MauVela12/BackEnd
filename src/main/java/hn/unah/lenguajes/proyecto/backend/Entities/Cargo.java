package hn.unah.lenguajes.proyecto.backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cargos")
@Data
public class Cargo {
    
    @Id
    @Column(name = "idcargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCargo;

    private String nombre;

    private String descripcion;
}
