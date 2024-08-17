package hn.unah.lenguajes.proyecto.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.proyecto.backend.Entities.Horario;
import hn.unah.lenguajes.proyecto.backend.Entities.Personal;
import hn.unah.lenguajes.proyecto.backend.Repositories.HorarioRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.PersonalRepository;

@Service
public class HorarioService{

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private PersonalRepository personalRepository;

    public boolean asignarHorario(int id, Horario nvohorario) {

        if (this.personalRepository.existsById(id) == false) {
            return false;
        }else {

            Personal personal = this.personalRepository.findById(id).get();

            if (personal.getHorario() != null) {
                
                return false;
            }else {
                personal.setHorario(nvohorario);

                this.horarioRepository.save(nvohorario);
                this.personalRepository.save(personal);

                return true;
            }

            
        }
    }

    public boolean modificarHorario(int id, Horario horario) {
        if (this.personalRepository.existsById(id) == false) {
            return false;
        }else {

            Personal personalModificar = this.personalRepository.findById(id).get();
            
            if (personalModificar.getHorario() == null) {
                return false;
            }else {
                
                personalModificar.getHorario().setHoraInicio(horario.getHoraInicio());
                personalModificar.getHorario().setHoraFinal(horario.getHoraFinal());
                personalModificar.getHorario().setDias(horario.getDias());

                this.horarioRepository.save(personalModificar.getHorario());
                this.personalRepository.save(personalModificar);

                return true;
            }
        }
    }
    
}
