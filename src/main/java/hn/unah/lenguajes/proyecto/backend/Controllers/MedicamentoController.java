package hn.unah.lenguajes.proyecto.backend.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.proyecto.backend.Entities.Medicamento;
import hn.unah.lenguajes.proyecto.backend.Services.MedicamentoService;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/buscarMedicamentos")
    public ResponseEntity<List<Medicamento>> buscarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.buscarMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }

    @GetMapping("buscarPorNombre/{nombre}")
    public ResponseEntity<Medicamento> buscarPorNombre(@PathVariable String nombre) {
        Medicamento medicamento = medicamentoService.buscarPorNombre(nombre);
        if (medicamento != null) {
            return ResponseEntity.ok(medicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/agregarMedicamento")
    public Medicamento agregarMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoService.agregarMedicamento(medicamento);
    }

    @PutMapping("/reducir/{idMedicamento}/{cantidad}")
    public ResponseEntity<String> reducirInventario(@PathVariable(name = "idMedicamento") int idMedicamentos, @PathVariable(name = "cantidad") int cantidad) {
        try {
            medicamentoService.reducirInventario(idMedicamentos, cantidad);
            return ResponseEntity.ok("Inventario actualizado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
