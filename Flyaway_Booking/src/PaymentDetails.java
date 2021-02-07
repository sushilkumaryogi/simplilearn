import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mohammad Rahman on 2/5/2021.
 */
@WebServlet(name = "PaymentDetails")
public class PaymentDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        //c.add(Calendar.YEAR, 1);
        //c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 5); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 3);
        c.add(Calendar.MINUTE, 5);
        c.add(Calendar.SECOND, 30);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

        System.out.println(dateFormat.format(currentDatePlusOne));



        String date_time = dateFormat.format(currentDatePlusOne);




        HttpSession session = request.getSession(true); // reuse existing // session if exist // or create one


        String firstname = request.getParameter("firstname").toLowerCase();
        String lastname = request.getParameter("lastname").toLowerCase();
        String address = request.getParameter("address");

        FlightsTimeTable flightsTimeTable = new FlightsTimeTable();

        double flight = Math.random() * 999999999;
        DecimalFormat df = new DecimalFormat("0.00");
        String number = String.valueOf(df.format(flight));

        String ticket_no = "Fa-" + number + "-ly";

        session.setAttribute("pay_firstname", firstname);
        session.setAttribute("pay_lastname", lastname);
        session.setAttribute("pay_address", address );
        session.setAttribute("pay_datetime", date_time );
        session.setAttribute("pay_ticket", ticket_no);

           // request.setAttribute("message", "ALL Available Search Flights Are");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ticketinformation.jsp");
            dispatcher.forward(request, response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
