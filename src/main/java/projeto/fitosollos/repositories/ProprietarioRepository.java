package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>{

}
