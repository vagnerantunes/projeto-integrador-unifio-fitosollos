package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.TipoAnalise;

@Repository
public interface TipoAnaliseRepository extends JpaRepository<TipoAnalise, Integer> {
	
}
