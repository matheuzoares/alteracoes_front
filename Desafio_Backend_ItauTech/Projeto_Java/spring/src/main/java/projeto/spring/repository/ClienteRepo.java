package projeto.spring.repository;

import org.springframework.data.repository.CrudRepository;
import projeto.spring.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long> {
}
