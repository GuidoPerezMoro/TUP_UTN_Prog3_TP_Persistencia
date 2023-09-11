package prog3.tp_persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import prog3.tp_persistencia.repositories.*;

@SpringBootApplication
public class TpPersistenciaApplication {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	ConfiguracionGeneralRepository configuracionGeneralRepo;
	@Autowired
	DetallePedidoRepository detallePedidoRepo;
	@Autowired
	DomicilioRepository domicilioRepo;
	@Autowired
	FacturaRepository facturaRepo;
	@Autowired
	PedidoRepository pedidoRepo;
	@Autowired
	ProductoRepository productoRepo;
	@Autowired
	RubroRepository rubroRepo;
	@Autowired
	UsuarioRepository usuarioRepo;

	public static void main(String[] args) {
		SpringApplication.run(TpPersistenciaApplication.class, args);
		System.out.println("Estoy funcionando :D");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo,
						   ConfiguracionGeneralRepository configuracionGeneralRepo,
						   DetallePedidoRepository detallePedidoRepo,
						   DomicilioRepository domicilioRepo,
						   FacturaRepository facturaRepo,
						   PedidoRepository pedidoRepo,
						   ProductoRepository productoRepo,
						   RubroRepository rubroRepo,
						   UsuarioRepository usuarioRepo) {
		return args -> {
			System.out.println("---------------ESTOY FUNCIONANDO---------------");

			//Creamos objetos usando el método builder()




		};
	}

}
