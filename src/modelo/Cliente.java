/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Controlador;

public class Cliente {
    
    private String cod_cliente;
    private String empresa;
    private String direccion;
    private String provincia;
    private String telef;
    private String responsable;
    private int activo;
    
    private Controlador miControlador;

    
    public Cliente() {
    }

    public Cliente(String cod_cliente, String empresa, String direccion, String población, String telef, String responsable) {
        this.cod_cliente = cod_cliente;
        this.empresa = empresa;
        this.direccion = direccion;
        this.provincia = población;
        this.telef = telef;
        this.responsable = responsable;
        this.activo=1;
     }
    
    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }

    public void setActivo(int i) {
        
        this.activo=i;
    }
}
