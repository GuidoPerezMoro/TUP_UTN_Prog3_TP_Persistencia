package prog3.tp_persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import prog3.tp_persistencia.entities.*;
import prog3.tp_persistencia.enums.Estado;
import prog3.tp_persistencia.enums.FormaPago;
import prog3.tp_persistencia.enums.TipoEnvio;
import prog3.tp_persistencia.enums.TipoProducto;
import prog3.tp_persistencia.repositories.*;
import java.util.Date;

@SpringBootApplication
public class TpPersistenciaApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ConfiguracionGeneralRepository configuracionGeneralRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpPersistenciaApplication.class, args);
		System.out.println("Cruza los dedos");
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
			System.out.println("---------------ESTOY FUNCIONANDO EN BEAN---------------");

			//CONFIGURACIÓN GENERAL
			ConfiguracionGeneral configuracionGeneral = ConfiguracionGeneral.builder().cantidadCocineros(1). emailEmpresa("rotiseria@gmail.com").tokenMercadoPago("682").build();
			configuracionGeneralRepo.save(configuracionGeneral);

			//CLIENTES
			Cliente cliente1 = Cliente.builder().nombre("Ariana").apellido("Grande").telefono("261777777").email("ariana_grande@gmail.com").build();
			Cliente cliente2 = Cliente.builder().nombre("Bruno").apellido("Chiquito").telefono("266333333").email("bruno_chiquito@gmail.com").build();
			clienteRepo.save(cliente1);
			clienteRepo.save(cliente2);

			//DOMICILIOS
			Domicilio domicilio1 = Domicilio.builder().calle("Falsa").numero("123").localidad("Godoy Cruz").build();
			Domicilio domicilio2 = Domicilio.builder().calle("Vicente Gil").numero("821").localidad("Godoy Cruz").build();
			Domicilio domicilio3 = Domicilio.builder().calle("Alameda").numero("1439").localidad("Godoy Cruz").build();
			domicilioRepo.save(domicilio1);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);

			//RELACION DOMICILIO-CLIENTE N-1
			domicilio1.setCliente(cliente1);
			domicilio2.setCliente(cliente1);
			domicilio3.setCliente(cliente2);
			domicilioRepo.save(domicilio1);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);

			//USUARIOS
			Usuario usuario1 = Usuario.builder().nombre("Guido Pérez Moro").password("admin").rol("administrador").build();
			Usuario usuario2 = Usuario.builder().nombre("Milagros Escudero").password("gatitos").rol("cocinera").build();
			Usuario usuario3 = Usuario.builder().nombre("Mario Papetti").password("python").rol("repartidor").build();
			usuarioRepo.save(usuario1);
			usuarioRepo.save(usuario2);
			usuarioRepo.save(usuario3);

			//RUBROS
			Rubro rubro1 = Rubro.builder().denominacion("pastas").build();
			Rubro rubro2 = Rubro.builder().denominacion("sandwiches").build();
			Rubro rubro3 = Rubro.builder().denominacion("acompañamientos").build();
			rubroRepo.save(rubro1);
			rubroRepo.save(rubro2);
			rubroRepo.save(rubro3);

			//PRODUCTOS
			Producto producto1 = Producto.builder().tipo(TipoProducto.MANUFACTURADO).denominacion("Fideos").precioCompra(100).precioVenta(140).stockActual(12).stockMinimo(9).unidadMedida("platos").foto("foto de fideos con salsa").receta("Cocinar fideos. Agregar salsa.").build();
			Producto producto2 = Producto.builder().tipo(TipoProducto.MANUFACTURADO).denominacion("Hamburguesa").precioCompra(200).precioVenta(300).stockActual(20).stockMinimo(15).unidadMedida("unidades").foto("foto de hamburguesa").receta("Pan, queso, hamburguesa. Cocinar carne. Armar sandwich.").build();
			Producto producto3 = Producto.builder().tipo(TipoProducto.MANUFACTURADO).denominacion("Lomo").precioCompra(280).precioVenta(400).stockActual(8).stockMinimo(5).unidadMedida("unidades").foto("foto de lomo de carne").receta("Pan, queso, bife. Cocinar carne. Armar sandwich.").build();
			Producto producto4 = Producto.builder().tipo(TipoProducto.MANUFACTURADO).denominacion("Papas fritas").precioCompra(90).precioVenta(180).stockActual(30).stockMinimo(10).unidadMedida("grande").foto("foto de papas fritas").receta("Freir papas peladas. Salar.").build();
			productoRepo.save(producto1);
			productoRepo.save(producto2);
			productoRepo.save(producto3);
			productoRepo.save(producto4);

			//RELACION RUBRO-PRODUCTO 1-N
			rubro1.agregarProducto(producto1);
			rubro2.agregarProducto(producto2);
			rubro2.agregarProducto(producto3);
			rubro3.agregarProducto(producto4);
			rubroRepo.save(rubro1);
			rubroRepo.save(rubro2);
			rubroRepo.save(rubro3);

			//DETALLE_PEDIDO
			DetallePedido detallePedido1 = DetallePedido.builder().cantidad(2).build();
			DetallePedido detallePedido2 = DetallePedido.builder().cantidad(2).subtotal(180).build();
			DetallePedido detallePedido3 = DetallePedido.builder().cantidad(2).subtotal(560).build();
			DetallePedido detallePedido4 = DetallePedido.builder().cantidad(2).subtotal(180).build();
			DetallePedido detallePedido5 = DetallePedido.builder().cantidad(1).subtotal(200).build();
			detallePedidoRepo.save(detallePedido1);
			detallePedidoRepo.save(detallePedido2);
			detallePedidoRepo.save(detallePedido3);
			detallePedidoRepo.save(detallePedido4);
			detallePedidoRepo.save(detallePedido5);

			//RELACION DETALLE_PRODUCTO-PRODUCTO N-1
			detallePedido1.setProducto(producto2);
			detallePedido1.calcularSubtotal();
			detallePedido2.setProducto(producto4);
			detallePedido2.calcularSubtotal();
			detallePedido3.setProducto(producto3);
			detallePedido3.calcularSubtotal();
			detallePedido4.setProducto(producto4);
			detallePedido4.calcularSubtotal();
			detallePedido5.setProducto(producto1);
			detallePedido5.calcularSubtotal();
			detallePedidoRepo.save(detallePedido1);
			detallePedidoRepo.save(detallePedido2);
			detallePedidoRepo.save(detallePedido3);
			detallePedidoRepo.save(detallePedido4);
			detallePedidoRepo.save(detallePedido5);

			//FACTURAS
			Factura factura1 = Factura.builder().numero(11).descuento(0).formaPago(FormaPago.TRANSFERENCIA).total(1000).build();
			Factura factura2 = Factura.builder().numero(12).descuento(10).formaPago(FormaPago.MERCADOPAGO).total(1800).build();
			Factura factura3 = Factura.builder().numero(13).descuento(5).formaPago(FormaPago.EFECTIVO).total(1425).build();
			facturaRepo.save(factura1);
			facturaRepo.save(factura2);
			facturaRepo.save(factura3);

			//PEDIDOS
			Pedido pedido1 = Pedido.builder().fecha("04-09-23").estado(Estado.INICIADO).tipoEnvio(TipoEnvio.DELIVERY).build();
			Pedido pedido2 = Pedido.builder().fecha("04-09-23").estado(Estado.PREPARADO).tipoEnvio(TipoEnvio.DELIVERY).build();
			Pedido pedido3 = Pedido.builder().fecha("04-09-23").estado(Estado.ENTREGADO).tipoEnvio(TipoEnvio.RETIRA).build();
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);
			pedidoRepo.save(pedido3);

			//RELACION PEDIDO-DETALLE_PEDIDO 1-N
			pedido1.agregarDetalle(detallePedido1);
			pedido1.agregarDetalle(detallePedido2);
			pedido2.agregarDetalle(detallePedido3);
			pedido2.agregarDetalle(detallePedido4);
			pedido3.agregarDetalle(detallePedido5);
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);
			pedidoRepo.save(pedido3);

			//RELACION PEDIDO-FACTURA 1-1
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			pedido3.setFactura(factura3);
			pedido1.calcularTotal();
			pedido2.calcularTotal();
			pedido3.calcularTotal();
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);
			pedidoRepo.save(pedido3);

			//RELACION USUARIO-PEDIDO 1-N
			usuario2.agregarPedido(pedido1);
			usuario3.agregarPedido(pedido2);
			usuario1.agregarPedido(pedido3);
			usuarioRepo.save(usuario1);
			usuarioRepo.save(usuario2);
			usuarioRepo.save(usuario3);

			//RELACION CLIENTE-PEDIDO 1-N
			cliente1.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);
			clienteRepo.save(cliente1);
			clienteRepo.save(cliente2);

			//RELACION DOMICILIO-PEDIDO 1-N
			domicilio1.agregarPedido(pedido1);
			domicilio3.agregarPedido(pedido2);
			domicilio3.agregarPedido(pedido3);
			domicilioRepo.save(domicilio1);
			//domicilioRepo.save(domicilio2); //No se hicieron pedidos desde domicilio2
			domicilioRepo.save(domicilio3);
		};
	}

}
