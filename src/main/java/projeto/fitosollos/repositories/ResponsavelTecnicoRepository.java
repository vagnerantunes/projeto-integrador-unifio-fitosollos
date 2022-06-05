package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.ResponsavelTecnico;

@Repository
public interface ResponsavelTecnicoRepository extends JpaRepository<ResponsavelTecnico, Integer> {

}