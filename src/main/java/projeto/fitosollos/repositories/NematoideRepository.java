package projeto.fitosollos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.fitosollos.entities.Nematoide;

@Repository
public interface NematoideRepository extends JpaRepository<Nematoide, Long> {

}
