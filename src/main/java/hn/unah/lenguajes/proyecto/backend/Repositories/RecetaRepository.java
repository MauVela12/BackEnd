package hn.unah.lenguajes.proyecto.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.proyecto.backend.Entities.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer>{

}
