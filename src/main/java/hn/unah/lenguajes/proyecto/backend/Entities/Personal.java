package hn.unah.lenguajes.proyecto.backend.Entities;

import java.sql.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "personal")
@Data
public class Personal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;

    @Column(name = "fechaingreso")
    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    private Cargo cargo;

    private String telefono;

    private String correo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddireccion", referencedColumnName = "iddireccion")
    private Direccion direccion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    private Horario horario;
}
