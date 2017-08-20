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

}
