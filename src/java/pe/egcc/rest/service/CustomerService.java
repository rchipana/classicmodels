/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.rest.db.AccesoDB;
import pe.egcc.rest.model.Customers;

/**
 *
 * @author assi
 */
public class CustomerService {

    public List<Customers> leerCustomers(String filtro) {

        Connection connection = null;

        List<Customers> lista = new ArrayList<Customers>();

        String sql = "SELECT c.`customerNumber` , c.`customerName` , c.`contactLastName` , c.`contactFirstName` , c.phone , c.`addressLine1` , c.city , c.country ,\n"
                + " c.`creditLimit` , c.`salesRepEmployeeNumber`\n"
                + " FROM customers c where c.customerName  like '%" + filtro + "%'";
        try {
            connection = AccesoDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, filtro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Customers customers = new Customers();
                customers.setId(resultSet.getInt(1));
                customers.setNombreComercial(resultSet.getString(2));
                customers.setTelefono(resultSet.getString(5));
                customers.setPais(resultSet.getString(8));
                customers.setCreditLimit(resultSet.getBigDecimal(9));
                customers.setResponsableEmpleado(resultSet.getInt(10));

                lista.add(customers);
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

    public void crearCustomer(String nombre,
            String segNom, String priNom, String telefono,
            String direccion, String ciudad, String pais) {

        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            String sql = "INSERT INTO customers (`customerName` , `contactLastName` , \n"
                    + "`contactFirstName` , phone , `addressLine1` ,\n"
                    + "city , country , `creditLimit` ) \n"
                    + "VALUES (?,?,?,?,?,?,?,2000)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, nombre);
            pstm.setString(2, segNom);
            pstm.setString(3, priNom);
            pstm.setString(4, telefono);
            pstm.setString(5, direccion);
            pstm.setString(6, ciudad);
            pstm.setString(7, pais);
            pstm.executeUpdate();
            pstm.close();

            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }

            String texto = "Error en el proceso." + e.getMessage();
            throw new RuntimeException(texto);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

    }

}
