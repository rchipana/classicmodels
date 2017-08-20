/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author assi
 */
@XmlRootElement
public class Order implements Serializable {

    private Integer numeroOrden;
    private String producto;
    private Integer cantidad;
    private Date fecha;
    private Date fechaEnvio;
    private String estado;
    private String cliente;
    private Double total;
    private Double precio_unidad;

    public Order(Integer numeroOrden, String producto, Integer cantidad, Date fecha, Date fechaEnvio, String estado, String cliente) {
        this.numeroOrden = numeroOrden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Order() {
    }

    public Double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(Double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    
    
    @XmlElement
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlElement
    public Integer getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    @XmlElement
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @XmlElement
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @XmlElement
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlElement
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
