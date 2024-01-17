package control;

import model.Daomodule;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/listUsers")
public class beforeabdate extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 102839875784239L;

    public beforeabdate() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
       
        Daomodule Daomodule = new Daomodule();
       
        if (session.getAttribute("admin") != null) {
            //
        	
        	String email=request.getParameter("email");
        	String firstname	=request.getParameter("fname");
        	String	lastname = request.getParameter("lname");	
        	String password=	request.getParameter("password");
        	String type= 	request.getParameter("type");
        	String sex=	 request.getParameter("sex");
        	
     User  newuser = new User(email,firstname,lastname,password,type,sex);
     session.setAttribute("newuser",newuser );
     session.setAttribute("session", "newuser");
     session.setAttribute("emailkk",email );
             dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/UpdateUserAdmin.jsp");
        	dispatcher.forward(request, response);
        }
        else if (session.getAttribute("teacher") != null) {
            //
        	String semain_value=request.getParameter("semain_value");
        	String moduleName=request.getParameter("moduleName");
        	String delet_semain=request.getParameter("delet_semain");
            
        	String update_info=request.getParameter("update_info");
        	
        	String cour_name=request.getParameter("cour_name");
        	String cour_lien=request.getParameter("update_cour");
        	String td_name=request.getParameter("td_name");
            String td_lien = request.getParameter("update_td");
            String tp_name=request.getParameter("tp_name");
            String tp_lien = request.getParameter("update_tp");
            if (cour_lien!=null) {
            	
                //   
            	  int   semainId = Integer.parseInt(delet_semain);
            	 int uploadId= Daomodule.getCour_id(semainId, moduleName, cour_lien);
                 String type="cour";
            	 session.setAttribute("type", type);
            	 session.setAttribute("cour_id", uploadId);
            	 session.setAttribute("cour_name", cour_name);
            	 session.setAttribute("cour_lien", cour_lien);
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateCourTeacher.jsp");
                 	dispatcher.forward(request, response);
          } 
            if (td_lien!=null) {
                //   
            	  int   semainId = Integer.parseInt(delet_semain);
             	 int uploadId= Daomodule.gettd_id(semainId, moduleName, td_lien);
            	String type="td";
           	 session.setAttribute("type", type);
           	 session.setAttribute("td_id", uploadId);
           	 session.setAttribute("td_name", td_name);
            		 session.setAttribute("td_lien", td_lien);
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTdTeacher.jsp");
                 	dispatcher.forward(request, response);
          } 
            if (tp_lien!=null) {
                //   
            	 int   semainId = Integer.parseInt(delet_semain);
             	 int uploadId= Daomodule.gettp_id(semainId, moduleName, tp_lien);
               	String type="tp";
              	 session.setAttribute("type", type);
              	 session.setAttribute("tp_id", uploadId);
              	 session.setAttribute("tp_name", tp_name);
            		 session.setAttribute("tp_lien", tp_lien);
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateTpTeacher.jsp");
                 	dispatcher.forward(request, response);
          } 
            if (update_info!=null) {
                //   
              	String type="Info";
             	 session.setAttribute("type", type);
            		 session.setAttribute("update_info", update_info);
            		 session.setAttribute("delet_semain", delet_semain);
            		 session.setAttribute("moduleName", moduleName);
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/Support/UpdateInfoTeacher.jsp");
                 	dispatcher.forward(request, response);
          } 
            if (semain_value!=null) {
                //     
            	  int   semainId = Integer.parseInt(delet_semain);
            	  HashMap<LocalDate, LocalDate> semain = Daomodule.getsemain(moduleName,semainId);
            		 session.setAttribute("semain", semain);
            		 session.setAttribute("semain_value", semain_value);
            		 session.setAttribute("id_semain", semainId);
            		 session.setAttribute("moduleName", moduleName);
            		 dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/updateSemain.jsp");
                 	dispatcher.forward(request, response);
          } 
        	
        	
        }else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);

        }
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}