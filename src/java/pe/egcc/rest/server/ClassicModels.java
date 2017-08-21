package pe.egcc.rest.server;

//import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pe.egcc.rest.model.Customers;
import pe.egcc.rest.model.Employes;
import pe.egcc.rest.model.Mensaje;
import pe.egcc.rest.model.Order;
import pe.egcc.rest.model.Products;
import pe.egcc.rest.service.CuentaService;
import pe.egcc.rest.service.CustomerService;
import pe.egcc.rest.service.EmployesService;
import pe.egcc.rest.service.OrderService;
import pe.egcc.rest.service.ProductService;

@Path(value = "/classicmodel")
public class ClassicModels {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Mensaje getMensaje() {
        Mensaje bean = new Mensaje(1, "Hola todos, estamos listos.");
        return bean;
    }

    @GET
    @Path(value = "sumar")
    @Produces({MediaType.APPLICATION_JSON})
    public Mensaje sumar(
            @QueryParam("n1") int n1,
            @QueryParam("n2") int n2
    ) {
        int suma = n1 + n2;
        Mensaje bean = new Mensaje();
        bean.setCode(1);
        bean.setTexto(n1 + " + " + n2 + " = " + suma);
        return bean;
    }

    @GET
    @Path(value = "/customers/{filtro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customers> buscarCustomers(@PathParam("filtro") String filtro) {
        CustomerService employeservice = new CustomerService();
        List<Customers> list = employeservice.leerCustomers(filtro);
        return list;

    }

    @GET
    @Path(value = "/employees/{filtro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employes> buscarEmployees(@PathParam("filtro") String filtro) {
        EmployesService employeservice = new EmployesService();
        List<Employes> list = employeservice.leerEmployes(filtro);
        return list;
    }

    @GET
    @Path(value = "/products/{filtro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Products> buscarProductos(@PathParam("filtro") String filtro) {
        ProductService productService = new ProductService();
        List<Products> list = productService.leerProductos(filtro);
        return list;

    }

    @GET
    @Path(value = "/ordenes/{filtro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Order> buscarOrdenes(@PathParam("filtro") String filtro) {
        OrderService orderService = new OrderService();
        List<Order> list = orderService.leerOrdenes(filtro);
        return list;

    }

//  @GET
//  @Path(value = "/movimientos/{cuenta}")
//  @Produces({MediaType.APPLICATION_JSON })
//  public List<Movimiento> leerMovimientos(
//          @PathParam("cuenta") String cuenta){
//    // Proceso
//    CuentaService service = new CuentaService();
//    List<Movimiento> lista = service.leerMovimientos(cuenta);
//    // Reporte
//    return lista;
//  }
    @POST
    @Path(value = "/regmov")
    @Produces({MediaType.APPLICATION_JSON})
    public Mensaje regmov(
            @FormParam("cuenta") String cuenta,
            @FormParam("importe") double importe,
            @FormParam("clave") String clave,
            @FormParam("codemp") String codemp) {
        // Control
        Mensaje mensaje = new Mensaje();

        System.err.println("Cuenta: " + cuenta);

        // Proceso
        try {

            CuentaService service = new CuentaService();
            service.procRetiro(cuenta, importe, clave, codemp);

            mensaje.setCode(1);
            mensaje.setTexto("Proceso ok.");

        } catch (Exception e) {

            mensaje.setCode(-1);
            mensaje.setTexto(e.getMessage());

        }

        // Reporte
        return mensaje;
    }

    @POST
    @Path(value = "/creaCustomer")
    @Produces({MediaType.APPLICATION_JSON})
    public Mensaje crearCustomer(
            @FormParam("nombre") String nombre,
            @FormParam("segNombre") String segNombre,
            @FormParam("priNombre") String priNombre,
            @FormParam("fono") String fono,
            @FormParam("direccion") String direccion,
            @FormParam("ciudad") String ciudad,
            @FormParam("pais") String pais
    ) {
        
        Mensaje me = new Mensaje();
        try {
            CustomerService cus = new CustomerService();
            cus.crearCustomer(nombre, segNombre, priNombre, fono, direccion, ciudad, pais);
            
            me.setCode(1);
            me.setTexto("Proceso ok.");
        } catch (Exception e) {
            me.setCode(-1);
            me.setTexto(e.getMessage());
        }
        
        return me;
    }

}
