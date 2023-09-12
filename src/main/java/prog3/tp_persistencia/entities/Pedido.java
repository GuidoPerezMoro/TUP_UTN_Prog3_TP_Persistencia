package prog3.tp_persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import prog3.tp_persistencia.enums.Estado;
import prog3.tp_persistencia.enums.TipoEnvio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {
    private String fecha;
    private Estado estado;
    private Date horaEstimadaEntrega;
    private TipoEnvio tipoEnvio;
    private double total = 0;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();
    public void agregarDetalle(DetallePedido detallePedido) {
        detallesPedido.add(detallePedido);
    }

    public void calcularTotal() {
        for (DetallePedido detalle:detallesPedido)
            total += detalle.getSubtotal() * (1 - getFactura().getDescuento() / 100);
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;


}
