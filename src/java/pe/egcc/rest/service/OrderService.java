/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.rest.db.AccesoDB;
import pe.egcc.rest.model.Order;
import pe.egcc.rest.model.Products;

/**
 *
 * @author assi
 */
public class OrderService implements Serializable {

    public List<Order> leerOrdenes(String filtro) {

        Connection connection = null;

        List<Order> lista = new ArrayList<Order>();
        String sql = "SELECT ord.`orderNumber` , ord.`orderDate` , ord.`shippedDate` , prol.`productLine` , \n"
                + "pro.`productName` , de.`quantityOrdered` , de.`priceEach` , cus.`customerName` , ord.status  , pay.amount , de.priceEach \n"
                + "from orders ord join orderdetails de on ord.`orderNumber` = de.`orderNumber`\n"
                + "join products pro on pro.`productCode` = de.`productCode`\n"
                + "join customers cus on cus.`customerNumber` = ord.`customerNumber`\n"
                + "join payments pay on pay.customerNumber = cus.customerNumber \n"
                + "join productlines prol on prol.`productLine` = pro.`productLine` where (ord.orderNumber like '%" + filtro + "%' or cus.customerName like '%" + filtro + "%') ";
        try {
            connection = AccesoDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//'%" + filtro + "%'"
//            preparedStatement.setString(1, filtro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Order ord = new Order();
                ord.setNumeroOrden(resultSet.getInt(1));
                ord.setCantidad(resultSet.getInt(6));
                ord.setCliente(resultSet.getString(8));
                ord.setProducto(resultSet.getString(5));
                ord.setEstado(resultSet.getString(9));
                ord.setFecha(resultSet.getDate(2));
                ord.setFechaEnvio(resultSet.getDate(3));
                ord.setTotal(resultSet.getDouble(10));
                ord.setPrecio_unidad(resultSet.getDouble(11));
                lista.add(ord);
            }

            resultSet.close();

        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage());

        } finally {

            try {
                connection.close();
            } catch (Exception e) {
            }

        }

        return lista;
    }
}
