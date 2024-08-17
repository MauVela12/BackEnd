package hn.unah.lenguajes.proyecto.backend.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    
    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombreusuario")
    private String nombreUsuario;

    private String contrasena;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtipousuario", referencedColumnName = "idtipousuario")
    private TipoUsuario tipoUsuario;
}
