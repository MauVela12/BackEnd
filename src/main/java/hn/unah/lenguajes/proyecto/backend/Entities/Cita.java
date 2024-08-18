package hn.unah.lenguajes.proyecto.backend.Entities;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "iddoctor")
    private Personal doctor;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private Paciente paciente;

    @Column(name = "fechacita")
    private Date fechaCita;

    @Column(name = "horacita")
    private Time horaCita;

    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estado;

    private String detalle;
}
