package projeto.spring.repository;

import org.springframework.data.repository.CrudRepository;
import projeto.spring.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Long> {
}
