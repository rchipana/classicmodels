package pe.egcc.rest.prueba;

import pe.egcc.rest.service.CuentaService;

public class Prueba03 {

  public static void main(String[] args) {
    
    try {

      // Datos
      String cuenta = "00100001";
      double importe = 100;
      String clave = "123456";
      String codEmp = "0001";
      
      // Proceso
      CuentaService service = new CuentaService();
      service.procRetiro(cuenta, importe, clave, codEmp);
      
      // Reporte
      System.out.println("Proceso ok.");
      
    } catch (Exception e) {
      
      System.err.println(e.getMessage());
      
    }
    
  }
  
}
