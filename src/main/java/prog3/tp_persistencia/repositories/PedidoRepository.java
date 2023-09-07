package prog3.tp_persistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prog3.tp_persistencia.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
