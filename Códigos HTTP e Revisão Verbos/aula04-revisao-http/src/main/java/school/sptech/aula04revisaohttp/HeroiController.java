package school.sptech.aula04revisaohttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    // Criação de Lista
    private List<Heroi> herois = new ArrayList<>();

    // Listar
    //http://localhost:8080/herois
    @GetMapping
    public List<Heroi> listar() {
        return herois;
    }

    // Boolean IsIndiceValido
    public boolean isIndiceValido(int indice) {
        return indice >= 0 && indice < this.herois.size();
    }

    // Boolean Cadastro Inválido
    public boolean cadastrarInvalido(Heroi heroi) {
        if (heroi.getNome().length() < 3 || heroi.getNome().isBlank() || heroi.getHabilidade().length() < 3 || heroi.getHabilidade().isBlank() || heroi.getIdade() <= 0 || heroi.getForca() < 0 || heroi.getForca() > 100) {
            return true;
        } else {
            return false;
        }
    }

    // a) ListarPorIndice
    //http://localhost:8080/herois/0
    @GetMapping("/{indece}")
    public ResponseEntity<Heroi> listarPorIndice(@PathVariable int indece) {
        if (isIndiceValido(indece)) {
            return ResponseEntity.status(200).body(herois.get(indece));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    //b) Cadastrar
    //http://localhost:8080/herois
    @PostMapping
    public ResponseEntity<Heroi> cadastrar(@RequestBody Heroi heroi) {
        if (cadastrarInvalido(heroi)) {
            return ResponseEntity.status(400).build();
        } else {
            herois.add(heroi);
            return ResponseEntity.status(200).body(heroi);
        }
    }

    //c) Atualizar
    //http://localhost:8080/herois/0
    @PutMapping("/{indece}")
    public ResponseEntity<Heroi> atualizarIndice(@PathVariable int indece, @RequestBody Heroi heroi) {
        if (isIndiceValido(indece) && !cadastrarInvalido(heroi)) {
            herois.set(indece, heroi);
            return ResponseEntity.status(200).body(heroi);
        } else if (!isIndiceValido(indece)) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    //d) Delete
    //http://localhost:8080/herois/0
    @DeleteMapping("/{indece}")
    public ResponseEntity<Void> deletar(@PathVariable int indece) {
        if (isIndiceValido(indece)) {
            herois.remove(indece);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }


    }

}
