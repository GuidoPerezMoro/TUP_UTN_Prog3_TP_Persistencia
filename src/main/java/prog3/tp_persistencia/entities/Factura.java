package prog3.tp_persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import prog3.tp_persistencia.enums.FormaPago;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad{
    private Date fecha;
    private int numero;
    private double descuento;
    private FormaPago formaPago;
    private double total;
}
