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
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();
    public void agregarDetalle(DetallePedido detallePedido) {
        detallesPedido.add(detallePedido);
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;
}
