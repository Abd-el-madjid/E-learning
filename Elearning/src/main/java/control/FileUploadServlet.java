package control;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Daomodule;

@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FileUploadServlet extends HttpServlet {

     @Override
    public void init() {
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        // gets values of text fields
    	   	 RequestDispatcher dispatcher;
    	     HttpSession session = request.getSession();
    	     
    	     

    	        if (session.getAttribute("teacher") != null) {
    	      Daomodule Daomodule = new Daomodule();
    	      File file ;
    	   	  	String fullFileType;
    	   	  	
    	  	String type=request.getParameter("type");
    	  	
    	  	if(type!=null) {
    	    	
    	  		switch (type) {
    	  		case "cour"-> {
    	  			 String cour_name = request.getParameter("cour");
    	  	         String lien_cour = request.getParameter("lien");
    	  	        String moduleName=request.getParameter("moduleName");
    	  	        String idsemain = request.getParameter("id_semain");
    	  	    	   int   semainId = Integer.parseInt(idsemain);
    	  	    	   
    	  	         InputStream inputStream = null; // input stream of the upload file

    	  	        String message = null;
    	  	        // obtains the upload file part in this multipart request
    	  	        Part filePart = request.getPart("pdf");
    	  	        if (filePart != null) {
    	  	            // prints out some information for debugging
    	  	            System.out.println( "file name     :"+filePart.getName());
    	  	            System.out.println("file size     :"+filePart.getSize());
    	  	            System.out.println(filePart.getContentType());
    	  	            System.out.println(  filePart.getHeader("content-disposition"));
    	  	           System.out.println(  request.getServletContext().getRealPath(filePart.getSubmittedFileName()));
    	  	      String     filePath = getServletContext().getRealPath("")  + filePart.getSubmittedFileName() ;
    	  	    
    	  	
    	     
    	  	    System.out.println("File path: " + filePath);
    	  	            session.setAttribute("filename", filePart.getName());
    	  	            session.setAttribute("filesize", filePart.getSize());
    	  	            session.setAttribute("filecontenenttype", filePart.getContentType());

    	  	            // obtains input stream of the upload file
    	  	            inputStream = filePart.getInputStream();
    	  	        }
    	  	      boolean row = Daomodule.addCour(semainId, moduleName,lien_cour, cour_name,inputStream);
    	          if (row ) {
    	              message = "File uploaded and saved into database";
    	              System.out.println(message);
    	           
                      ModuleListServlet ModuleListServlet = new ModuleListServlet();
                  	ModuleListServlet.doGet(request, response);
    	          }else {
    	        	   dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addcour.jsp");
                       dispatcher.forward(request, response);
    	          }
    	  			
    	  		}
    			case "td"->{
    				
   	  			 String td_name = request.getParameter("td");
   	  	         String lien_td = request.getParameter("lien_td");
   	  	        String moduleName=request.getParameter("moduleName");
   	  	        String idsemain = request.getParameter("id_semain");
   	  	    	   int   semainId = Integer.parseInt(idsemain);
   	  	    	   
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
   	  	      
   	  	      
   	  	  file = new File(filePath);
   	  	fullFileType = getServletContext().getMimeType(file.getName());
	     
	      String[] fileTypeArray = fullFileType.split("/");
	      String fileType = fileTypeArray[fileTypeArray.length - 1];
	  	    System.out.println("File type: " + fileType);
	  	    
	  	    
   	  	            session.setAttribute("filename", filePart.getName());
   	  	            session.setAttribute("filesize", filePart.getSize());
   	  	            session.setAttribute("filecontenenttype", filePart.getContentType());

   	  	            // obtains input stream of the upload file
   	  	            inputStream = filePart.getInputStream();
   	  	            
   	  	       boolean row = Daomodule.addTD(semainId, moduleName,lien_td, td_name,inputStream,fileType);
   	   	          
   	  	       if (row ) {
    	              message = "File uploaded and saved into database";
    	              System.out.println(message);
    	              dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addtd.jsp");
                      dispatcher.forward(request, response);
    	          }
   	  	        }
   	  	        else {
                  //
   	       	AddSupportServlet AddSupportServlet = new AddSupportServlet();
	        	AddSupportServlet.doGet(request, response);
              }
   	  			
   	  		}
    	case "tp"-> {
    		 String tp_type = request.getParameter("tp_type");
   	  			 String tp_name = request.getParameter("tp");
   	  	         String lien_tp = request.getParameter("lien_tp");
   	  	        String moduleName=request.getParameter("moduleName");
   	  	        String idsemain = request.getParameter("id_semain");
   	  	    	   int   semainId = Integer.parseInt(idsemain);
   	  	    	   
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
   	  	            
   	  	 	  file = new File(filePath);
   	   	  	fullFileType = getServletContext().getMimeType(file.getName());
   		     
   		      String[] fileTypeArray = fullFileType.split("/");
   		      String fileType = fileTypeArray[fileTypeArray.length - 1];
   		  	    System.out.println("File type: " + fileType);

   	  	            // obtains input stream of the upload file
   	  	            inputStream = filePart.getInputStream();
   	  	       boolean row = Daomodule.addTP(semainId, moduleName,lien_tp, tp_name,inputStream,fileType);
    	          if (row ) {
    	              message = "File uploaded and saved into database";
    	              System.out.println(message);
    	              dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/Addtp.jsp");
                      dispatcher.include(request, response);
    	          }
   	  	        }
   	  	   else {
                  //
   	       	AddSupportServlet AddSupportServlet = new AddSupportServlet();
	        	AddSupportServlet.doGet(request, response);
              }
   	  			
   	  		}
    	  		}
    	    	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    	        } else {
    	            //
    	        	LoginServlet LoginServlet = new LoginServlet();
    	        	LoginServlet.doGet(request, response);
    	        }    
      

        // sets the message in request scope

    }
}