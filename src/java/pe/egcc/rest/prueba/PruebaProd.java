/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Products;
import pe.egcc.rest.service.ProductService;

/**
 *
 * @author assi
 */
public class PruebaProd {
    public static void main(String[] args) {
        // Dato
        String cuenta = "harley";

        // Proceso
        ProductService service = new ProductService();
        List<Products> lista = service.leerProductos(cuenta);

        // Reporte
        for (Products r : lista) {
            System.out.println(r.getProductCode()+ " - " + r.getProductDescription());
        }
    }
    
}
