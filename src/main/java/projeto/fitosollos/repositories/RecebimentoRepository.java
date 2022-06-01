package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Recebimento;

@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {

	
}
