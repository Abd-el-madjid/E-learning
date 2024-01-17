package control;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoUser;

import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "DeleteUserServlet", value = "/deleteUser")
public class DeletUserServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 19840339L;

    public DeletUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") != null) {
            //
        
        	if(session.getAttribute("listOfUsers") != null) {
        	    dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/ListUserAdmin.jsp");
                dispatcher.include(request, response);}
            	else if(session.getAttribute("listOfTeacher") != null) {
            		  dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/listOfTeacherAdmin.jsp");
                      dispatcher.forward(request, response);
            	}
            	else if(session.getAttribute("listOfEtudiant") != null) {
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/listOfEtudiantAdmin.jsp");
                     dispatcher.forward(request, response);
            	}

        } else {
            //
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    	 RequestDispatcher dispatcher;
         HttpSession session = request.getSession();
        DaoUser DaoUser = new DaoUser();

        //
        String email = request.getParameter("k");
        String type = request.getParameter("type");
        
        //
        if (DaoUser.deleteUser(email)) {
            //
        	  switch (type) {
              case "listOfUsers" -> {
            		UserListServlet UserListServlet = new UserListServlet();
                  	UserListServlet.doGet(request, response);
              }
              case "listOfTeacher" -> {
            	  TeacherListServlet TeacherListServlet = new TeacherListServlet();
            	  TeacherListServlet.doGet(request, response);
              }
              case "listOfEtudiant" -> {
            	  EtudiantListServlet EtudiantListServlet = new EtudiantListServlet();
            	  EtudiantListServlet.doGet(request, response);
              }

          }

        } else {
            //
        	 this.doGet(request, response);
        }

    }
}