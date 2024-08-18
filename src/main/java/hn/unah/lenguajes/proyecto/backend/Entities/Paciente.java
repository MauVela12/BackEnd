package hn.unah.lenguajes.proyecto.backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "paciente")
public class Paciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente")
    private Integer idPaciente;

    private String nombre;

    private String apellido;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "iddireccion")
    private Direccion direccion;

    private String telefono;
    private String correo;
}
