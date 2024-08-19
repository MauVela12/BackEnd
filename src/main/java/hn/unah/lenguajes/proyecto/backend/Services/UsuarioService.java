package hn.unah.lenguajes.proyecto.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.proyecto.backend.Entities.Usuario;
import hn.unah.lenguajes.proyecto.backend.Repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario buscarUsuarioCorreoContrasena(String correo, String contrasena) {
        Usuario usuarioEncontrado = this.usuarioRepository.findByCorreo(correo);

        if (usuarioEncontrado.getPassword().equals(contrasena)) {
            return usuarioEncontrado;
        }else {
            return null;
        }
    }
}