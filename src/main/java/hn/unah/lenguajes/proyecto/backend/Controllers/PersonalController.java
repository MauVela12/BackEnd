package hn.unah.lenguajes.proyecto.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.proyecto.backend.Entities.Personal;
import hn.unah.lenguajes.proyecto.backend.Services.PersonalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/Personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    
    @PostMapping("contratar")
    public Personal contratarPersonal(@RequestBody Personal nuevoPersonal) {
        return this.personalService.crearPersonal(nuevoPersonal);
    }

    @DeleteMapping("despedir/{id}")
    public String despedirPersonal(@PathVariable(name = "id") int id) {
        if (this.personalService.borrarPersonal(id)) {
            return "Depedido";
        }else {
            return "No se encontro la entidad";
        }
    }

    @GetMapping("buscarPorId/{id}")
    public Personal buscarPersonal(@PathVariable(name = "id") int id) {
        return this.personalService.buscarPersonalPorId(id);
    }

    @PutMapping("asignarCargo/{idPersonal}/{idCargo}")
    public String asignarCargo(@PathVariable(name = "idPersonal") int idPersonal,
                                @PathVariable(name = "idCargo") int idCargo) {
        
        if (this.personalService.asignarCargoPersonal(idPersonal, idCargo)) {
            return "Cargo asignado correctamente\n";
        }else {
            return "No se encontro alguna entidad\n";
        }
    }

    @PutMapping("asignarEspecialidad/{idPersonal}/{idEspecialidad}")
    public String asignarEspecialidad(@PathVariable(name = "idPersonal") int idPersonal,
                                      @PathVariable(name = "idEspecialidad") int idEspecialidad) {
        if (this.personalService.asignarEspecialidadPersonal(idPersonal, idEspecialidad)) {
            return "Especialidad asignada correctamente\n";
        }else {
            return "No se encontro alguna entidad\n";
        }
    }
    
}
