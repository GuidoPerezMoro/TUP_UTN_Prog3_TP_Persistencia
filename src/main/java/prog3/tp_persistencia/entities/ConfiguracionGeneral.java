package prog3.tp_persistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "configuracion_general")
public class ConfiguracionGeneral extends BaseEntidad {
    private int cantidadCocineros;
    private String emailEmpresa;
    private String tokenMercadoPago;

}
