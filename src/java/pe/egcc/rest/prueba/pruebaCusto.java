/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.prueba;

import pe.egcc.rest.service.CustomerService;

/**
 *
 * @author rchipana
 */
public class pruebaCusto {

    public static void main(String[] args) {
        try {
            String no = "pruebadd";
            String no1 = "prueba";
            String no2 = "pruebadd";
            String no3 = "prueba";
            String no4 = "prueba";
            String no5 = "pruebagg";
            String no6 = "prueba";

            CustomerService cu = new CustomerService();
            cu.crearCustomer(no, no1, no2, no3, no4, no5, no6);
        } catch (Exception e) {
            e.printStackTrace();
            
        }

    }

}
