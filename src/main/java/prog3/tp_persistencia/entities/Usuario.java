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
@Table(name = "usuario")
public class Usuario extends BaseEntidad {
    private String nombre;
    private String password;
    private String rol;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

}
