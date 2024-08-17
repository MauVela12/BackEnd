package hn.unah.lenguajes.proyecto.backend.Entities;

import java.sql.Time;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "horario")
@Data
public class Horario {
    
    @Id
    @Column(name = "idhorario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;

    @Column(name = "horainicio")
    private Time horaInicio;

    @Column(name = "horafinal")
    private Time horaFinal;

    private String dias;
}
