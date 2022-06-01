package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Amostra;

@Repository
public interface AmostraRepository extends JpaRepository<Amostra, Long> {

	
}
