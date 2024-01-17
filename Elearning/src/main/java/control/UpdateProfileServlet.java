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
import model.User;

public class UpdateProfileServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 65841320986532089L;

    public UpdateProfileServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        if (session.getAttribute("teacher") != null) {
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/UpdateProfileTeacher.jsp");
            dispatcher.include(request, response);


        } else  if (session.getAttribute("admin") != null) {
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/UpdateProfileAdmin.jsp");
            dispatcher.include(request, response);


        }else  if (session.getAttribute("etudiant") != null) {
        	 dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/UpdateProfileEtudiant.jsp");
             dispatcher.include(request, response);
        }
        else{
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    	 HttpSession session = request.getSession();
        DaoUser DaoUser = new DaoUser();
        String Password = request.getParameter("Password");
        
        String email = request.getParameter("email");
        String newemail = request.getParameter("newemail");
        String newfirstname = request.getParameter("newFirstname");
        String newlastName = request.getParameter("newLastname");
        String newPassword = request.getParameter("newPassword");
        String type = request.getParameter("type");
        String sex= request.getParameter("sex");
         User user = new User(newemail, newfirstname, newlastName, newPassword,type,sex);
         int id =DaoUser.getid(email);
         if(session.getAttribute("teacher") != null) {
        //
        	 User user2 = (User) session.getAttribute("teacher");
        	 String email2 = user2.getEmail();
        	 System.out.println(email2);
        	 System.out.println(Password);
        	boolean k= DaoUser.checkClogin(email2, Password);
        	 System.out.println(k);
        	 if(k) {
        		 boolean l = DaoUser.updateUser(id,newemail, newfirstname,newlastName,newPassword);
        		 System.out.println(l);
     	    if (l) {
        	  session.setAttribute("teacher", DaoUser.getUser(newemail));
              session.setAttribute("session", "teacher");
              session.setAttribute("email",newemail);  
              session.setAttribute("password",newPassword);
            //
        	response.setHeader("UpdateProfileServlet", "1");


        	profileServlet profileServlet = new profileServlet();
        	profileServlet.doGet(request, response);
        }} else {
            //
            this.doGet(request, response);

        }
         }  if(session.getAttribute("admin") != null) {
        	 User user2 = (User) session.getAttribute("admin");
        	 String email2 = user2.getEmail();
        	 System.out.println(email2);
        	 System.out.println(Password);
        	boolean k= DaoUser.checkClogin(email2, Password);
        	 System.out.println(k);
        	 if(k) {
        		 boolean l = DaoUser.updateUser(id,newemail, newfirstname,newlastName,newPassword);
        		 System.out.println(l);
     	    if (l) {
              	  session.setAttribute("admin", DaoUser.getUser(newemail));
                    session.setAttribute("session", "admin");
                    session.setAttribute("email",newemail);  
                    session.setAttribute("password",newPassword);
                  //
              	response.setHeader("UpdateProfileServlet", "1");


              	profileServlet profileServlet = new profileServlet();
              	profileServlet.doGet(request, response);
              } }else {
                  //
                  this.doGet(request, response);

              }
         }else
         if(session.getAttribute("etudiant") != null) {
        	 User user2 = (User) session.getAttribute("etudiant");
        	 String email2 = user2.getEmail();
        	 System.out.println(email2);
        	 System.out.println(Password);
        	boolean k= DaoUser.checkClogin(email2, Password);
        	 System.out.println(k);
        	 if(k) {
        		 boolean l = DaoUser.updateUser(id,newemail, newfirstname,newlastName,newPassword);
        		 System.out.println(l);
     	    if (l) {
           	  session.setAttribute("etudiant", DaoUser.getUser(newemail));
                 session.setAttribute("session", "etudiant");
                 session.setAttribute("email",newemail);  
                 session.setAttribute("password",newPassword);
               //
             	response.setHeader("UpdateProfileServlet", "1");
          
           	profileServlet profileServlet = new profileServlet();
           	profileServlet.doGet(request, response);
           }}else {
               //
        	   PrintWriter out = response.getWriter();

   			out.println("<script type=\"text/javascript\">");
   		       out.println("alert('password incorrect');");
   		       out.println("</script>");
               this.doGet(request, response);

           }
      }

    }
}