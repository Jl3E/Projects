package com.Project0.db;

import com.Project0.config.ConnectionUtil;
import com.Project0.model.User;
import com.Project0.util.CarCollection;

import java.sql.SQLException;
import java.sql.Statement;

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
        try {
            String sql = "insert into cars values ('" +
                    carId++ + "', '" + s +"')";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public void getAll() {

    }

    @Override
    public boolean remove(Integer id) {
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
