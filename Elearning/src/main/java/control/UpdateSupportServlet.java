package control;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.DaoUser;
import model.Daomodule;
import model.User;
@MultipartConfig(maxFileSize = 16177215)
public class UpdateSupportServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 65841320986532089L;

    public UpdateSupportServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        if (session.getAttribute("teacher") != null) {
        	String type= (String)request.getSession().getAttribute("type");
        	
         	if(type!=null) {
    	    	
    	  		switch (type){
    	  		case "cour": {	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
    	        dispatcher.include(request, response);}
    	  		case "td": {	
    	  			dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTdTeacher.jsp");
                dispatcher.include(request, response);}
    	  		case "tp": {
    	  			dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTpTeacher.jsp");
                dispatcher.include(request, response);}
    	  		case "Info": { 
    	  			dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateInfoTeacher.jsp");
                dispatcher.include(request, response);}
    	  		}}
        	
        	
        	
			/*
			 * if (session.getAttribute("tp_lien") != null) { }
			 * 
			 * if (session.getAttribute("td_lien") != null) {
			 * 
			 * }
			 * 
			 * if (session.getAttribute("cour_lien") != null) {
			 * 
			 * }
			 * 
			 * if(session.getAttribute("descriptions") != null) { }
			 */
        }  else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    	 RequestDispatcher dispatcher;
    	 HttpSession session = request.getSession();
        Daomodule Daomodule = new Daomodule();
 
        
        //
        if (session.getAttribute("teacher")!= null) {  
        String Info = request.getParameter("Info");
        String newInfo = request.getParameter("newInfo");
   
      
        //
    	//String type= (String)request.getSession().getAttribute("type");
    	
         
      
        // 
       
        //
        
      
        //
         String type=request.getParameter("type");
         System.out.println(type);
     	if(type!=null) {
	    	
	  		switch (type){
	  		case "cour"->  {
	  		  String lienCour = request.getParameter("lien");
	          String newLiencour = request.getParameter("newLien");
	          String newcour = request.getParameter("newcour");
	          
	          
	          System.out.println(newLiencour);
	          System.out.println(newcour);
	          System.out.println(lienCour);
            //
        	  String cour_id = request.getParameter("cour_id");
       	   int   cour_Id = Integer.parseInt(cour_id); 
       	System.out.println(cour_Id);
        InputStream inputStream = null; 
       	  Part filePart = request.getPart("pdf");
	        if (filePart != null) {
	        	
	        	
	        	 inputStream = filePart.getInputStream();
				if (Daomodule.updateCour(cour_Id, newLiencour, newcour,inputStream)) {
	        		 session.setAttribute("type", type);
	            	 session.setAttribute("cour_id", cour_Id);
	            	 session.setAttribute("cour_name", newcour);
	            	 session.setAttribute("cour_lien", newLiencour);
	           	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
  	        dispatcher.include(request, response);
          		 }else {
                          //
          			   ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
                        	ModuleDisplayServlet.doGet(request, response);
System.out.println(newLiencour);
System.out.println(newcour);
System.out.println(lienCour);
                      }
       
  	        	
	  		}else {
	  			
	  			if (Daomodule.updateCour2(cour_Id, newLiencour, newcour)) {
 	        		 session.setAttribute("type", type);
 	            	 session.setAttribute("cour_id", cour_Id);
 	            	 session.setAttribute("cour_name", newcour);
 	            	 session.setAttribute("cour_lien", newLiencour);
 	           	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
   	        dispatcher.include(request, response);
           		 }else {
                           //
           			   ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
                         	ModuleDisplayServlet.doGet(request, response);
System.out.println(newLiencour);
System.out.println(newcour);
System.out.println(lienCour);
                       }
	  		}
        }
	  		case "td"->  {
	  		   InputStream inputStream = null; 
	        	  Part filePart = request.getPart("pdf");
	        	  String td_id = request.getParameter("td_id");
	       	   int   td_Id = Integer.parseInt(td_id); 
	          	System.out.println(td_Id);
	          
		  		  String lientd = request.getParameter("lientd");
		          String newLientd = request.getParameter("newLientd");
		          String newtd = request.getParameter("newtd");
	              if (filePart != null) {
	  	        	
	  	        	
	 	        	 inputStream = filePart.getInputStream();
	 				if (Daomodule.updateTD(td_Id, newLientd, newtd,inputStream)) {
	 	        		 session.setAttribute("type", type);
	 	        		 session.setAttribute("type", type);
	 	               	 session.setAttribute("td_id", td_id);
	 	               	 session.setAttribute("td_name", newtd);
	 	           	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
	   	        dispatcher.include(request, response);
	           		 }else {
	                           //
	           			   ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
	                         	ModuleDisplayServlet.doGet(request, response);
	                         	 System.out.println(newLientd);
	                             System.out.println(newtd);
	                             System.out.println(lientd);
	                       }
	        
	   	        	
	 	  		}  
	        	  else {
       		 if (Daomodule.updateTD2(td_Id, newLientd, newtd)) {
       			 session.setAttribute("type", type);
               	 session.setAttribute("td_id", td_id);
               	 session.setAttribute("td_name", newtd);
                		 session.setAttribute("td_lien", newLientd);
      dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTdTeacher.jsp");
      dispatcher.include(request, response);
       		  }else {
                           //
           		  ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
                	ModuleDisplayServlet.doGet(request, response);
                           System.out.println(newLientd);
                           System.out.println(newtd);
                           System.out.println(lientd);
                       }
              
        	
        	}}
        case "tp"->  {  
        	
        	  String tp_id = request.getParameter("tp_id");
        	  InputStream inputStream = null; 
        	  Part filePart = request.getPart("pdf");
        	   int   tp_Id = Integer.parseInt(tp_id); 
         	 String lientp = request.getParameter("lientp");
              String newLientp = request.getParameter("newLientp");
              String newtp = request.getParameter("newtp");
              
        	if (filePart != null) {
	        	
	        	
	        	 inputStream = filePart.getInputStream();
				if (Daomodule.updateTD(tp_Id, newLientp, newtp,inputStream)) {
					 session.setAttribute("type", type);
                  	 session.setAttribute("tp_id", tp_id);
                  	 session.setAttribute("tp_name", newtp);
                		 session.setAttribute("tp_lien", newLientp);
	           	dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
	        dispatcher.include(request, response);
       		 }else {
                       //
       			   ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
                     	ModuleDisplayServlet.doGet(request, response);
                     	 System.out.println(newLientp);
                         System.out.println(newtp);
                         System.out.println(lientp);
                   }
    
	        	
	  		}  
    	  else {
        	
        		 if (Daomodule.updateTP2(tp_Id, newLientp, newtp)) {
        		   	 session.setAttribute("type", type);
                  	 session.setAttribute("tp_id", tp_id);
                  	 session.setAttribute("tp_name", newtp);
                		 session.setAttribute("tp_lien", newLientp);
        			 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTpTeacher.jsp");
                     dispatcher.include(request, response);
	            
        		 }else {
                        //
                      
                        ModuleDisplayServlet ModuleDisplayServlet = new ModuleDisplayServlet();
                      	ModuleDisplayServlet.doGet(request, response);
                        System.out.println(newLientp);
                        System.out.println(newtp);
                        System.out.println(lientp);
                    }
        
        	
           	  //
        	
        	
        	
       
               }
        }
        	
        
        case "info"->  {
            String semain_id = request.getParameter("delet_semain");
            String moduleName = request.getParameter("moduleName");
            int   semainId = Integer.parseInt(semain_id);
        	if (Daomodule.update_module_info(semainId, moduleName, newInfo)) {
        		 ModuleListServlet ModuleListServlet = new ModuleListServlet();
              	ModuleListServlet.doGet(request, response);
       		 }else {
                       //
                       this.doGet(request, response);
System.out.println(semainId);
                   System.out.println(moduleName);
                   System.out.println(newInfo);
                   } 
        }}}
        else {
            //
       	 ModuleListServlet ModuleListServlet = new ModuleListServlet();
       	ModuleListServlet.doGet(request, response);

        }

    } else {
        //
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doGet(request, response);

    }}
    
}