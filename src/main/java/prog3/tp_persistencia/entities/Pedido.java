package prog3.tp_persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {
    private String fecha;
    private enum estado {INICIADO, PREPARACION, ENTREGADO};
    private Date horaEstimadaEntrega;
    private enum tipoEnvio {DELIVERY, RETIRA};
    private double total;
}
