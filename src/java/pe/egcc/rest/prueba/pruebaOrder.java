/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Order;
import pe.egcc.rest.service.OrderService;

/**
 *
 * @author assi
 */
public class pruebaOrder {
    public static void main(String[] args) {
        // Dato
        String cuenta = "Baane";

        // Proceso
        OrderService service = new OrderService();
        List<Order> lista = service.leerOrdenes(cuenta);

        // Reporte
        for (Order r : lista) {
            System.out.println(r.getNumeroOrden()+ " - " + r.getCliente());
        }
    }
    }
    

