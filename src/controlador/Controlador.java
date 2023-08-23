/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import modelo.Cliente;
import vista.VistaBusquedaClientes;
import vista.VistaClientes;
import vista.VistaNuevoCliente;
import vista.VistaNuevoProducto;
import vista.VistaPrincipal;
import modelo.DDBB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Pedido;
import modelo.Producto;
import vista.VistaBusquedaPedidos;
import vista.VistaBusquedaProductos;
import vista.VistaEditarCliente;
import vista.VistaEditarPedido;
import vista.VistaEditarProducto;
import vista.VistaNuevoPedido;
import vista.VistaPedidos;
import vista.VistaProductos;
import vista.VistaProductosPedidos;
import vista.VistaSeleccionCliente;


public class Controlador {

    private VistaPrincipal miVistaPrincipal;
    private VistaClientes miVistaClientes;
    private VistaProductos miVistaProductos;
    private VistaPedidos miVistaPedidos;
    private VistaNuevoCliente miVistaNuevoCliente;
    private VistaNuevoProducto miVistaNuevoProducto;
    private VistaNuevoPedido miVistaNuevoPedido;
    private VistaEditarCliente miVistaEditarCliente;
    private VistaEditarProducto miVistaEditarProducto;
    private VistaEditarPedido miVistaEditarPedido;
    private VistaBusquedaClientes miVistaBusquedaClientes;
    private VistaBusquedaProductos miVistaBusquedaProductos;
    private VistaBusquedaPedidos miVistaBusquedaPedidos;
    private VistaSeleccionCliente miVistaSeleccionCliente;
    private VistaProductosPedidos miVistaProductosPedidos;
    private Cliente miCliente;
    private Pedido miPedido;
    private Producto miProducto;
    private DDBB miDDBB;
    

    void setVistaPrincipal(VistaPrincipal miVistaPrincipal) {
        this.miVistaPrincipal=miVistaPrincipal;
    }

    void setVistaClientes(VistaClientes miVistaClientes) {
        this.miVistaClientes=miVistaClientes;
    }

    public void abrirPantallaGestionClientes() {//con este metodo puedo buscar o cargar un clientes en el menú principal
         miVistaClientes.setVisible(true);
    }
    public void abrirPantallaGestionProductos() {//con este metodo puedo buscar o cargar un clientes en el menú principal
         miVistaProductos.setVisible(true);
    }

    void setVistaNuevoCliente(VistaNuevoCliente miVistaNuevoCliente) {
        this.miVistaNuevoCliente=miVistaNuevoCliente;
    }

    void setVistaBusquedaClientes(VistaBusquedaClientes miVistaBusquedaClientes) {
        this.miVistaBusquedaClientes=miVistaBusquedaClientes;
    }
    
    public void abrirPantallaNuevoCliente() {//con este metodo puedo abrir la pantalla que me permite ingresar los datos
         miVistaNuevoCliente.setVisible(true);
    }
    
    public void abrirPantallaEditarCliente(String Codigo, String Empresa, String Direccion, String Provincia, String Telefono, String Responsable) {//con este metodo puedo abrir la pantalla que me permite ingresar los datos
        
        miVistaEditarCliente.cargaFormulario(Codigo, Empresa, Direccion, Provincia, Telefono, Responsable);        
        miVistaEditarCliente.setVisible(true);
    }

    public void abrirPantallaBuscarCliente() {//con este metodo puedo llamar a la vista que me permite seleccionar si guardar un nuevo cliente o buscarlo
        this.miVistaBusquedaClientes.setVisible(true);
    }

    
    void setClientes(Cliente miCliente) {
        this.miCliente = miCliente;
    }
    
    void setPedido(Pedido miPedido) {
        this.miPedido=miPedido;
    }
   
    public void guardarNuevoCliente(String Empresa, String Direccion, String Provincia, String Telefono, String Responsable) {
        //System.out.println(Empresa + Direccion + Provincia + Telefono + Responsable);
        this.miCliente.setCod_cliente(null);//por que el codigo es autoincremental
        this.miCliente.setEmpresa(Empresa);
        this.miCliente.setDireccion(Direccion);
        this.miCliente.setProvincia(Provincia);
        this.miCliente.setTelef(Telefono);
        this.miCliente.setResponsable(Responsable);
        this.miCliente.setActivo(1);
        int resultado = miDDBB.guardarClienteNuevo(this.miCliente);
           
    }
    
    public void actualizarCliente(String Codigo, String Empresa, String Direccion, String Provincia, String Telefono, String Responsable) {
        //System.out.println(Empresa + Direccion + Provincia + Telefono + Responsable);
        this.miCliente.setCod_cliente(Codigo);//por que el codigo es autoincremental
        this.miCliente.setEmpresa(Empresa);
        this.miCliente.setDireccion(Direccion);
        this.miCliente.setProvincia(Provincia);
        this.miCliente.setTelef(Telefono);
        this.miCliente.setResponsable(Responsable);
        this.miCliente.setActivo(1);
        int resultado = miDDBB.ActualizarCliente(this.miCliente);
    }
    
    public void eliminarCliente(String Codigo) {
        
        this.miCliente.setCod_cliente(Codigo);
        int resultado = miDDBB.EliminarCliente(this.miCliente);
    }
    
    public DefaultTableModel buscarCliente(String Parametro, int BuscarPor) {
    
        //ResultSet Resultado = null;
        ArrayList<Cliente> listaClientes;
        listaClientes=miDDBB.buscarCliente(Parametro, BuscarPor);
        DefaultTableModel modelo= new DefaultTableModel()
            {Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;}};
        
        
        modelo.addColumn("Código");
        modelo.addColumn("Empresa");
        modelo.addColumn("Dirección");
        modelo.addColumn("Provincia");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Responsable");
        
        
        for (int i=0;i< listaClientes.size() ;i++) {
                
                modelo.addRow(new Object[]{listaClientes.get(i).getCod_cliente(), listaClientes.get(i).getEmpresa(), listaClientes.get(i).getDireccion(), listaClientes.get(i).getProvincia(), listaClientes.get(i).getTelef(), listaClientes.get(i).getResponsable()});
            }
        
        return modelo;
       
        
    }
    
    void setDDBB(DDBB miDDBB) {
        this.miDDBB=miDDBB;
    }

    void setVistaEditarCliente(VistaEditarCliente miVistaEditarCliente) {
        this.miVistaEditarCliente=miVistaEditarCliente;
    }

    void setVistaProductos(VistaProductos miVistaProductos) {
        this.miVistaProductos=miVistaProductos;
    }

    public void abrirPantallaBuscarProducto() {
        miVistaBusquedaProductos.setVisible(true);    
    }

    public void abrirPantallaNuevoProducto() {
        miVistaNuevoProducto.setVisible(true);
    }

    void setVistaNuevoProducto(VistaNuevoProducto miVistaNuevoProducto) {
        this.miVistaNuevoProducto=miVistaNuevoProducto;
    }

    void setVistaBusquedaProductos(VistaBusquedaProductos miVistaBusquedaProductos) {
        this.miVistaBusquedaProductos=miVistaBusquedaProductos;    
    }

    public void abrirPantallaEditarProducto(String Codigo, String Seccion, String Nombre, String Precio) {
        miVistaEditarProducto.cargaFormulario(Codigo, Seccion, Nombre, Precio);
        miVistaEditarProducto.setVisible(true);
    }

    void setVistaEditarProducto(VistaEditarProducto miVistaEditarProducto) {
        this.miVistaEditarProducto=miVistaEditarProducto;    
    }

    public DefaultTableModel buscarProducto(String Parametro, int BuscarPor) {
    
        //ResultSet Resultado = null;
        ArrayList<Producto> listaProductos;
        listaProductos=miDDBB.buscarProducto(Parametro, BuscarPor);
        DefaultTableModel modelo= new DefaultTableModel()
        {Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;}};
        
        
        modelo.addColumn("Código");
        modelo.addColumn("Seccion");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
              
        for (int i=0;i< listaProductos.size() ;i++) {
                
                modelo.addRow(new Object[]{listaProductos.get(i).getCod_art(), listaProductos.get(i).getSeccion(), listaProductos.get(i).getNom_art(), listaProductos.get(i).getPrecio()});
            }
        
        return modelo;
    }

    public void abrirPantallaBuscarPedidos() {
        this.miVistaBusquedaPedidos.setVisible(true);
    }

    public void abrirPantallaNuevoPedido() {
        this.miVistaNuevoPedido.cleanClienteEntry();
        this.miVistaNuevoPedido.setVisible(true);
    }

    public void abrirPantallaGestionPedidos() {
        this.miVistaPedidos.setVisible(true);
    }

    void setVistaPedidos(VistaPedidos miVistaPedidos) {
        this.miVistaPedidos=miVistaPedidos;
    }

    void setVistaNuevoPedido(VistaNuevoPedido miVistaNuevoPedido) {
        this.miVistaNuevoPedido=miVistaNuevoPedido;
    }

    void setVistaSeleccionCliente(VistaSeleccionCliente miVistaSeleccionCliente) {
        this.miVistaSeleccionCliente = miVistaSeleccionCliente;
    }

    public void abrirPantallaSeleccionCliente() {
        this.miVistaSeleccionCliente.setVisible(true);
    }

    void setVistaProductosPedidos(VistaProductosPedidos miVistaProductosPedidos) {
        this.miVistaProductosPedidos = miVistaProductosPedidos;
    }
    
    public void abrirPantallaProductosPedidos(String CodigoPedido) {
        this.miVistaProductosPedidos.setCodigoPedido(CodigoPedido);
        this.miVistaProductosPedidos.setVisible(true);
    }

    void setVistaBusquedaPedidos(VistaBusquedaPedidos miVistaBusquedaPedidos) {
        this.miVistaBusquedaPedidos = miVistaBusquedaPedidos;
    }

    void setVistaEditarPedido(VistaEditarPedido miVistaEditarPedido) {
        this.miVistaEditarPedido = miVistaEditarPedido;
    }

    public void abrirPantallaEditarPedido(String Codigo, String CodigoCliente, String Nombre) {
        miVistaEditarPedido.cargaFormulario(Codigo, CodigoCliente, Nombre);
        this.miVistaEditarPedido.setVisible(true);
    }

    public void seleccionarCliente(String Codigo, String Empresa) {
        miVistaNuevoPedido.setClienteEntry(Empresa, Codigo);
        miVistaEditarPedido.setClienteEntry(Empresa, Codigo);
    }

    public void guardarNuevoPedido(String [] CodigoPedido, String Codigo, String Empresa, String FechaDePedido, String FormaDePago) {
        //System.out.println(Codigo + FechaDePedido + FormaDePago);
        miPedido.setCodigoCliente(Codigo);
        miPedido.setFechaPedido(FechaDePedido);
        miPedido.setFormaPago(FormaDePago);
        miPedido.setEnviado(0);
        miPedido.setActivo(1);
        int resultado = miDDBB.guardarPedidoNuevo(this.miPedido, CodigoPedido);
        System.out.println("Codigo de pedido: "+CodigoPedido[0]);
    }

    public void eliminarProducto(String Codigo) {
         this.miProducto.setCod_art(Codigo);
         int resultado = miDDBB.EliminarProducto(this.miProducto);  
    }

    void setProducto(Producto miProducto) {
        this.miProducto = miProducto;
    }

    public void actualizarProducto(String Codigo, String Nombre, String Seccion, String Precio) {
        //System.out.println(Nombre + Seccion + Precio);
        this.miProducto.setCod_art(Codigo);//por que el codigo es autoincremental
        this.miProducto.setNom_art(Nombre);
        this.miProducto.setSeccion(Seccion);
        this.miProducto.setPrecio(Precio);
        this.miProducto.setActivo(1);
        int resultado = miDDBB.ActualizarProducto(this.miProducto);
    }
    public void guardarNuevoProducto(String Nombre, String Seccion, String Precio) {
        //System.out.println(Empresa + Direccion + Provincia + Telefono + Responsable);
        this.miProducto.setCod_art(null);//por que el codigo es autoincremental
        this.miProducto.setNom_art(Nombre);
        this.miProducto.setSeccion(Seccion);
        this.miProducto.setPrecio(Precio);
        this.miProducto.setActivo(1);
        int resultado = miDDBB.guardarProductoNuevo(this.miProducto);
           
    }

    public TableModel buscarPedidos(String Parametro, int BuscarPor) {
        //ResultSet Resultado = null;
        ArrayList<Pedido> listaPedido;
        listaPedido=miDDBB.buscarPedido(Parametro, BuscarPor);
        
        DefaultTableModel modelo= new DefaultTableModel()
            {Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;}};
        
        modelo.addColumn("Código");
        modelo.addColumn("N. Cliente");
        modelo.addColumn("Cliente");
        modelo.addColumn("Fecha");
        modelo.addColumn("Pago");
        modelo.addColumn("Enviado");
              
        for (int i=0;i< listaPedido.size() ;i++) {
                
                modelo.addRow(new Object[]{listaPedido.get(i).getNumeroPedido(), listaPedido.get(i).getCodigoCliente(), listaPedido.get(i).getCliente(), listaPedido.get(i).getFechaPedido(), listaPedido.get(i).getFormaPago(), (listaPedido.get(i).getEnviado()==0)?"NO":"SI"});
            }
        
        return modelo;
    } 

    public TableModel buscarProductosPedidos(String CodigoPedido) {
        //ResultSet Resultado = null;
        ArrayList<Producto> listaProductos;
        listaProductos=miDDBB.buscarProductosPedidos(CodigoPedido);
        
        DefaultTableModel modelo= new DefaultTableModel() //Esta haciendo una redefinición de métodos en el mismo lugar donde instancia una variable u objeto
            {Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];}};
            
            
        
            modelo.addColumn("Código");
            modelo.addColumn("Sección");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");
        
           /* while(modelo.getRowCount()!=0)
            {
              modelo.removeRow(modelo.getRowCount()-1);
            }*/
           
            for (int i=0;i< listaProductos.size() ;i++) {
                
                modelo.addRow(new Object[]{listaProductos.get(i).getCod_art(), listaProductos.get(i).getSeccion(), listaProductos.get(i).getNom_art(), listaProductos.get(i).getPrecio(), listaProductos.get(i).getUnidades()});
            }
        
        return modelo;
    }

    public void eliminarPedido(String Codigo) {
        this.miPedido.setNumeroPedido(Codigo);
        int resultado = miDDBB.EliminarPedido(this.miPedido); 
    }

    public void ActualizarClienteEnPedido(String codigo, String codigoCliente) {
        this.miPedido.setNumeroPedido(codigo);
        this.miPedido.setCodigoCliente(codigoCliente);
        int resultado = miDDBB.ActualizarClientePedido(this.miPedido); 
    }

    public void ActualizarProductosPedido(String numeroDePedido, TableModel model) {
        DefaultTableModel Modelo = (DefaultTableModel)model;
        int filas = Modelo.getRowCount();
        ArrayList<Producto> listaProductosPedido = new ArrayList();
        
        
        for(int i=0; i<filas; i++)
        {
                    Producto miProducto = new Producto();
                    miProducto.setCod_art((String) Modelo.getValueAt(i, 0));
                    //System.out.println(Modelo.getValueAt(i, 4));
                    miProducto.setUnidades((String) Modelo.getValueAt(i, 4).toString());
                    listaProductosPedido.add(miProducto);
        }
        
        int resultado = miDDBB.ActualizarProductosPedido(numeroDePedido, listaProductosPedido);
      
    }
}
