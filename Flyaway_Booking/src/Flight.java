/**
 * Created by Mohammad Rahman on 2/1/2021.
 */
public class Flight {
    String name = "";
    String source = "";
    String designation = "";

    String price = "";
    int id = 0;
    int seats = 30;
    int availableSeats = 30;

    String date_time = "";

    public Flight() {
    }

    public Flight(int id, String name, String source, String designation, String price, int seats, int availableSeats, String date_time) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.designation = designation;
        this.price = price;
        this.seats = seats;
        this.availableSeats = availableSeats;
        this.date_time = date_time;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getPrice() {
        return price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
