package control;

import model.DaoUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 1076546813239L;

    public AddUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") != null) {
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/AddUserAdmin.jsp");
            dispatcher.include(request, response);


        } else {
            //
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        DaoUser DaoUser = new DaoUser();

        //
	
	String email=request.getParameter("Email");
	String fname	=request.getParameter("Firstname");
	String	lname = request.getParameter("Lastname");	
	String password=	request.getParameter("Password");
	String type= 	request.getParameter("type");
	String sex=	 request.getParameter("gender");
	
        User user = new User(email, fname,lname, password, type,sex);

        //
        if (DaoUser.addUser(user)) {
            //request.setAttribute("pass", request.getParameter("Password"));
        	// send myMsg to formResult.jsp
			PrintWriter out = response.getWriter();

	
	 out.println("<script type=\"text/javascript\">");
       out.println("alert('user added successfully');");
       out.println("</script>");
            AddUserServlet AddUserServlet = new AddUserServlet();
            AddUserServlet.doGet(request, response);
        } else {
            //
            this.doGet(request, response);

        }

    }
}