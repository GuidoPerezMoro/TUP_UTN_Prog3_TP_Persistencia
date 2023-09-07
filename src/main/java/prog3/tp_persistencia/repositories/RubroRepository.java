package prog3.tp_persistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prog3.tp_persistencia.entities.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
}
