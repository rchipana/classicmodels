/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author assi
 */
@XmlRootElement(name = "customers")
public class Customers {

    private Integer id;

    private String nombreComercial;

    private String segundoNombre;

    private String primerNombre;

    private String telefono;

    private String direccion;

    private String ciudad;

    private String pais;

    private BigDecimal creditLimit;

    private Integer responsableEmpleado;

    public Customers() {

    }

    public Customers(Integer id, String nombreComercial, String segundoNombre, String primerNombre, String telefono, String direccion, String ciudad, String pais, BigDecimal creditLimit, Integer responsableEmpleado) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.segundoNombre = segundoNombre;
        this.primerNombre = primerNombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.creditLimit = creditLimit;
        this.responsableEmpleado = responsableEmpleado;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @XmlElement
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @XmlElement
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @XmlElement
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlElement
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlElement
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlElement
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlElement
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @XmlElement
    public Integer getResponsableEmpleado() {
        return responsableEmpleado;
    }

    public void setResponsableEmpleado(Integer responsableEmpleado) {
        this.responsableEmpleado = responsableEmpleado;
    }

}
