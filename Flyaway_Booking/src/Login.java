import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


import javax.servlet.RequestDispatcher;

/**
 * Created by Mohammad Rahman on 1/31/2021.
 */
@WebServlet(name = "Login")

public class Login extends HttpServlet {

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

        // these statement will execute when request come from login form

        if(request_from.equals("login")){
            String username = request.getParameter("username"); // getting the username from the login form
            String password = request.getParameter("password"); // getting the password from the login form

            // checking the username and password length if it less than 4 digit then it will prompt the error message on login screen.
            if(username.length() > 3  && password.length() > 3)
            {
                Users client = users.isValid(username, password);
                int clientId = client.getIdd();
                if(clientId > 0) {
                    int role = client.getRole();
                    session.setAttribute("clientid", clientId);
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    session.setAttribute("user_role", role);

                    if(role == 100 || role == 100){
                        request.setAttribute("message_success", "Welcome to Flyaway Project");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");
                        dispatcher.forward(request, response);
                        // response.sendRedirect("http://localhost:8095/coursework/home.jsp");
                    }else if(role == 1 || role == 1){
                        request.setAttribute("message_success", "Welcome to Flyaway Project");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
                        dispatcher.forward(request, response);
                        // response.sendRedirect("http://localhost:8095/coursework/home.jsp");
                    }else{}

                }
                else {
                    System.err.println("error ");
                    request.setAttribute("message", "invalid username and password");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    // response.sendRedirect("http://localhost:8095/coursework/loginn.jsp");
                }

            }
            else {

                if(username.length() > 3) {
                }
                else {

                    System.out.println("error 1");
                    request.setAttribute("message",  "username must me greter than 3 digits");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    //response.sendRedirect("http://localhost:8095/coursework/loginn.jsp");
                }
                if(password.length() > 3) {
                }
                else {
                    System.out.println("error 2");
                    request.setAttribute("message", "password must me greter than 3 digits");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    //response.sendRedirect("http://localhost:8095/coursework/loginn.jsp");
                }


            }




        }


        // these statement will execute when request come from adduser form

        if(request_from.equals("adduser")) {
            String username = request.getParameter("usernamecreate"); // geting the username from the adduser form
            String password = request.getParameter("passwordcreate"); // geting the password from the adduser form

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
