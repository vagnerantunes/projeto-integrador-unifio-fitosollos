package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Cultura;

@Repository
public interface CulturaRepository extends JpaRepository<Cultura, Integer> {

}