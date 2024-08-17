package hn.unah.lenguajes.proyecto.backend.Entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedicamentos")
    private int idMedicamentos;

    private String nombre;

    private String descripcion;

    @Column(name = "cantidaddisponibles")
    private int cantidadDisponibles;

    @Column(name = "fechacaducidad")
    private Date fechaCaducidad;
}
