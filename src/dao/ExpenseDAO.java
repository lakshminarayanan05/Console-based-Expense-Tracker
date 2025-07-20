package dao;

import model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense e){

        String query = "INSERT INTO expense(date,category,amount,description) VALUES(?, ?, ?, ?);";

        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDate(1, java.sql.Date.valueOf(e.getDate()));
            preparedStatement.setString(2, e.getCategory());
            preparedStatement.setDouble(3, e.getAmount());
            preparedStatement.setString(4, e.getDescription());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) affected.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<Expense> getAllExpense(){

        List<Expense> list = new ArrayList<>();

        String query = "SELECT * FROM expense";

        try(Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Expense e = new Expense();
                e.setId(resultSet.getInt("id"));
                e.setDate(resultSet.getDate("date").toLocalDate());
                e.setCategory(resultSet.getString("category"));
                e.setAmount(resultSet.getDouble("amount"));
                e.setDescription(resultSet.getString("description"));
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public Expense getExpenseById(int id){

        String query = "SELECT * FROM expense WHERE id = ?";
        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Expense e = new Expense();
                e.setId(id);
                e.setDate(resultSet.getDate("date").toLocalDate());
                e.setCategory(resultSet.getString("category"));
                e.setAmount(resultSet.getDouble("amount"));
                e.setDescription(resultSet.getString("description"));

                return e;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public void updateExpense(Expense e){
        String query = "UPDATE expense SET date = ?, category = ?, amount = ?, description = ? WHERE id = ?";
        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setDate(1, java.sql.Date.valueOf(e.getDate()));
            preparedStatement.setString(2, e.getCategory());
            preparedStatement.setDouble(3, e.getAmount());
            preparedStatement.setString(4, e.getDescription());
            preparedStatement.setInt(5, e.getId());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) affected.");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void deleteExpense(int id){
        String query = "DELETE FROM expense WHERE id = ?";
        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) affected.");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

//    Method Name	Purpose
//        addExpense(Expense e)	Insert a new row in DB
//        getAllExpenses()	Return a list of all expenses
//        getExpenseById(int id)	Return a single expense by ID
//        updateExpense(Expense e)	Update a row with matching ID
//        deleteExpense(int id)	Delete a row by ID