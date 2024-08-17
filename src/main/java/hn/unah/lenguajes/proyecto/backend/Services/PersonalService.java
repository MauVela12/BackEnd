package hn.unah.lenguajes.proyecto.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.proyecto.backend.Entities.Personal;
import hn.unah.lenguajes.proyecto.backend.Repositories.CargoRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.EspecialidadRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.PersonalRepository;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Personal crearPersonal(Personal nvoPersonal) {
        if (this.personalRepository.existsById(nvoPersonal.getId())) {
            return null;
        } else {

            this.personalRepository.save(nvoPersonal);

            return nvoPersonal;
        }
    }

    public boolean borrarPersonal(int id) {

        if (this.personalRepository.existsById(id) == false) {
            return false;
        }else {
            this.personalRepository.deleteById(id);

            return true;
        }
    }

    public Personal buscarPersonalPorId(int id) {
        if (this.personalRepository.existsById(id)) {
            return this.personalRepository.findById(id).get();
        }else {
            return null;
        }
    }

    public boolean asignarCargoPersonal(int idPersonal, int idCargo) {
        if (this.personalRepository.existsById(idPersonal) == false || this.cargoRepository.existsById(idCargo) == false) {
            return false;
        }else {

            Personal personal = this.personalRepository.findById(idPersonal).get();

            personal.setCargo(this.cargoRepository.findById(idCargo).get());

            this.personalRepository.save(personal);

            return true;
        }
    }

    public boolean asignarEspecialidadPersonal(int idPersonal, int idEspecialidad) {
        if (this.personalRepository.existsById(idPersonal) == false || this.especialidadRepository.existsById(idEspecialidad) == false) {
            return false;
        }else {

            Personal personal = this.personalRepository.findById(idPersonal).get();

            personal.setEspecialidad(this.especialidadRepository.findById(idEspecialidad).get());

            this.personalRepository.save(personal);

            return true;
        }
    }
}


