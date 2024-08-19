package hn.unah.lenguajes.proyecto.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import hn.unah.lenguajes.proyecto.backend.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByCorreo(String correo);
}