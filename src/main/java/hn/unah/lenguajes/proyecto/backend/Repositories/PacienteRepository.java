package hn.unah.lenguajes.proyecto.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.proyecto.backend.Entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    // Métodos adicionales si es necesario
}

