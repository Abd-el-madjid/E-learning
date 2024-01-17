package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;

/**
 * Servlet implementation class addModule_spec
 */
public class addModule_spec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addModule_spec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher dispatcher;
	        HttpSession session = request.getSession();
	        Daomodule Daomodule = new Daomodule();
	        List<String> listOfspecialite = new ArrayList<>();

	        if (session.getAttribute("admin") != null) {
	            //
	        	
            	 listOfspecialite	= Daomodule.getspecialitesname();
            	 session.setAttribute("listOfspecialite", listOfspecialite);
	        	dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/addmodule.jsp");
                dispatcher.forward(request, response);

	        } else {
	            //
	            LoginServlet loginServlet = new LoginServlet();
	            loginServlet.doGet(request, response);

	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 RequestDispatcher dispatcher;
         
	        HttpSession session = request.getSession();
	        Daomodule Daomodule = new Daomodule();
	        
	        if (session.getAttribute("admin") != null) {
	            //
	        	
	        	
	        	 String module = request.getParameter("module");
	        	 String specialite = request.getParameter("specialite");
	        	 
	        	boolean row= Daomodule.insertmodule(module, specialite);
	        	if(row) {
	        		
	        		 String message ="module  added";
	             		session.setAttribute("messageadd",message);
	              		  dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/addmodule.jsp");
	                        dispatcher.forward(request, response);
	                        
	                        
	              	 }else {
	              		String message ="module non added";
	              		session.setAttribute("messageadd",message);
	              		 this.doGet(request, response);
	              	 }
	        	
	        }
	else {
        
        this.doGet(request, response);

    }
	}
}
