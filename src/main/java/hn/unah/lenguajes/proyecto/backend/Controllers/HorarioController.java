package hn.unah.lenguajes.proyecto.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.proyecto.backend.Entities.Horario;
import hn.unah.lenguajes.proyecto.backend.Services.HorarioService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/horario")
public class HorarioController {
    
    @Autowired
    private HorarioService horarioService;

    @PutMapping("asignarHorario/{id}")
    public String asignar(@PathVariable(name = "id") int id,
                          @RequestBody Horario horario) {
        if (this.horarioService.asignarHorario(id, horario)) {
            return "Horario asignado correctamente\n";
        }else {
            return "Error, personal ya tiene horario o no existe\n";
        }
    }

    @PutMapping("modificarHorario/{id}")
    public String modificar(@PathVariable(name = "id") int id,
                                @RequestBody Horario horario) {
        
        if (this.horarioService.modificarHorario(id, horario)) {
            return "Horario modificado correctamente\n";
        }else {
            return "Error, personal no tiene horario o no existe\n";
        }
    }
}
