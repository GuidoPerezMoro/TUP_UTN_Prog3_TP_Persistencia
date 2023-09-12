package prog3.tp_persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "detalle_pedido")
public class DetallePedido extends BaseEntidad {
    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public void calcularSubtotal() {
        subtotal = cantidad*producto.getPrecioVenta();
    }
}
