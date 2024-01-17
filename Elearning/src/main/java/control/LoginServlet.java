
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoUser;

public class LoginServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 102831588973239L;

    public LoginServlet() {
        super();
    }

    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
       

        if (request.getSession().getAttribute("admin") != null) {
            //
           

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/homeAdmin.jsp");
			dispatcher.include(request, response);
        } else if (request.getSession().getAttribute("teacher") != null) {
            //
        	RequestDispatcher   dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/homeTeacher.jsp");
            dispatcher.include(request, response);

        } else if (request.getSession().getAttribute("etudiant") != null) {
            //
     

        	RequestDispatcher   dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/homeEtudiant.jsp");
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
        //
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        //
        		  boolean user = DaoUser.checkClogin(email, password);

		     

        if (user ) {
      String account =DaoUser.getType(email);


            switch (account) {
                case "admin" -> {
                    // Admin Account
                    session.setAttribute("admin", DaoUser.getUser(email));
                    session.setAttribute("session", "admin");
                    session.setAttribute("email",email);  
                    session.setAttribute("password",password);  
                     
                    // Forwards to admin homepage
                    dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/homeAdmin.jsp");
                    dispatcher.forward(request, response);
                }
                case "teacher" -> {
                    // Teacher Account
                    session.setAttribute("teacher", DaoUser.getUser(email));
                    session.setAttribute("session", "teacher");
                    session.setAttribute("email",email);  
                    session.setAttribute("password",password);
                    // Forwards to teacher homepage
                     dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/homeTeacher.jsp");
                    
                    dispatcher.forward(request, response);
                }
                case "etudiant" -> {
                    // Student Account
                    session.setAttribute("etudiant", DaoUser.getUser(email));
                    session.setAttribute("session", "etudiant");
                    session.setAttribute("email",email);  
                    session.setAttribute("password",password);
                    // Forwards to student homepage
                     dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/homeEtudiant.jsp");
                  
                    dispatcher.forward(request, response);
                }

            }

        } else {
            // Wrong Login info result in a error msg and redirect to login page
            session.setAttribute("session", null);

            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);
            PrintWriter out = response.getWriter();

			out.println("<script type=\"text/javascript\">");
		       out.println("alert('Username or password incorrect');");
		       out.println("</script>");
			
        }
        // lol
    }
}