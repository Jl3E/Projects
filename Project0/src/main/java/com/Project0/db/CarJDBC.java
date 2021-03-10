package com.Project0.db;

import com.Project0.config.ConnectionUtil;
import com.Project0.model.Car;
import com.Project0.model.User;
import com.Project0.model.UserType;
import com.Project0.util.CarCollection;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@TestClass
public class CarJDBC implements GenericDao<String, Integer>{

    private static CarJDBC instance;

    private CarJDBC(){}

    int carId = 0;

    static CarJDBC getInstance(){
        if(instance == null){
            instance = new CarJDBC();
        }
        return instance;
    }

    @Override
    public int save(String s) {
        String ownership = "dealership";
        try {
            String sql = "insert into cars (carname, ownership) values ('" + s +"'"+", '"+ownership+"')";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @TestMethod(name = "another test", expected = "null")
    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public void getAll() {
        try{
            String sql = ("SELECT * FROM cars");
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("Car id\t\tCar name");
            while (rs.next()) {
                if(rs.getString("ownership").equals("dealership")) {
                    int id = rs.getInt("id");
                    String s2 = rs.getString("carname");
                    Car c1 = new Car(id, s2);
                    System.out.println(id + "\t\t\t  " + s2);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean remove(Integer id) {

        try {
            String sql = "delete from cars where id ="+id+";";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(String s) {
        return false;
    }

    @Override
    public int updateAll(CarCollection collection) {
        return 0;
    }
}
