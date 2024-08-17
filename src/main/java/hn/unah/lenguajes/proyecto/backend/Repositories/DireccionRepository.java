package hn.unah.lenguajes.proyecto.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hn.unah.lenguajes.proyecto.backend.Entities.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{
    
}
