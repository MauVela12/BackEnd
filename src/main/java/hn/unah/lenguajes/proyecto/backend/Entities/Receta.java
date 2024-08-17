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

@Data
@Entity
@Table(name = "receta")

public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceta;

    @ManyToOne
    @JoinColumn(name = "idmedicamentos")
    private Medicamento medicamento;

    @Column(name = "cantidadmedicamento")
    private int cantidadMedicamento;

    //@ManyToOne
    //@JoinColumn(name = "idCita")
    //private Cita cita;
}
