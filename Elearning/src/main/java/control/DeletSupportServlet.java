package control;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;

public class DeletSupportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        //
        if(session.getAttribute("teacher") != null){
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/TeacherModuleDisplay.jsp");
            dispatcher.include(request,response);
        }else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request,response);
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
            String delet_info = request.getParameter("delet_info");
            String cour_id = request.getParameter("delet_cour");
            String td_id = request.getParameter("delet_td");
            String tp_id = request.getParameter("delet_tp");
            String semain_id = request.getParameter("delet_semain");
            String moduleName = request.getParameter("moduleName");
            
            HashMap<Integer, String> semains = Daomodule.getsemains(moduleName);

            List<Integer> semainsId = Daomodule.getsemains_id(moduleName);
            HashMap<Integer, HashMap<String, String>> cours = Daomodule.getCours(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> tds = Daomodule.getTDs(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> tps = Daomodule.getTPs(semainsId,moduleName);
            HashMap<Integer, String> descriptions = Daomodule.get_semains_info(semainsId,moduleName);

          
            int   semainId = Integer.parseInt(semain_id);

         // int   semainId = Integer.parseInt(semain_id);
            //
         

            if (cour_id!=null) {
                //
            	 boolean deleted = Daomodule.deleteCour(semainId, cour_id);
            	 if (deleted) {
                     //        
            		 session.setAttribute("moduleName", moduleName);
                     session.setAttribute("semains", semains);
                     session.setAttribute("cours", cours);
                     ModuleListServlet ModuleListServlet = new ModuleListServlet();
                 	ModuleListServlet.doGet(request, response);
                   
                 } else {
                     //
                     this.doGet(request, response);
                 }
            } 
            if(td_id!=null) {
                //
            	boolean deleted = Daomodule.deleteTD(semainId, td_id);
           	 if (deleted) {
            	  session.setAttribute("moduleName", moduleName);
                  session.setAttribute("semains", semains);
                  session.setAttribute("tds", tds);
                  ModuleListServlet ModuleListServlet = new ModuleListServlet();
              	ModuleListServlet.doGet(request, response);
           	} else {
                //
                this.doGet(request, response);
            }
            } 
            if(tp_id!=null) {
             	boolean deleted = Daomodule.deleteTP(semainId, tp_id);
              	 if (deleted) {
            	  session.setAttribute("moduleName", moduleName);
                  session.setAttribute("semains", semains);
                  session.setAttribute("tps", tps);
                  ModuleListServlet ModuleListServlet = new ModuleListServlet();
              	ModuleListServlet.doGet(request, response);
                 
            } else {
                //
                this.doGet(request, response);
            }
            }
            if (delet_info!=null) {
                //
            	 boolean deleted = Daomodule.delete_module_info(semainId, moduleName);
            	 if (deleted) {
                     //        
            		 session.setAttribute("moduleName", moduleName);
                     session.setAttribute("semains", semains);
                     session.setAttribute("descriptions", descriptions);
                     ModuleListServlet ModuleListServlet = new ModuleListServlet();
                 	ModuleListServlet.doGet(request, response);
                   
                 } else {
                     //
                     this.doGet(request, response);
                 }
            }

        } else {
            //
            this.doGet(request, response);
        }
    }
}
