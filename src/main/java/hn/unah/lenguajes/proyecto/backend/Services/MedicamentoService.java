package hn.unah.lenguajes.proyecto.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.proyecto.backend.Entities.Medicamento;
import hn.unah.lenguajes.proyecto.backend.Repositories.MedicamentoRepository;


@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> buscarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento buscarPorNombre(String nombre) {
        return medicamentoRepository.findByNombre(nombre);
    }

    public Medicamento agregarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void reducirInventario(int idMedicamento, int cantidad) {
        Medicamento medicamento = medicamentoRepository.findById(idMedicamento)
            .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
        if (medicamento.getCantidadDisponibles() < cantidad) {
            throw new RuntimeException("Inventario insuficiente");
        }
        medicamento.setCantidadDisponibles(medicamento.getCantidadDisponibles() - cantidad);
        medicamentoRepository.save(medicamento);
    }
}
