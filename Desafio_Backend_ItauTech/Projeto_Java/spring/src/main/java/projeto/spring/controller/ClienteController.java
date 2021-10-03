package projeto.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.spring.model.Cliente;
import projeto.spring.repository.ClienteRepo;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteRepo repo;

    //************ Teste dos clientes *************/
    @GetMapping() // Buscar todos os clientes
    public List<Cliente> obterTodos() {
        return (List<Cliente>) repo.findAll(); 
    }

    // *********** Cadastro dos novos clientes ************
    @PostMapping("/novo") // Adicionar novos
    public ResponseEntity<Cliente> novoCliente(@RequestBody Cliente cliente) { 
        if (cliente.getCodigo() != 0) {
            return ResponseEntity.status(400).build(); 
        }
        Cliente novoCliente = repo.save(cliente);
        return ResponseEntity.status(201).body(novoCliente); 
    }

    // *********** Deletar cadastro ************
    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<Void> apagarTitular(@PathVariable long codigo) {
        Cliente clienteEncontrado = repo.findById(codigo).orElse(null);

        if (clienteEncontrado == null) {
            return ResponseEntity.status(404).build();
        }

        repo.deleteById(codigo);
        return ResponseEntity.ok().build();
    }
}
