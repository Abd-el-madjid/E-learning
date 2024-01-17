package control;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Daomodule;
 
/**
 * A servlet that retrieves a file from MySQL database and lets the client
 * downloads the file.
 * @author www.codejava.net
 */
public class download extends HttpServlet {
 
    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;   
     
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/elearning3";
    private String dbUser = "root";
    private String dbPass = "04122002";
     
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // get upload id from URL's parameters
      
    	 Daomodule Daomodule =  new Daomodule();
        String type=request.getParameter("type");
        Connection conn = null; // connection to the database
        
        if (type!=null ) {
            
            switch (type) {
                case "cour" -> {
                	String cour=request.getParameter("id_cour");
                      String idsemain = request.getParameter("id_semain");
                	   int   semainId = Integer.parseInt(idsemain); 
                	   String moduleName = request.getParameter("moduleName");
                	  
                	   int uploadId= Daomodule.getCour_id(semainId, moduleName, cour);
                       
          
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // queries the database
            String sql = "SELECT cour_pdf,cour_name FROM module_cour WHERE id_cour = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, uploadId);
 
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // gets file name and file blob data
                String fileName = result.getString("cour_name");
                Blob blob = result.getBlob("cour_pdf");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                 
                System.out.println("fileLength = " + fileLength);
                System.out.println("filename = " + fileName);
                ServletContext context = getServletContext();
 
                // sets MIME type for the file download
                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }              
                 
                
                // set content properties and header attributes for the response
                response.setContentType(mimeType);
                response.setContentLength(fileLength);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName+ ".pdf");
                response.setHeader(headerKey, headerValue);
 
                // writes the file to the client
                OutputStream outStream = response.getOutputStream();
                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                inputStream.close();
                outStream.close();             
            } else {
                // no file found
                response.getWriter().print("File not found for the id: " + uploadId);  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().print("SQL Error: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            response.getWriter().print("IO Error: " + ex.getMessage());
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }          
        }
                }
                
                case "td" -> {      
                	String td=request.getParameter("id_td");
                String idsemain = request.getParameter("id_semain");
          	   int   semainId = Integer.parseInt(idsemain); 
          	   String moduleName = request.getParameter("moduleName");
          	  
          	   int uploadId= Daomodule.gettd_id(semainId, moduleName, td);
          	 String td_type= Daomodule.gettd_type(semainId, moduleName, td);
                    try {
                        // connects to the database
                        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
             
                        // queries the database
                        String sql = "SELECT td_pdf,td_name,td_type FROM module_td WHERE id_td = ?";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setInt(1, uploadId);
             
                        ResultSet result = statement.executeQuery();
                        if (result.next()) {
                            // gets file name and file blob data
                            String fileName = result.getString("td_name");
                            Blob blob = result.getBlob("td_pdf");
                            String filetype = result.getString("td_type");
                            InputStream inputStream = blob.getBinaryStream();
                            int fileLength = inputStream.available();
                             
                            System.out.println("fileLength = " + fileLength);
             
                            ServletContext context = getServletContext();
             
                            // sets MIME type for the file download
                            String mimeType = context.getMimeType(fileName);
                            if (mimeType == null) {        
                                mimeType = "application/octet-stream";
                            }              
                            
                            // set content properties and header attributes for the response
                            response.setContentType(mimeType);
                            response.setContentLength(fileLength);
                            String headerKey = "Content-Disposition";
                            String headerValue="kk";
                            headerValue = String.format("attachment; filename=\"%s\"", fileName+ "."+filetype);
                            
                            response.setHeader(headerKey, headerValue);
                            // writes the file to the client
                            OutputStream outStream = response.getOutputStream();
                             
                            byte[] buffer = new byte[BUFFER_SIZE];
                            int bytesRead = -1;
                             
                            while ((bytesRead = inputStream.read(buffer)) != -1) {
                                outStream.write(buffer, 0, bytesRead);
                            }
                             
                            inputStream.close();
                            outStream.close(); 
                        
             
                                   
                        } else {
                            // no file found
                            response.getWriter().print("File not found for the id: " + uploadId);  
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        response.getWriter().print("SQL Error: " + ex.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        response.getWriter().print("IO Error: " + ex.getMessage());
                    } finally {
                        if (conn != null) {
                            // closes the database connection
                            try {
                                conn.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }          
                    }
                            }
                case "tp" -> {     
                	String tp=request.getParameter("id_tp");
                String idsemain = request.getParameter("id_semain");
          	   int   semainId = Integer.parseInt(idsemain); 
          	   String moduleName = request.getParameter("moduleName");
          	  
          	   int uploadId= Daomodule.gettp_id(semainId, moduleName, tp);
          	 String tp_type= Daomodule.gettp_type(semainId, moduleName, tp);
                	   try {
                           // connects to the database
                           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                           conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                
                           // queries the database
                           String sql = "SELECT tp_pdf,tp_name ,tp_type FROM module_tp WHERE id_tp = ?";
                           PreparedStatement statement = conn.prepareStatement(sql);
                           statement.setInt(1, uploadId);
                
                           ResultSet result = statement.executeQuery();
                           if (result.next()) {
                               // gets file name and file blob data
                               String fileName = result.getString("tp_name");
                               Blob blob = result.getBlob("tp_pdf");
                               String filetype = result.getString("tp_type");
                               InputStream inputStream = blob.getBinaryStream();
                               int fileLength = inputStream.available();
                                
                               System.out.println("fileLength = " + fileLength);
                
                               ServletContext context = getServletContext();
                
                               // sets MIME type for the file download
                               String mimeType = context.getMimeType(fileName);
                               if (mimeType == null) {        
                                   mimeType = "application/octet-stream";
                               }              
                                
                             
                               // set content properties and header attributes for the response
                               response.setContentType(mimeType);
                               response.setContentLength(fileLength);
                               String headerKey = "Content-Disposition";
                               String headerValue="k";
                                 
                              headerValue = String.format("attachment; filename=\"%s\"", fileName+ "."+filetype);
                               
                               response.setHeader(headerKey, headerValue);
                           
                         
                                   // writes the file to the client
                                   OutputStream outStream = response.getOutputStream();
                                    
                                   byte[] buffer = new byte[BUFFER_SIZE];
                                   int bytesRead = -1;
                                    
                                   while ((bytesRead = inputStream.read(buffer)) != -1) {
                                       outStream.write(buffer, 0, bytesRead);
                                   }
                                    
                                   inputStream.close();
                                   outStream.close(); 
                                   
                              
                                        
                           } else {
                               // no file found
                               response.getWriter().print("File not found for the id: " + uploadId);  
                           }
                       } catch (SQLException ex) {
                           ex.printStackTrace();
                           response.getWriter().print("SQL Error: " + ex.getMessage());
                       } catch (IOException ex) {
                           ex.printStackTrace();
                           response.getWriter().print("IO Error: " + ex.getMessage());
                       } finally {
                           if (conn != null) {
                               // closes the database connection
                               try {
                                   conn.close();
                               } catch (SQLException ex) {
                                   ex.printStackTrace();
                               }
                           }          
                       }
                }
            }
            }
    }
}