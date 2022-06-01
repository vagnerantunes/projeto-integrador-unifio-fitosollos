package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Crq;

@Repository
public interface CrqRepository extends JpaRepository<Crq, Long> {

}