package hn.unah.lenguajes.proyecto.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hn.unah.lenguajes.proyecto.backend.Entities.Usuario;
import hn.unah.lenguajes.proyecto.backend.Services.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Obtener un usuario por ID
    @GetMapping("obtenerusuario/{idUsuario}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorId(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
        return ResponseEntity.ok(usuario);
    }

    // Obtener todos los usuarios
    @GetMapping("/obtenerTodosUsuarios")
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Actualizar un usuario
    @PutMapping("actualizarUsuario/{idUsuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar un usuario
    @DeleteMapping("eliminarUsuario/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("obtenerusuarioPorCorreoContrasena/{correo}/{contrasena}")
    public Usuario obtenerUsuarioPorCorreoContrasena(@PathVariable(name = "correo") String correo,
                                                     @PathVariable(name = "contrasena") String contrasena) {
        return this.usuarioService.buscarUsuarioCorreoContrasena(correo, contrasena);
    }

}
