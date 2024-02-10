/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendavideojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cristian Andres
 */

public class TiendaVideoJuegos {
    
    private int año;
    private String nombre;
    private String version;
    private double precio;
    
    public TiendaVideoJuegos(int año, String nombre, String version, double precio) {
        this.año = año;
        this.nombre = nombre;
        this.version = version;
        this.precio = precio;
    }

    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TiendaVideoJuegos leerProyecto(int id) {
       TiendaVideoJuegos proyecto = null;
        String query = "SELECT * FROM proyectos WHERE id = ?";
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    
                    proyecto.setAño(resultSet.getInt("año"));
                    proyecto.setNombre(resultSet.getString("nombre"));
                    proyecto.setVersion(resultSet.getString("version"));
                    proyecto.setPrecio(resultSet.getDouble("precio"));
                }
            }
        } catch (SQLException e) {
        }
        return proyecto;
    }

    // Método para actualizar un proyecto
    public void actualizarProyecto(TiendaVideoJuegos proyecto) {
        String query = "UPDATE proyectos SET año = ?, nombre = ?, version = ?, precio = ? WHERE id = ?";
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, proyecto.getAño());
            preparedStatement.setString(2, proyecto.getNombre());
            preparedStatement.setString(3, proyecto.getVersion());
            preparedStatement.setDouble(4, proyecto.getPrecio());
         
            preparedStatement.executeUpdate();
            System.out.println("Proyecto actualizado correctamente");
        } catch (SQLException e) {
        }
    }

    // Método para eliminar un proyecto por su ID
    public void eliminarProyecto(int id) {
        String query = "DELETE FROM proyectos WHERE id = ?";
        try (Connection connection = ConexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Proyecto eliminado correctamente");
        } catch (SQLException e) {
        }
    }

    void EliminarTiendaVideoJuegos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
    
    



    


