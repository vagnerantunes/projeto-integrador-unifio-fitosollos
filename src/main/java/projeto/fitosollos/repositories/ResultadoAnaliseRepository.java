package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.ResultadoAnalise;

@Repository
public interface ResultadoAnaliseRepository extends JpaRepository<ResultadoAnalise, Long> {

}