package modelo;

import controlador.Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

        
/**
 *
 * @author Lautaro
 */
public class DDBB {
    
    private Controlador miControlador;
    public String ddbbPath;
    Connection connection = null;

    private void conectar(String dbpath){
    // <editor-fold defaultstate="collapsed" desc="Metodo Conectar a la base de datos">
    try{
         connection = DriverManager.getConnection( "jdbc:sqlite:"+dbpath);//me conecto a la base de datos
         if ( connection != null ){
            System.out.println("Conexion exitosa");
         }
      }
      catch ( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en la conexión");
      }
   }// </editor-fold>
    
    private void desconectar(){
    // <editor-fold defaultstate="collapsed" desc="Metodo Desconectar a la base de datos">    
        try{
         
         connection.close();
         
         }
      
         catch( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en cerrar la base de datos");
         
      }
   }// </editor-fold>
    
    private int ejecutarSentenciaSQL(String sentencia)
    // <editor-fold defaultstate="collapsed" desc="Permite hacer querys sin respuesta (como el INSERT o UPDATE)">
   {
       try{
         conectar(this.ddbbPath);
         PreparedStatement pstm = connection.prepareStatement(sentencia);
         pstm.execute();
         System.out.println("Sentencia ejecutada correctamente!");
         pstm.close();
         desconectar();
         return 1;
         }
      
      catch( SQLException ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en la ejecución de sentencia");
         return 0;
      }
   }// </editor-fold>
    
    public void setControlador(Controlador miControlador) {
        this.miControlador=miControlador;
    }
    
    public int guardarClienteNuevo(Cliente nuevoCliente){
     
     String Sentencia = "INSERT INTO CLIENTES (CODIGOCLIENTE, EMPRESA, DIRECCION, PROVINCIA, TELEFONO, RESPONSABLE, ACTIVO) VALUES (NULL, '"+nuevoCliente.getEmpresa()+"', '"+nuevoCliente.getDireccion()+"', '"+nuevoCliente.getProvincia()+"', '"+nuevoCliente.getTelef()+"', '"+nuevoCliente.getResponsable()+"', 1)";   
     try{   
        ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
      catch ( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error al crear un nuevo cliente");
         return 0;
      }
    }
     public ArrayList<Cliente> buscarCliente(String Parametro, int BuscarPor){
        
       ArrayList<Cliente> listaClientes = new ArrayList();
       ResultSet Resultado;
       String sentencia;
      
        switch (BuscarPor) {
            case 1 -> {
                System.out.println("Buscando por empresa: "+Parametro);
                sentencia = "SELECT * FROM 'CLIENTES' WHERE UPPER(EMPRESA) LIKE UPPER(\"%"+Parametro+"%\") AND ACTIVO=1";
            }
            case 2 -> {
                System.out.println("Buscando por responsable: "+Parametro);
                sentencia = "SELECT * FROM 'CLIENTES' WHERE UPPER(RESPONSABLE)LIKE UPPER(\"%"+Parametro+"%\") AND ACTIVO=1";
            }
            default -> {
                    System.out.println("Buscando sin paramnetro");
                    sentencia = "SELECT * FROM 'CLIENTES' WHERE ACTIVO=1";
            }        
        }
    
        try{
         
         /*//Una PreparedStatement es una sentencia SQL precompilada,proporciona varios métodos para establecer parámetros*/
         conectar(this.ddbbPath);
         Statement pstm = connection.createStatement();
         Resultado = pstm.executeQuery(sentencia);
         System.out.println("Consulta ejecutada correctamente!");
           
         while(Resultado.next()){//next devuelve un booleano. True si encontró valores en la consulta
                   
                    Cliente miCliente = new Cliente();
                    miCliente.setCod_cliente(Resultado.getString("CODIGOCLIENTE"));
                    miCliente.setEmpresa(Resultado.getString("EMPRESA"));
                    miCliente.setDireccion(Resultado.getString("DIRECCION"));
                    miCliente.setProvincia(Resultado.getString("PROVINCIA"));
                    miCliente.setTelef(Resultado.getString("TELEFONO"));
                    miCliente.setResponsable(Resultado.getString("RESPONSABLE"));
                    listaClientes.add(miCliente);
                 
         }
         System.out.println("Cantidad de elementos en la lista:" + listaClientes.size());
         pstm.close();
         connection.close(); 
         return listaClientes;
         
        }
      
      catch( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en la consulta a base de datos");
         return null;
      }   
     }

    public int ActualizarCliente(Cliente miCliente) {
        
        String Sentencia = "UPDATE CLIENTES SET EMPRESA='"+miCliente.getEmpresa()+"', DIRECCION='"+miCliente.getDireccion()+"', PROVINCIA='"+miCliente.getProvincia()+"', TELEFONO='"+miCliente.getTelef()+"', RESPONSABLE='"+miCliente.getResponsable()+"', ACTIVO=1 WHERE CODIGOCLIENTE=\""+miCliente.getCod_cliente()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al actualizar el cliente");
         return 0;
      }
    }
    
    public int EliminarCliente(Cliente miCliente) {
        
        String Sentencia = "UPDATE CLIENTES SET ACTIVO=0 WHERE CODIGOCLIENTE=\""+miCliente.getCod_cliente()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al eliminar el cliente");
         return 0;
      }
    }

    public int guardarProductoNuevo(Producto nuevoProducto){
     
     String Sentencia = "INSERT INTO PRODUCTOS (CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, ACTIVO) VALUES (NULL, '"+nuevoProducto.getSeccion()+"', '"+nuevoProducto.getNom_art()+"', '"+nuevoProducto.getPrecio()+"', 1)";   
     try{   
        ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
      catch ( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error al crear un nuevo producto");
         return 0;
      }
    }
     public ArrayList<Producto> buscarProducto(String Parametro, int BuscarPor){
        
       ArrayList<Producto> listaProductos = new ArrayList();
       ResultSet Resultado;
       String sentencia;
      
        switch (BuscarPor) {
            case 1 -> {
                System.out.println("Buscando por nombre: "+Parametro);
                sentencia = "SELECT * FROM 'PRODUCTOS' WHERE UPPER(NOMBREARTICULO) LIKE UPPER(\"%"+Parametro+"%\") AND ACTIVO=1";
            }
            case 2 -> {
                System.out.println("Buscando por seccion: "+Parametro);
                sentencia = "SELECT * FROM 'PRODUCTOS' WHERE UPPER(SECCION)LIKE UPPER(\"%"+Parametro+"%\") AND ACTIVO=1";
            }
            default -> {
                System.out.println("Buscando sin paramnetro");
                sentencia = "SELECT * FROM 'PRODUCTOS' WHERE ACTIVO=1";
            }        
        }
    
        try{
         
         /*//Una PreparedStatement es una sentencia SQL precompilada,proporciona varios métodos para establecer parámetros*/
         conectar(this.ddbbPath);
         Statement pstm = connection.createStatement();
         Resultado = pstm.executeQuery(sentencia);
         System.out.println("Consulta ejecutada correctamente!");
           
         while(Resultado.next()){//next devuelve un booleano. True si encontró valores en la consulta
                   
                    Producto miProducto = new Producto();
                    miProducto.setCod_art(Resultado.getString("CODIGOARTICULO"));
                    miProducto.setSeccion(Resultado.getString("SECCION"));
                    miProducto.setNom_art(Resultado.getString("NOMBREARTICULO"));
                    miProducto.setPrecio(Resultado.getString("PRECIO"));
                    listaProductos.add(miProducto);
         }
         
         System.out.println("Cantidad de elementos en la lista:" + listaProductos.size());
         pstm.close();
         connection.close(); 
         return listaProductos;
         
        }
      
      catch( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en la consulta a base de datos");
         return null;
      }   
     }
    
     public int ActualizarProducto(Producto miProducto) {
        
        String Sentencia = "UPDATE PRODUCTOS SET SECCION='"+miProducto.getSeccion()+"', NOMBREARTICULO='"+miProducto.getNom_art()+"', PRECIO='"+miProducto.getPrecio()+"', ACTIVO=1 WHERE CODIGOARTICULO=\""+miProducto.getCod_art()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al actualizar el producto");
         return 0;
        }
    }
    
    public int EliminarProducto(Producto miProducto) {
        
        String Sentencia = "UPDATE PRODUCTOS SET ACTIVO=0 WHERE CODIGOARTICULO=\""+miProducto.getCod_art()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
        return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al eliminar el producto");
         return 0;
        }
    }
    
    public int guardarPedidoNuevo(Pedido miPedido, String [] ultimoInsert) {
        
        ResultSet Resultado;
        String Sentencia = "INSERT INTO PEDIDOS (NUMERODEPEDIDO, CODIGOCLIENTE, FECHADEPEDIDO, FORMADEPAGO, ENVIADO, ACTIVO) VALUES (NULL, '"+miPedido.getCodigoCliente()+"', '"+miPedido.getFechaPedido()+"', '"+miPedido.getFormaPago()+"', '"+miPedido.getEnviado()+"', 1)";   
        String Sentencia2 = "SELECT MAX(NUMERODEPEDIDO) FROM PEDIDOS";
        
        try{   
            ejecutarSentenciaSQL(Sentencia);
            conectar(this.ddbbPath);
            Statement pstm = connection.createStatement();
            Resultado = pstm.executeQuery(Sentencia2);

            while(Resultado.next()){//next devuelve un booleano. True si encontró valores en la consulta

                       ultimoInsert[0]=(Resultado.getString("MAX(NUMERODEPEDIDO)"));
            }

            System.out.println("Ultimo codigo de pedido encontrado: "+ ultimoInsert[0]);
            pstm.close();
            connection.close();
            return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al crear un nuevo pedido");
            return 0;
        }
    }

    public ArrayList<Pedido> buscarPedido(String Parametro, int BuscarPor) {
       
       ArrayList<Pedido> listaPedido = new ArrayList();
       ResultSet Resultado;
       String sentencia;
      
        switch (BuscarPor) {
            case 1 -> {
                System.out.println("Buscando por cliente: "+Parametro);
                sentencia = "SELECT NUMERODEPEDIDO, CODIGOCLIENTE, EMPRESA, FECHADEPEDIDO, FORMADEPAGO, ENVIADO FROM 'PEDIDOS' LEFT JOIN 'CLIENTES' USING (CODIGOCLIENTE) WHERE UPPER(EMPRESA) LIKE UPPER(\"%"+Parametro+"%\") AND PEDIDOS.ACTIVO=1";
            }
            default -> {
                System.out.println("Buscando sin paramnetro");
                sentencia = "SELECT NUMERODEPEDIDO, CODIGOCLIENTE, EMPRESA, FECHADEPEDIDO, FORMADEPAGO, ENVIADO FROM 'PEDIDOS' LEFT JOIN 'CLIENTES' USING (CODIGOCLIENTE) WHERE PEDIDOS.ACTIVO=1";
            }        
        }
    
        try{
         
         /*//Una PreparedStatement es una sentencia SQL precompilada,proporciona varios métodos para establecer parámetros*/
         conectar(this.ddbbPath);
         Statement pstm = connection.createStatement();
         Resultado = pstm.executeQuery(sentencia);
         System.out.println("Consulta ejecutada correctamente!");
           
         while(Resultado.next()){//next devuelve un booleano. True si encontró valores en la consulta
                   
                    Pedido miPedido = new Pedido();
                    miPedido.setNumeroPedido(Resultado.getString("NUMERODEPEDIDO"));
                    miPedido.setCodigoCliente(Resultado.getString("CODIGOCLIENTE"));
                    miPedido.setCliente(Resultado.getString("EMPRESA"));
                    miPedido.setFechaPedido(Resultado.getString("FECHADEPEDIDO"));
                    miPedido.setFormaPago(Resultado.getString("FORMADEPAGO"));
                    miPedido.setEnviado(Resultado.getInt("ENVIADO"));
                    listaPedido.add(miPedido);
         }
         
         System.out.println("Cantidad de elementos en la lista:" + listaPedido.size());
         pstm.close();
         connection.close(); 
         return listaPedido;
         }
      
            catch( Exception ex ) {
               System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
               System.out.println("Error en la consulta a base de datos");
               return null;
            }   
  
        }

    public ArrayList<Producto> buscarProductosPedidos(String CodigoPedido) {
        
        ArrayList<Producto> listaProductos = new ArrayList();
        ResultSet Resultado;
        String sentencia;
      

        System.out.println("Buscando por código de pedido: "+CodigoPedido);
        sentencia = "SELECT CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, UNIDADES FROM 'PRODUCTOS' LEFT JOIN 'PRODUCTOSPEDIDOS' USING (CODIGOARTICULO) WHERE NUMERODEPEDIDO=(\""+CodigoPedido+"\")";
        System.out.println(sentencia);
    
        try{
         
         /*//Una PreparedStatement es una sentencia SQL precompilada,proporciona varios métodos para establecer parámetros*/
         conectar(this.ddbbPath);
         Statement pstm = connection.createStatement();
         Resultado = pstm.executeQuery(sentencia);
         System.out.println("Consulta ejecutada correctamente!");
           
         while(Resultado.next()){//next devuelve un booleano. True si encontró valores en la consulta
                   
                    Producto miProducto = new Producto();
                    miProducto.setCod_art(Resultado.getString("CODIGOARTICULO"));
                    miProducto.setSeccion(Resultado.getString("SECCION"));
                    miProducto.setNom_art(Resultado.getString("NOMBREARTICULO"));
                    miProducto.setPrecio(Resultado.getString("PRECIO"));
                    miProducto.setUnidades(Resultado.getString("UNIDADES"));
                    listaProductos.add(miProducto);
         }
         
         System.out.println("Cantidad de elementos en la lista:" + listaProductos.size());
         pstm.close();
         connection.close(); 
         return listaProductos;
         
        }
      
      catch( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Error en la consulta a base de datos");
         return null;
      }   
    }

    public int EliminarPedido(Pedido miPedido) {
        String Sentencia = "UPDATE PEDIDOS SET ACTIVO=0 WHERE NUMERODEPEDIDO=\""+miPedido.getNumeroPedido()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
            return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al eliminar el pedido");
            return 0;
        }
    }

    public int ActualizarClientePedido(Pedido miPedido) {
        
        String Sentencia = "UPDATE PEDIDOS SET CODIGOCLIENTE='"+miPedido.getCodigoCliente()+"' WHERE NUMERODEPEDIDO=\""+miPedido.getNumeroPedido()+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
            return 1;
         }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al actualizar el pedido");
         return 0;
        }
    }

    public int ActualizarProductosPedido(String numeroDePedido, ArrayList<Producto> listaProductosPedido) {
        
        int filas = listaProductosPedido.size();
        
        String Sentencia = "DELETE FROM PRODUCTOSPEDIDOS WHERE NUMERODEPEDIDO=\""+numeroDePedido+"\"";
        System.out.println(Sentencia);
        try{   
            ejecutarSentenciaSQL(Sentencia);
        }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al eliminar productos del pedido");
         return 0;
        }
        
        if(filas !=0)
        {
            try{   
                for(int i=0; i<filas; i++) //
                {
                        Sentencia = "INSERT INTO PRODUCTOSPEDIDOS (ITEM, NUMERODEPEDIDO, CODIGOARTICULO, UNIDADES) VALUES (NULL, '"+numeroDePedido+"', '"+listaProductosPedido.get(i).getCod_art()+"', '"+listaProductosPedido.get(i).getUnidades()+"')";   
                        System.out.println(Sentencia);
                        ejecutarSentenciaSQL(Sentencia);
                }
            }
            catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error al cargar productos al pedido");
            return 0;
            }
        }
        return 1;
    }
}
    
    

