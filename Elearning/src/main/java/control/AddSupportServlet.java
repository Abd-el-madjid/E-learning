package control;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Daomodule;

public class AddSupportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    	 RequestDispatcher dispatcher;
         HttpSession session = request.getSession();

          Daomodule Daomodule = new Daomodule();

        if (session.getAttribute("teacher") != null) {
            //
             
        	String moduleName=request.getParameter("moduleName");
        	String delet_semain=request.getParameter("delet_semain");
        	String type=request.getParameter("type");
           

            //
           
        	
		     

            if (type!=null ) {
         
                switch (type) {
                    case "cour" -> {
                      
                        session.setAttribute("addcour",type);  
                        session.setAttribute("moduleName",moduleName);  
                        session.setAttribute("idsemain",delet_semain);  
                        
                         
                        // Forwards to admin homepage
                        dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addcour.jsp");
                        dispatcher.forward(request, response);
                    }
                    case "td" -> {
                        // Teacher Account
                       
                        session.setAttribute("addtd",type); 

                        session.setAttribute("moduleName",moduleName);  
                        session.setAttribute("idsemain",delet_semain);
                        // Forwards to teacher homepage
                        dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addtd.jsp");
                        dispatcher.forward(request, response);
                    }
                    case "tp" -> {
                        // Student Account
                    
                        session.setAttribute("addtp",type);  

                        session.setAttribute("moduleName",moduleName);  
                        session.setAttribute("idsemain",delet_semain);
                  
                        // Forwards to student homepage
                        dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addtp.jsp");
                        dispatcher.forward(request, response);
                    }

                }



        } else {
            //
            this.doGet(request, response);
        }


    }
 else {
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

        if (session.getAttribute("teacher") != null) {
            //
        	
        	
        	
        	
        
        	
        	
        	 String td_type = request.getParameter("td_type");
        	 String tp_type = request.getParameter("tp_type");
        	 
            String moduleName = request.getParameter("moduleName");
  
            String type=request.getParameter("type");
        
            String idsemain = request.getParameter("id_semain");
     	   int   semainId = Integer.parseInt(idsemain);
            System.out.println(semainId);
            //
            
            
            String cour_name = request.getParameter("cour");
            String lien_cour = request.getParameter("lien");
            
            //
            String td_name = request.getParameter("td");
            String lien_td = request.getParameter("lientd");
         
            //
            
            String tp_name = request.getParameter("tp");
            String lien_tp = request.getParameter("lientp");
         
            //
            InputStream inputStream = null; // input stream of the upload file

            String message = null;
            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("pdf");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                System.out.println(  filePart.getHeader("content-disposition"));
               System.out.println(  request.getServletContext().getRealPath(filePart.getSubmittedFileName()));
          String     filePath = getServletContext().getRealPath("")  + filePart.getSubmittedFileName() ;
                session.setAttribute("filename", filePart.getName());
                session.setAttribute("filesize", filePart.getSize());
                session.setAttribute("filecontenenttype", filePart.getContentType());

                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
        	//
          
            if (type!=null ) {
         
                switch (type) {
                    case "cour" -> {
                    	  boolean added = Daomodule.addCour(semainId, moduleName,lien_cour, cour_name,inputStream);

                        if (added) {
                            //is
                        		
                        	ModuleListServlet ModuleListServlet = new ModuleListServlet();
                        	ModuleListServlet.doGet(request, response);
                        	
                        } else {
                            //
                            this.doGet(request, response);
                        }  
                       
                      
                    }
                    case "td" -> {
                        // Teacher Account
                       
                        boolean added = Daomodule.addTD(semainId, moduleName,lien_td, td_name,inputStream,td_type);

                        if (added) {
                            //is
                        		
                        	ModuleListServlet ModuleListServlet = new ModuleListServlet();
                        	ModuleListServlet.doGet(request, response);
                        	
                        } else {
                            //
                            this.doGet(request, response);
                        }  
                    }
                    case "tp" -> {
                        
                        boolean added = Daomodule.addTP(semainId, moduleName,lien_tp, tp_name,inputStream,tp_type);

                        if (added) {
                            //is
                        		
                        	ModuleListServlet ModuleListServlet = new ModuleListServlet();
                        	ModuleListServlet.doGet(request, response);
                        	
                        } else {
                            //
                            this.doGet(request, response);
                        }
                    }

                }



        } 


        } else {
            //
            this.doGet(request, response);
        }
    	
    	}}