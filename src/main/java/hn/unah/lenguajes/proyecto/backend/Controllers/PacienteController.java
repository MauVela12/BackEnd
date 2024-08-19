package hn.unah.lenguajes.proyecto.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hn.unah.lenguajes.proyecto.backend.Entities.Cita;
import hn.unah.lenguajes.proyecto.backend.Entities.Paciente;
import hn.unah.lenguajes.proyecto.backend.Services.PacienteService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Crear un nuevo paciente
    @PostMapping("/crearPaciente")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    // Mostrar historial clínico del paciente
    @GetMapping("/{idPaciente}/historial")
    public ResponseEntity<List<Cita>> mostrarHistorialClinico(@PathVariable Integer idPaciente) {
        List<Cita> historial = pacienteService.mostrarHistorialClinico(idPaciente);
        return ResponseEntity.ok(historial);
    }

    // Mostrar si el paciente tiene cita pendiente
    @GetMapping("/{idPaciente}/pendientes")
    public ResponseEntity<Boolean> tieneCitaPendiente(@PathVariable Integer idPaciente) {
        boolean tienePendientes = pacienteService.tieneCitaPendiente(idPaciente);
        return ResponseEntity.ok(tienePendientes);
    }
}

