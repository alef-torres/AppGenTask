/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author alef_
 */
public class TaskTableModel extends AbstractTableModel {

    String[] colums = {"Nomes", "Descrição", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList(); // lista para guardar as tarefas ativas.

    @Override
    public int getRowCount() {
        return tasks.size(); //retorna o tamanho da lista de tarefas.
    }

    @Override
    public int getColumnCount() {
        return colums.length; // returna o tamanho do vetor de colunas.
    }

    @Override
    public String getColumnName(int Index) {
        return colums[Index];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                return tasks.get(rowIndex).getDeadline();
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return "";
            case 5:
                return "";

            default:
                return "Dados não encontrados";

        }
    }

    public String[] getColums() {
        return colums;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
