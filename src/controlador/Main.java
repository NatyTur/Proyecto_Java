
package controlador;

import modelo.Cliente;
import vista.VistaClientes;
import vista.VistaNuevoCliente;
import vista.VistaBusquedaClientes;
import vista.VistaPrincipal;
import modelo.DDBB;
import modelo.Pedido;
import modelo.Producto;
import vista.VistaBusquedaPedidos;
import vista.VistaBusquedaProductos;
import vista.VistaEditarCliente;
import vista.VistaEditarPedido;
import vista.VistaEditarProducto;
import vista.VistaNuevoPedido;
import vista.VistaNuevoProducto;
import vista.VistaPedidos;
import vista.VistaProductos;
import vista.VistaProductosPedidos;
import vista.VistaSeleccionCliente;
public class Main {

   
    public static void main(String[] args) {
        
       Controlador miControlador = new Controlador();
       VistaPrincipal miVistaPrincipal = new VistaPrincipal(); 
       VistaClientes miVistaClientes = new VistaClientes();
       VistaProductos miVistaProductos = new VistaProductos();
       VistaPedidos miVistaPedidos = new VistaPedidos();
       VistaNuevoCliente miVistaNuevoCliente = new VistaNuevoCliente();
       VistaNuevoProducto miVistaNuevoProducto = new VistaNuevoProducto();
       VistaNuevoPedido miVistaNuevoPedido = new VistaNuevoPedido();
       VistaEditarCliente miVistaEditarCliente = new VistaEditarCliente();
       VistaEditarProducto miVistaEditarProducto = new VistaEditarProducto();
       VistaEditarPedido miVistaEditarPedido = new VistaEditarPedido();
       VistaBusquedaClientes miVistaBusquedaClientes = new VistaBusquedaClientes();
       VistaBusquedaProductos miVistaBusquedaProductos = new VistaBusquedaProductos();
       VistaBusquedaPedidos miVistaBusquedaPedidos = new VistaBusquedaPedidos();
       VistaSeleccionCliente miVistaSeleccionCliente = new VistaSeleccionCliente();
       VistaProductosPedidos miVistaProductosPedidos = new VistaProductosPedidos();
       Cliente miCliente = new Cliente();
       Pedido miPedido = new Pedido();
       Producto miProducto = new Producto();
       DDBB miDDBB = new DDBB();
       
       
       miVistaPrincipal.setControlador(miControlador);
       miVistaClientes.setControlador(miControlador);
       miVistaProductos.setControlador(miControlador);
       miVistaPedidos.setControlador(miControlador);
       miVistaNuevoCliente.setControlador(miControlador);
       miVistaNuevoProducto.setControlador(miControlador);
       miVistaNuevoPedido.setControlador(miControlador);
       miVistaEditarCliente.setControlador(miControlador);
       miVistaEditarProducto.setControlador(miControlador);
       miVistaEditarPedido.setControlador(miControlador);
       miVistaBusquedaClientes.setControlador(miControlador);
       miVistaBusquedaProductos.setControlador(miControlador);
       miVistaBusquedaPedidos.setControlador(miControlador);
       miVistaSeleccionCliente.setControlador(miControlador);
       miVistaProductosPedidos.setControlador(miControlador);
       miCliente.setControlador(miControlador);
       miPedido.setMiControlador(miControlador);
       miProducto.setControlador(miControlador);
       miDDBB.setControlador(miControlador);
     
       
       miControlador.setVistaPrincipal(miVistaPrincipal);
       miControlador.setVistaClientes(miVistaClientes);
       miControlador.setVistaProductos(miVistaProductos);
       miControlador.setVistaPedidos(miVistaPedidos);
       miControlador.setVistaNuevoCliente(miVistaNuevoCliente);
       miControlador.setVistaNuevoProducto(miVistaNuevoProducto);
       miControlador.setVistaNuevoPedido(miVistaNuevoPedido);
       miControlador.setVistaEditarCliente(miVistaEditarCliente);
       miControlador.setVistaEditarProducto(miVistaEditarProducto);
       miControlador.setVistaEditarPedido(miVistaEditarPedido);
       miControlador.setVistaBusquedaClientes(miVistaBusquedaClientes);
       miControlador.setVistaBusquedaProductos(miVistaBusquedaProductos);
       miControlador.setVistaBusquedaPedidos(miVistaBusquedaPedidos);
       miControlador.setVistaSeleccionCliente(miVistaSeleccionCliente);
       miControlador.setVistaProductosPedidos(miVistaProductosPedidos);
       miControlador.setClientes(miCliente);
       miControlador.setPedido(miPedido);
       miControlador.setProducto(miProducto);
       miControlador.setDDBB(miDDBB);
       
       miDDBB.ddbbPath="C:/DBSQLlite/gestion_pedidos.db";
       
       miVistaPrincipal.setVisible(true);
        
        
    }
    
}
