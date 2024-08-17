package hn.unah.lenguajes.proyecto.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import hn.unah.lenguajes.proyecto.backend.Entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
    Medicamento findByNombre(String nombre);
        
    } 
