/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Customers;
import pe.egcc.rest.model.Employes;
import pe.egcc.rest.service.EmployesService;

/**
 *
 * @author assi
 */
public class Prueba04 {

    public static void main(String[] args) {
        // Dato
        String cuenta = "";

        // Proceso
        EmployesService service = new EmployesService();
        List<Employes> lista = service.leerEmployes(cuenta);

        // Reporte
        for (Employes r : lista) {
            System.out.println(r.getEmployeeNumber() + " - " + r.getLastName());
        }
    }

}
