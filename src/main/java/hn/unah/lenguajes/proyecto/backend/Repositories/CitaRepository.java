package hn.unah.lenguajes.proyecto.backend.Repositories;

/*import org.springframework.data.jpa.repository.JpaRepository; 
import hn.unah.lenguajes.proyecto.backend.Entities.Cita;
import hn.unah.lenguajes.proyecto.backend.Entities.Paciente;

import java.util.List; 
 
public interface CitaRepository extends JpaRepository<Cita, Integer> { 
    // Puedes usar esta versión si 'idPaciente' es el nombre correcto del campo 
    List<Cita> findByPacienteIdPaciente(Integer idPaciente); 
     
    // Alternativamente, esta versión puede funcionar 
    List<Cita> findByPaciente(Paciente paciente); 
}*/

import org.springframework.data.jpa.repository.JpaRepository; 
import hn.unah.lenguajes.proyecto.backend.Entities.Cita; 
import java.time.LocalDate; 
import java.util.List; 
 
public interface CitaRepository extends JpaRepository<Cita, Integer> { 
 
    // Buscar por paciente 
    List<Cita> findByPacienteIdPaciente(Integer idPaciente); 
 
    // Buscar por paciente y fecha de cita mayor o igual que la fecha actual, y estado diferente de 1 
    List<Cita> findByPacienteIdPacienteAndFechaCitaGreaterThanEqualAndEstadoIdEstadosNot(Integer idPaciente, LocalDate fechaCita, Integer estadoId); 
}

