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
import java.io.Serial;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 65841320986532089L;

    public UpdateUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") != null) {
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/UpdateUserAdmin.jsp");
            dispatcher.forward(request, response);


        } else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 HttpSession session = request.getSession();
     DaoUser DaoUser = new DaoUser();

     //
     String email = request.getParameter("email");
		String emailkk= (String)request.getSession().getAttribute("emailkk");
     String newemail = request.getParameter("newemail");
     String newfirstname = request.getParameter("newFirstname");
     String newlastName = request.getParameter("newLastname");
     String newPassword = request.getParameter("newPassword");
     String type = request.getParameter("type");
     String sex= request.getParameter("sex");
      User user = new User(newemail, newfirstname, newlastName, newPassword,type,sex);
      int id =DaoUser.getid(email);
      int id2 =DaoUser.getid(emailkk);
      System.out.println(id);
      if (session.getAttribute("admin") != null) {
          //
    
      
          //
          if (DaoUser.updateUser(id,newemail, newfirstname,newlastName,newPassword)) {
        

              //
        	 
        	  UserListServlet UserListServlet = new UserListServlet();
        	  UserListServlet.doGet(request, response);

          }
          else {
               //
               this.doGet(request, response);

           }
          	   
           
         
         
      
      } else {
          //
          LoginServlet loginServlet = new LoginServlet();
          loginServlet.doGet(request, response);

      }

    }
}