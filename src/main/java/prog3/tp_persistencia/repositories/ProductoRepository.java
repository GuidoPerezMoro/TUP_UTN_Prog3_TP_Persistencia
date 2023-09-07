package prog3.tp_persistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prog3.tp_persistencia.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
