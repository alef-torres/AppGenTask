/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author alef_
 */
public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (idProject,"
                + " name,"
                + " description,"
                + " completed,"
                + " notes,"
                + " deadline,"
                + " createdAt,"
                + " updatedAt) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //craiacao da conexao com o banco de dados e preparando a query
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));

            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a terefa."
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET idproject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //craiacao da conexao com o banco de dados e preparando a query
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a terefa."
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removeById(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //craiacao da conexao com o banco de dados e preparando a query
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa."
            + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public List<Task> getAll(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();

        try {
            //craiacao da conexao com o banco de dados e preparando a query
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreateAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));

                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao ver todas as tarefas.", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

        return tasks;
    }

}
