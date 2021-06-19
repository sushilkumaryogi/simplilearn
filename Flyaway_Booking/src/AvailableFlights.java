import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * sky
 */
@WebServlet(name = "AvailableFlights")

public class AvailableFlights extends HttpServlet {

    private Users users;

    public void init() {
        users = new Users();
        // TODO Attach the lesson timetable to an appropriate scope

    }

    public void destroy() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true); // reuse existing // session if exist // or create one


       // LessonTimetable lessonTimetable = new LessonTimetable();
        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();

        List<Flight> availableFlights = flightsTimeTable.getFlightTimetable();
        request.setAttribute("availableflights",  availableFlights);
        request.setAttribute("message", "ALL Available Flights");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewAllAvailableFlights.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();

        List<Flight> availableFlights = flightsTimeTable.getFlightTimetable();
        request.setAttribute("availableflights",  availableFlights);
        request.setAttribute("message", "ALL Available Flights");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewAllAvailableFlights.jsp");
        dispatcher.forward(request, response);


    }


    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}



