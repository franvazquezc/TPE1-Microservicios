package repository;

import model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryTarifa extends JpaRepository<Tarifa, Integer> {
}
