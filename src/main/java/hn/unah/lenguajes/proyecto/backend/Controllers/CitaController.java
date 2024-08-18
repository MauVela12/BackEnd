package hn.unah.lenguajes.proyecto.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hn.unah.lenguajes.proyecto.backend.Entities.Cita;
import hn.unah.lenguajes.proyecto.backend.Services.CitaService;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Crear una nueva cita
    @PostMapping("/crearCita")
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.crearCita(cita);
        return ResponseEntity.ok(nuevaCita);
    }

    //asignarhorariocita
    @PutMapping("asignarHorarioCita/{idCita}/{fecha}/{hora}")
    public String asignarHorario(@PathVariable(name = "idCita") int idCita, 
                                @PathVariable(name = "fecha") Date fecha,
                                @PathVariable(name = "hora") Time hora) {
        
        if (this.citaService.asignarHorarioCita(idCita, fecha, hora)) {
            return "Horario asignado con exito\n";
        }else {
            return "Error al asignar horario\n";
        }
    }

   // Agregar cita a un doctor
   @PutMapping("/agregarDoctor")
   public Cita agregarCitaADoctor(@RequestParam int idDoctor, @RequestParam int idCita) {
       return citaService.agregarCitaADoctor(idDoctor, idCita);

   }

    // Cambiar la fecha de una cita
    @PutMapping("/{idCita}/fecha")
    public ResponseEntity<Void> cambiarFechaCita(@PathVariable Integer idCita, @RequestParam Date nuevaFecha) {
        citaService.cambiarFechaCita(idCita, nuevaFecha);
        return ResponseEntity.noContent().build();
    }

    //asignar paciente a la cita
    @PutMapping("asignarPaciente/{idCita}/{idPaciente}")
    public String asignarPaciente(@PathVariable(name = "idCita") int idCita, @PathVariable(name = "idPaciente") int idPaciente) {
        
        if (this.citaService.agregarCitaAPaciente(idPaciente, idCita)) {
            return "Paciente agregado correctamente\n";
        }else {
            return "Error al asignar paciente\n";
        }
    }

    // Buscar una cita por ID
    @GetMapping("buscarPorId/{idCita}")
    public ResponseEntity<Optional<Cita>> buscarCita(@PathVariable Integer idCita) {
        Optional<Cita> cita = citaService.buscarCita(idCita);
        return ResponseEntity.ok(cita);
    }

    // Mostrar historial clínico del paciente
    @GetMapping("/paciente/historial/{idPaciente}")
    public ResponseEntity<List<Cita>> mostrarHistorialClinico(@PathVariable Integer idPaciente) {
        List<Cita> historial = citaService.mostrarHistorialClinico(idPaciente);
        return ResponseEntity.ok(historial);
    }

    // Mostrar si el paciente tiene cita pendiente
    @GetMapping("/paciente/citasPendientes/{idPaciente}")
    public List<Cita> tieneCitaPendiente(@PathVariable Integer idPaciente) {
        return this.citaService.tieneCitaPendiente(idPaciente);
    }
}
