package com.Project0.db;

import com.Project0.config.ConnectionUtil;
import com.Project0.model.Car;
import com.Project0.model.Offer;
import com.Project0.model.User;
import com.Project0.model.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OfferJDBC {

    float input = 430;

    public void setMonthlyPayment(float input){

        this.input = input;
    }

    public float getMonthlyPayment(){

        float loanAmount = input;
        float iRate = 0;
        float monthlyPayment;

        if(input == 430){
            if(loanAmount <= 1000.00){
                iRate = (float) 0.10;
                monthlyPayment = ((loanAmount*iRate)+loanAmount)/10;
                return monthlyPayment;
            } else if(loanAmount <=5000.00){
                iRate = (float) 0.08;
                monthlyPayment = ((loanAmount*iRate)+loanAmount)/20;
                return monthlyPayment;
            } else if (loanAmount <= 25000){
                iRate = (float) 0.05;
                monthlyPayment = ((loanAmount*iRate)+loanAmount)/60;
                return monthlyPayment;
            } else if (loanAmount <= 50000){
                iRate = (float) 0.03;
                monthlyPayment = ((loanAmount*iRate)+loanAmount)/120;
                return monthlyPayment;
            } else if (loanAmount <= 100000){
                iRate = (float) 0.025;
                monthlyPayment = ((loanAmount*iRate)+loanAmount)/120;
                return monthlyPayment;
            }
        }

        return input;
    }

    public void submitOffer(int id, String carname, String name){
        try {
            String sql = "update offers set accepted = true where id = "+id+";";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "update cars set ownership = '"+name+"' where carname like '%"+carname+"%';";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void declineOffer(String username, int id) {

        try {
            String sql = "delete from users_offers where username like '%"+username+"%' and id = "+id+";";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "delete from offers where id = "+id+";";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public float getUserAcceptedOffers(User u,String carname){
        try {
            String sql = "select * from offers o join users_offers uo on o.id = uo.id join users a on a.username = uo.username where accepted = true and a.username = '"+u.getUsername()+"'and uo.carname = '"+carname+"';";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                float s1 = rs.getFloat("offer");
                String s2 = rs.getString("carname");

                return s1/getMonthlyPayment();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void getAllUsersAcceptedOffers(){
        try {

            //this will need to connect the offers to username where accepted = true
            String sql = "select * from offers o join users_offers uo on o.id = uo.id join users a on a.username = uo.username where accepted = true;";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                float s1 = rs.getFloat("offer");
                String s2 = rs.getString("username");
                String s3 = rs.getString("carname");
                int s4 = rs.getInt("id");
                System.out.println(s2 + "\t\t\t\t" + s1 + "\t\t\t\t" + s3);
                System.out.println("---------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getAllOffers(){

        try {

            String sql = "select * from offers o join users_offers uo on o.id = uo.id join users a on a.username = uo.username;";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if(!rs.getBoolean("accepted")) {
                    float s1 = rs.getFloat("offer");
                    String s2 = rs.getString("username");
                    String s3 = rs.getString("carname");
                    int s4 = rs.getInt("id");
                    System.out.println(s4 + "\t\t\t" + s2 + "\t\t\t\t" + s1 + "\t\t\t" + s3);
                    System.out.println("---------------------------------------------------------");
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int saveOffer(User u, String offer, String carname) {

        boolean accepted = false;

        try {

            String sql = "insert into offers ( offer, accepted) values ('" +
                    offer + "', '" +accepted+"')";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "insert into users_offers (username, carname) values ('" +
                    u.getUsername()+ "', '" + carname+"')";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

}
