/**
 * Created by Mohammad Rahman on 1/31/2021.
 */


import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;





public class Users {

    private ResultSet rs = null;
    private PreparedStatement pstmt = null;


    private String id = "";
    private int idd = 0;
    private String userName = "";
    private String password = "";
    private int role = 0;


    public Users() {



    }

    public Users isValid(String name, String pwd) {

        Users users = new Users();
        int clientId = -1;
        users.setIdd(clientId);
        try {

            Connection connection = DBUtil.getConnection();


            if (connection != null) {

                //TODO: implement this method so that if the user does not exist, it returns -1.
                // If the username and password are correct, it should return the 'clientID' value from the database.

                pstmt = connection.prepareStatement("select * from clients where username=? AND password=? "); //sql select query
                pstmt.setString(1, name);
                pstmt.setString(2, pwd);
                //  pstmt.setString(3, passwordhash);

                rs = pstmt.executeQuery(); //execute query and store in resultset object rs.

                if (rs.next()) {
                    int id = rs.getInt("clientid");
                    String dbusername = rs.getString("username");
                    String dbpassword = rs.getString("password");
                    int dbrole = rs.getInt("role");


                    if (name.equals(dbusername) && (pwd.equals(dbpassword) )) {

                        clientId = id;
                        users.setPassword(dbpassword);
                        users.setUserName(dbusername);
                        users.setRole(dbrole);
                        users.setIdd(id);

                        this.setPassword(dbpassword);
                        this.setUserName(dbusername);
                        this.setRole(dbrole);
                        this.setIdd(id);

                    }

                    return users;
                }
                else {
                    return users;
                }
            }
        } catch(Exception e) {

            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
            return users;
        }

        return users;

    }

    // TODO  add a user with specified username and password
    public int addUser(String name, String pwd) {

        //TODO: implement this method so that the specified username and password are inserted into the database.

        PreparedStatement ps = null;

        int clientid = -1;
        try {

            Connection connection = DBUtil.getConnection();

            if (connection != null) {

                try {

                    String query = "insert into clients (username, password) values(?,?)";

                    ps = connection.prepareStatement(query);
                    ps.setString(1, name);
                    ps.setString(2, pwd);

                    int rs = ps.executeUpdate();
                    if(rs>0) {
                        clientid = 1;
                    }
                    else{

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());


                }

            }

        }
        catch(Exception e) {
            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());

        }
        return clientid;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }
}
