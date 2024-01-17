
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.DaoAdmin;
import model.DaoUser;
import model.User;
import model.login;

@WebServlet(name = "LoginServlet", value = "/login")
public class profileServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 102831588973239L;

    public profileServlet() {
        super();
    }

    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
       

        if (request.getSession().getAttribute("admin") != null) {
            //
           

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/profileAdmin.jsp");
			dispatcher.include(request, response);
        } else if (request.getSession().getAttribute("teacher") != null) {
            //
        	RequestDispatcher   dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/profileTeacher.jsp");
            dispatcher.include(request, response);

        } else if (request.getSession().getAttribute("etudiant") != null) {
            //
     

        	RequestDispatcher   dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/profileEtudiant.jsp");
            dispatcher.include(request, response);

        } else {
            //
          
            RequestDispatcher    dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);

        }
    }

    //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
   
        DaoUser DaoUser = new DaoUser();
        String email =(String)session.getAttribute("email");  
        String password =(String)session.getAttribute("password");  
         

        //
        		  boolean user = DaoUser.checkClogin(email, password);

		     

        if (user ) {
      String account =DaoUser.getType(email);


            switch (account) {
                case "admin" -> {
                    // Admin Account
                

                    // Forwards to admin homepage
                    dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/profileAdmin.jsp");
                    dispatcher.forward(request, response);
                }
                case "teacher" -> {
                    // Teacher Account
                   
                    // Forwards to teacher homepage
                     dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/profileTeacher.jsp");
                    
                    dispatcher.forward(request, response);
                }
                case "etudiant" -> {
                    // Student Account
                   
                    // Forwards to student homepage
                     dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/profileEtudiant.jsp");
                  
                    dispatcher.forward(request, response);
                }

            }

        } else {
            // Wrong Login info result in a error msg and redirect to login page
            session.setAttribute("session", null);

            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);
           
			
        }
        // lol
    }
}