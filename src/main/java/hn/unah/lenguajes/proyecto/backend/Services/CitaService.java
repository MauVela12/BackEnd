package hn.unah.lenguajes.proyecto.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.proyecto.backend.Entities.Cita;
import hn.unah.lenguajes.proyecto.backend.Entities.Paciente;
import hn.unah.lenguajes.proyecto.backend.Entities.Personal;
import hn.unah.lenguajes.proyecto.backend.Entities.Receta;
import hn.unah.lenguajes.proyecto.backend.Repositories.CitaRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.PacienteRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.PersonalRepository;
import hn.unah.lenguajes.proyecto.backend.Repositories.RecetaRepository;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private RecetaRepository recetaRepository;

    // Crear cita
    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public boolean asignarHorarioCita(int idCita, Date fecha, Time hora) {
        if (this.citaRepository.existsById(idCita)) {
            Cita citaModificar = this.citaRepository.findById(idCita).get();

            citaModificar.setFechaCita(fecha);
            citaModificar.setHoraCita(hora);

            this.citaRepository.save(citaModificar);

            return true;
        }else {
            return false;
        }
    }


    // Agregar cita a un paciente
    public boolean agregarCitaAPaciente(int idPaciente, int idcita) {
        if (this.citaRepository.existsById(idcita)) {
            Cita citaModificar = this.citaRepository.findById(idcita).get();
            Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
            citaModificar.setPaciente(paciente);
            citaRepository.save(citaModificar);
            return true;
        }else {
            return false;
        }
    }

    public Cita agregarCitaADoctor(int idPersonal, int idCita) {
        if (this.personalRepository.existsById(idPersonal) && this.citaRepository.existsById(idCita)) {
            Cita nCita = this.citaRepository.findById(idCita).get();
            Personal nPersonal = this.personalRepository.findById(idPersonal).get();
            if (nPersonal.getCargo().getIdCargo() != 1 ) {
                return null;
            } else {
                nCita.setDoctor(nPersonal);
                this.citaRepository.save(nCita);
                return nCita;
            }
        }else
            return null;
    }

    // Cambiar la fecha de una cita
    public void cambiarFechaCita(Integer idCita, Date nuevaFecha) {
        Cita cita = citaRepository.findById(idCita).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setFechaCita(nuevaFecha);
        citaRepository.save(cita);
    }

    // Buscar una cita por ID
    public Optional<Cita> buscarCita(Integer idCita) {
        return citaRepository.findById(idCita);
    }

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    
    public List<Cita> mostrarHistorialClinico(Integer idPaciente) {
        return citaRepository.findByPacienteIdPaciente(idPaciente);
    }

    
    public List<Cita> tieneCitaPendiente(Integer idPaciente) {
        List<Cita> citasPaciente = this.citaRepository.findByPacienteIdPaciente(idPaciente);
        List<Cita> citasPendientes = new ArrayList<>();

        for (Cita cita : citasPaciente) {
            if (cita.getEstado().getIdEstados() == 1) {
                citasPendientes.add(cita);
            }
        }

        return citasPendientes;
    }

    public boolean agregarRecetaCita(int idCita, Receta receta) {
        if (this.citaRepository.existsById(idCita)) {
            Cita citaModificar = this.citaRepository.findById(idCita).get();
            receta.setCita(citaModificar);
            this.medicamentoService.reducirInventario(idCita, receta.getCantidadMedicamento());
            this.recetaRepository.save(receta);

            return true;
        }else {
            return false;
        }
    }

}
