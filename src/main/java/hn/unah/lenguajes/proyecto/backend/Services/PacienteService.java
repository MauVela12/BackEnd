package hn.unah.lenguajes.proyecto.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.proyecto.backend.Entities.Paciente;
import hn.unah.lenguajes.proyecto.backend.Repositories.CitaRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.DireccionRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.PacienteRepository;
import java.time.LocalDate;
import hn.unah.lenguajes.proyecto.backend.Entities.Cita;
import java.util.List;



@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    // Crear paciente
    public Paciente crearPaciente(Paciente paciente) {
        this.direccionRepository.save(paciente.getDireccion());
        return pacienteRepository.save(paciente);
    }

    /*
    // Mostrar historial clínico del paciente
    public List<Cita> mostrarHistorialClinico(Integer idPaciente) {
        return citaRepository.findByPacienteId(idPaciente);
    }

    // Mostrar si el paciente tiene cita pendiente
    public boolean tieneCitaPendiente(Integer idPaciente) {
        List<Cita> citasPendientes = citaRepository.findByPacienteIdAndFechaCitaGreaterThanEqualAndEstadoIdNot(idPaciente, LocalDate.now(), 1);
        return !citasPendientes.isEmpty();
    }*/

    public PacienteService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    // Mostrar historial clínico del paciente
    public List<Cita> mostrarHistorialClinico(Integer idPaciente) {
        return citaRepository.findByPacienteIdPaciente(idPaciente);
    }

    // Mostrar si el paciente tiene cita pendiente
    public boolean tieneCitaPendiente(Integer idPaciente) {
        List<Cita> citasPendientes = citaRepository.findByPacienteIdPacienteAndFechaCitaGreaterThanEqualAndEstadoIdEstadosNot(idPaciente, LocalDate.now(), 1);
        return !citasPendientes.isEmpty();
    }

}
