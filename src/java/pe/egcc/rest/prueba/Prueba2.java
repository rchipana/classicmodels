/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Customers;
import pe.egcc.rest.service.CustomerService;

/**
 *
 * @author assi
 */
public class Prueba2 {

    public static void main(String[] args) {
        // Dato
        String cuenta = "ATeLieR";

        // Proceso
        CustomerService service = new CustomerService();
        List<Customers> lista = service.leerCustomers(cuenta);

        // Reporte
        for (Customers r : lista) {
            System.out.println(r.getId()+ " - " + r.getNombreComercial());
        }
    }

}
