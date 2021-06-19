import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * sky
 */
@WebServlet(name = "AdminFlights")
public class AdminFlights extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // name             flightname
        // source           sourcee
        // designation      designation
        // priceperseat     priceperseat
        // datetime         date_time
        // seats            totalseats
        // seats            availableseats


        String flightname = request.getParameter("name");
        String sourcee = request.getParameter("source");
        String designation = request.getParameter("designation");
        String priceperseat = request.getParameter("priceperseat");
        String date_time = request.getParameter("datetime");
        String totalseats = request.getParameter("seats");
        String availableseats = request.getParameter("seats");



        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();

        List<Flight> availableFlights = flightsTimeTable.addFlightTimetable(flightname, sourcee, designation, priceperseat,date_time, totalseats, availableseats );
        request.setAttribute("availableflights",  availableFlights);
        request.setAttribute("message", "ALL Flights");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_flights.jsp");
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();

        List<Flight> availableFlights = flightsTimeTable.getFlightTimetable();
        request.setAttribute("availableflights",  availableFlights);
        request.setAttribute("message", "ALL Flights");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_flights.jsp");
        dispatcher.forward(request, response);

    }
}
