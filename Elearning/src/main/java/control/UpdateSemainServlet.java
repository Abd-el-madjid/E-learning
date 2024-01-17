package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateSemainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSemainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      RequestDispatcher dispatcher;
	        HttpSession session = request.getSession();

	        if (session.getAttribute("teacher") != null) {
	          
	        if (session.getAttribute("semain_value") != null) {
	        	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/updateSemain.jsp");
	        dispatcher.forward(request, response);}
	     }  else {
	            //
	            LoginServlet loginServlet = new LoginServlet();
	            loginServlet.doGet(request, response);

	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session = request.getSession();
	        Daomodule Daomodule = new Daomodule();
	        if (session.getAttribute("teacher") != null) {
	        	
	        String id_semain = request.getParameter("id_semain");
	        int   semainId = Integer.parseInt(id_semain);
	        String Module = request.getParameter("Module");
            String Debut_semain = request.getParameter("Debut_semain");
            String Fin_semain = request.getParameter("Fin_semain");
            //
            boolean added = Daomodule.update_semain(Module, semainId, Debut_semain,Fin_semain);

            if (added) {
                //is
            	
            	ModuleListServlet ModuleListServlet = new ModuleListServlet();
            	ModuleListServlet.doGet(request, response);
            	
            } else {
                //
                this.doGet(request, response);
            }


        } else {
            //
            this.doGet(request, response);
        }
	}

}
