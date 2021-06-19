/**
 * sky
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FlightsTimeTable {



    private ResultSet rs = null;
    private Statement st = null;



    public List<Flight> getFlightTimetable(){

        List flightList=new ArrayList();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps=null;
            ResultSet rs=null;

            // String querry="SELECT resource.id,resource.type,resource.name,resource.from_date,resource.to_date,resource.status_booked FROM resource INNER JOIN booked_resource ON resource.id = booked_resource.resource_id WHERE booked_resource.return_status = ? AND booked_resource.user_id = ?";
            String querry="SELECT * from flights ";
            ps=connection.prepareStatement(querry);

            rs=ps.executeQuery();
            while(rs.next()){
                String flightname = rs.getString("flightname");
                String source = rs.getString("sourcee");
                String designation = rs.getString("designation");
                String priceperseat = rs.getString("priceperseat");
                String date_time = rs.getString("date_time");
                int id = rs.getInt("id");
                int totalseats = rs.getInt("totalseats");
                int availableseats = rs.getInt("availableseats");
                Flight obj_flight = new Flight(id,flightname, source,designation, priceperseat ,totalseats, availableseats,date_time );

                flightList.add(obj_flight);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flightList;
    }

    public List<Flight> addFlightTimetable(String flightname,String sourcee,String designation,String priceperseat,String date_time,String totalseats,String availableseats ){

        int totalseatss = Integer.parseInt(totalseats);
        int availableseatss = Integer.parseInt(totalseats);
        List flightList=new ArrayList();
        PreparedStatement ps = null;
        int clientid = -1;
        try {
            Connection connection = DBUtil.getConnection();
            if (connection != null) {
                try {
                    String query = "insert into flights (flightname, sourcee, designation, priceperseat, date_time, totalseats,availableseats) values(?,?,?,?,?,?,?)";

                    ps = connection.prepareStatement(query);
                    ps.setString(1, flightname);
                    ps.setString(2, sourcee);
                    ps.setString(3, designation);
                    ps.setString(4, priceperseat);
                    ps.setString(5, date_time);
                    ps.setInt(6, totalseatss);
                    ps.setInt(7, availableseatss);
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




        try {
            Connection connection = DBUtil.getConnection();
             ps=null;
            ResultSet rs=null;

            // String querry="SELECT resource.id,resource.type,resource.name,resource.from_date,resource.to_date,resource.status_booked FROM resource INNER JOIN booked_resource ON resource.id = booked_resource.resource_id WHERE booked_resource.return_status = ? AND booked_resource.user_id = ?";
            String querry="SELECT * from flights ";
            ps=connection.prepareStatement(querry);

            rs=ps.executeQuery();
            while(rs.next()){
                 flightname = rs.getString("flightname");
                String source = rs.getString("sourcee");
                 designation = rs.getString("designation");
                 priceperseat = rs.getString("priceperseat");
                 date_time = rs.getString("date_time");
                int id = rs.getInt("id");
                int totalseat = rs.getInt("totalseats");
                int availableseat = rs.getInt("availableseats");
                Flight obj_flight = new Flight(id,flightname, source,designation, priceperseat ,totalseat, availableseat,date_time );

                flightList.add(obj_flight);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flightList;


    }


    public List<Flight> getSearchedFlightTimetableyFilters(String from, String to, String noofseats){

        System.out.println(" u form: "+from+" to: "+to+" noofpersons: "+noofseats);
        int nos = Integer.parseInt(noofseats);
        System.out.println(" p form: "+from+" to: "+to+" nos: "+nos);
        List flightList=new ArrayList();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps=null;
            ResultSet rs=null;
            Statement stmt = null;
            stmt = connection.createStatement();

            // String querry="SELECT resource.id,resource.type,resource.name,resource.from_date,resource.to_date,resource.status_booked FROM resource INNER JOIN booked_resource ON resource.id = booked_resource.resource_id WHERE booked_resource.return_status = ? AND booked_resource.user_id = ?";
            String querry="SELECT * from flights WHERE sourcee LIKE '%"+from+"%' AND designation Like '%"+to+"%' AND availableseats>="+nos;
            System.out.print("query: "+querry);
            // String querry="SELECT * from flights WHERE source LIKE '%from%' AND designation=? AND availableseats<=?";

            /*ps.setString(1, from);
            ps.setString(2, to);
            ps.setInt(3,nos);*/

            //ps=connection.prepareStatement(querry);

            rs=stmt.executeQuery(querry);
            while(rs.next()){
                String flightname = rs.getString("flightname");
                String source = rs.getString("sourcee");
                String designation = rs.getString("designation");
                String priceperseat = rs.getString("priceperseat");
                String date_time = rs.getString("date_time");
                int id = rs.getInt("id");
                int totalseats = rs.getInt("totalseats");
                int availableseats = rs.getInt("availableseats");
                Flight obj_flight = new Flight(id,flightname, source,designation, priceperseat ,totalseats, availableseats,date_time );

                flightList.add(obj_flight);
            }
        } catch (Exception e) {
            System.out.println("exception: "+e);
        }
        return flightList;
    }

}
