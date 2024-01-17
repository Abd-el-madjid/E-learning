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

import model.DaoUser;
import model.Daomodule;
import model.module;

/**
 * Servlet implementation class AddEtu_ENS_MO_SP
 */
public class AddEtu_ENS_MO_SP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEtu_ENS_MO_SP() {
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
	        DaoUser DaoUser =new DaoUser();
	        Daomodule Daomodule = new Daomodule();
	        List<String> listOfspecialite = new ArrayList<>();
	        String email=request.getParameter("email");
        if (session.getAttribute("admin") != null) {
            //
        
        	 switch (DaoUser.getType(email)) {
             case "teacher" -> {
            	 session.setAttribute("emailteacher", email);
            	 dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/affecteTea.jsp");
            dispatcher.include(request, response);
          
             }case "etudiant" -> {
            	 session.setAttribute("emailetudiant", email);
            	 listOfspecialite	= Daomodule.getspecialitesname();
            	 session.setAttribute("listOfspecialite", listOfspecialite);
              dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/affecteEtud.jsp");
            dispatcher.forward(request, response);
             } }
        } else {
            //
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);

        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  RequestDispatcher dispatcher;
	        HttpSession session = request.getSession();
	        if (session.getAttribute("admin") != null) {	
	        
	        Daomodule Daomodule = new Daomodule();
			 DaoUser DaoUser = new DaoUser();
		
			
			 String email = request.getParameter("email") ;
			 if(email!=null) {
			 switch (DaoUser.getType(email)) {
             case "teacher" -> {
            	 String module_specialite = request.getParameter("Module") ;
            	
          	      String[] Array = module_specialite.split("/");
          	      String sp = Array[1];
          	      String module1 = Array[0];
          	  	    System.out.println(sp);
          	  	System.out.println(module1);
          	  	
          	int module=  Daomodule.getonrmodule_specialite(module1,sp);
          	System.out.println("id module "+module);
          	int specialite = Daomodule.getspecialite_id(sp);
          	System.out.println("id specialite "+specialite);
          int id =	 DaoUser.getid(email);
          System.out.println("id teacher "+id);
            	 if(Daomodule.insert_tech_mod(id, module)) {
            		 String message ="teacher  afficte";
             		session.setAttribute("messageT",message);
              		  dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/affecteTea.jsp");
                        dispatcher.forward(request, response);
                        
                        
              	 }else {
              		 String message ="teacher  ne pas  afficte";
              		session.setAttribute("messageT",message);
              		 this.doGet(request, response);
              	 }
             }
         
             case "etudiant" -> {
            	 String specialite = request.getParameter("specialite") ;
            	
            	 if(Daomodule.insert_etu_spec(email, specialite)) {
            		 String message ="student  afficte";
              		session.setAttribute("messageE",message);
           		  dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/affecteEtud.jsp");
                     dispatcher.forward(request, response);
                     
                     
           	 }else {
           		
           		 String message ="student  ne pas  afficte";
           		session.setAttribute("messageE",message);
           		 this.doGet(request, response);
           	 }
             }
             }
			 
	        }else {
          		 String message ="etudiant ne pas afficte";
          		session.setAttribute("messageE",message);
          		 this.doGet(request, response);
          	 }
		
		 }else {
	            //
	            dispatcher = request.getRequestDispatcher("index.jsp");
	            dispatcher.include(request, response);

	        }

}
	}
