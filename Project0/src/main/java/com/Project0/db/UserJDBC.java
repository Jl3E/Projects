package com.Project0.db;

import java.sql.*;

import com.Project0.config.ConnectionUtil;
import com.Project0.model.User;
import com.Project0.model.UserType;
import com.Project0.service.UserService;
import com.Project0.util.CarCollection;

import javax.swing.plaf.nimbus.State;

/**
 * jdbc
 * Java Database Connectivity
 * <p>
 * DAO
 * Data Access Object
 */
public class UserJDBC implements GenericDao<User, String> {

    private static UserJDBC instance;

    private UserJDBC(){}

    static UserJDBC getInstance(){
        if(instance == null){
            instance = new UserJDBC();
        }
        return instance;
    }

    // TODO: edit the the entry into the db to be prepared.
    @Override
    public int save(User u) {
        try {
            String sql = "insert into users values ('" +
                    u.getUsername() + "', '" + u.getPassword() + "', '"
                    + u.getEmail() + "', '"+u.getUserType().ordinal()+"')";

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
    public User getById(String id) {
        try{
            String sql = ("select * from get_all_users();");
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if(rs.getString("username").equals(id)) {
                    String s1 = rs.getString("username");
                    String s2 = rs.getString("password");
                    String s3 = rs.getString("email");
                    int s4 = rs.getInt("utype");
                    if (s4 == 1) {
                        User us1 = new User(s1, s2, s3, UserType.CUSTOMER);
                        //System.out.printf("this us1 " + us1.toString());
                        return us1;
                    } else if (s4 == 0) {
                        User us2 = new User(s1, s2, s3, UserType.EMPLOYEE);
                        //System.out.println("this us2");
                        return us2;
                    }
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //System.out.printf("this is null");
        return null;
    }

    @Override
    public void getAll() {
        try {

            String sql = ("SELECT username, email, utype FROM users");
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("username") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("utype"));

            }

        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }

    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public int updateAll(CarCollection collection) {
        return 0;
    }
}