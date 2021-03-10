package com.Project0.db;

import com.Project0.config.ConnectionUtil;
import com.Project0.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsOwnedJDBC {

    public boolean doesCarExist(String carName){
        try{
            String sql = ("SELECT * FROM cars where carname like '%"+carName+"%';");
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String s2 = rs.getString("carname");
                if(s2.equals(carName)){
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public void showOwnedCars(String username){
        try{
            String sql = ("SELECT * FROM cars where ownership like '%"+username+"%';");
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("Car name");
            while (rs.next()) {
                String s2 = rs.getString("carname");
                System.out.println(s2);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
