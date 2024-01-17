package control;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ModuleDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        if (session.getAttribute("moduleName") != null
                && session.getAttribute("teacher") != null) {
        	
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/TeacherModuleDisplay.jsp");
            dispatcher.include(request, response);
        } else if (session.getAttribute("moduleName") != null
                && session.getAttribute("etudiant") != null) {
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/TeacherModuleDisplay.jsp");
            dispatcher.include(request, response);
        }else{
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
        if (session.getAttribute("teacher") != null
                || session.getAttribute("etudiant") != null) {
            //
            String moduleName = request.getParameter("module-name");
            
            HashMap<Integer, String> semains = Daomodule.getsemains(moduleName);

            //
            List<Integer> semainsId = Daomodule.getsemains_id(moduleName);
            HashMap<Integer, HashMap<String, String>> cours = Daomodule.getCours(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> cours2 = Daomodule.getCours_2(semainsId,moduleName);
            
           
            HashMap<Integer, HashMap<String, String>> tds = Daomodule.getTDs(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> tps = Daomodule.getTPs(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> tds2 = Daomodule.getTDs_2(semainsId,moduleName);
            HashMap<Integer, HashMap<String, String>> tps2= Daomodule.getTPs_2(semainsId,moduleName);
            HashMap<Integer, String> descriptions = Daomodule.get_semains_info(semainsId,moduleName);

            session.setAttribute("moduleName", moduleName);
            session.setAttribute("semains", semains);
            session.setAttribute("cours", cours);
            session.setAttribute("cours2", cours2);
            session.setAttribute("tds", tds);
            session.setAttribute("tps", tps);
            session.setAttribute("tds2", tds2);
            session.setAttribute("tps2", tps2);
            session.setAttribute("descriptions", descriptions);

            if (session.getAttribute("teacher") != null) {
                //
                dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/TeacherModuleDisplay.jsp");
                dispatcher.forward(request, response);

            } else if (session.getAttribute("etudiant") != null) {
                //
                dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/EtudiantModuleDisplay.jsp");
                dispatcher.forward(request, response);

            }

        } else {
            //
            this.doGet(request, response);
        }


    }
}