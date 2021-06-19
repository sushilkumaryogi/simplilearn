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
@WebServlet(name = "SearchFlight")
public class SearchFlight extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String from = request.getParameter("from").toLowerCase();
        String to = request.getParameter("to").toLowerCase();
        String noofpersons = request.getParameter("noofpersons");

        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();



        List<Flight> availableFlights = flightsTimeTable.getSearchedFlightTimetableyFilters(from, to, noofpersons);

        if(availableFlights.size() > 0) {

            request.setAttribute("availableflights", availableFlights);
            request.setAttribute("message", "ALL Available Search Flights Are");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchedFlight.jsp");
            dispatcher.forward(request, response);
        }
        else{
            request.setAttribute("message", "Currently No Flight Exist");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
