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
import pe.egcc.rest.model.Employes;

/**
 *
 * @author assi
 */
public class EmployesService {

    public List<Employes> leerEmployes(String filtro) {

        Connection connection = null;

        List<Employes> lista = new ArrayList<Employes>();
        String sql = "SELECT e.`employeeNumber` , e.`lastName` , e.`firstName` ,"
                + " e.extension , e.email , e.`officeCode` , e.`reportsTo` , e.`jobTitle` FROM employees e where (e.lastName like '%" + filtro + "%' or e.firstName like '%" + filtro + "%') ";
        try {
            connection = AccesoDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//'%" + filtro + "%'"
//            preparedStatement.setString(1, filtro);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Employes employes = new Employes();
                employes.setEmployeeNumber(resultSet.getInt(1));
                employes.setFirstName(resultSet.getString(3));
                employes.setLastName(resultSet.getString(2));
                employes.setJobTitle(resultSet.getString(8));
                employes.setEmail(resultSet.getString(5));
                lista.add(employes);
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

    public void crearEmployees(String priNombre,
            String segNom, String exten, String email,
            String offiCode, Integer jefe, String puesto) {

        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            String sql = "NSERT INTO employees (`lastName` , `firstName` , extension , email , `officeCode` , `reportsTo` , `jobTitle`)\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, segNom);
            pstm.setString(2, priNombre);
            pstm.setString(3, exten);
            pstm.setString(4, email);
            pstm.setString(5, offiCode);
            pstm.setInt(6, jefe);
            pstm.setString(7, puesto);
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
