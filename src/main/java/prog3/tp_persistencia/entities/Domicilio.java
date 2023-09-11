package prog3.tp_persistencia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad {
    private String calle;
    private String numero;
    private String localidad;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true /*Composición??*/, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
