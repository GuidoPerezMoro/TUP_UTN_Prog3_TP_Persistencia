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
@Table(name = "factura")
public class Factura {
    private Date fecha;
    private int numero;
    private double descuento;
    private enum formaPago {EFECTIVO, TRANSFERENCIA, MERCADOPAGO, MODO, DEBITO, CREDITO, CHEQUE};
    private double total;
}
