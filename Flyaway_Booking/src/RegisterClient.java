import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * sky
 */
@WebServlet(name = "RegisterClient")

public class RegisterClient extends HttpServlet {

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

        String request_from = request.getParameter("requestfrom");

        // in each if statement we are checking the from which page we send request the then get data from the request object accordingly
        // and also send data to the respective view according to the request

        // these statement will execute when request come from adduser form

        if(request_from.equals("adduser")) {
            String username = request.getParameter("usernamecreate"); // geting the username from the adduser form
            String password = request.getParameter("passwordcreate"); // geting the password from the adduser form


            if(username.length() > 3  || password.length() > 3)
            {

                int clientId = users.addUser(username, password);
                if(clientId > 0) {

                    request.setAttribute("message", "User Add Successfully ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    request.setAttribute("message", "User Not Add Successfully");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
            }
            else {

                if(username.length() > 3) {
                }
                else {
                    request.setAttribute("message",  "Unable to adduser username must me greter than 3 digits");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
                if(password.length() > 3) {
                }
                else {
                    request.setAttribute("message", "Unable to adduser password must me greter than 3 digits");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



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



