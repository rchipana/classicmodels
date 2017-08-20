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
import pe.egcc.rest.model.Products;

/**
 *
 * @author assi
 */
public class ProductService implements Serializable {

    public List<Products> leerProductos(String filtro) {

        Connection connection = null;

        List<Products> lista = new ArrayList<Products>();
        String sql = "SELECT p.`productCode` ,p.`productName` , p.`productLine` , p.`productScale` , p.`productVendor` ,"
                    + " p.`productDescription` , p.`quantityInStock` , p.`buyPrice` , p.`MSRP`  FROM products p  where p.productName like '%" + filtro + "%' " ;
        try {
            connection = AccesoDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//'%" + filtro + "%'"
//            preparedStatement.setString(1, filtro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Products pro = new Products();
                pro.setProductCode(resultSet.getString(1));
                pro.setProductName(resultSet.getString(2));
                pro.setProductScale(resultSet.getString(4));
                pro.setProductDescription(resultSet.getString(6));
                pro.setQuantityInStock(resultSet.getInt(7));
                pro.setBuyPrice(resultSet.getBigDecimal(8));
                lista.add(pro);
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
