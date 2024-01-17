package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;
import model.User;
import model.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddSemainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

          
        
        Daomodule Daomodule = new Daomodule();
        List<module> listOfmodules = new ArrayList<>(); 
        
       

        //
        if (session.getAttribute("teacher") != null) { 
        	
        	User teacher = (User) session.getAttribute("teacher");
        listOfmodules = Daomodule.getteacher_modules(teacher.getEmail());
        session.setAttribute("listOfmodules1", listOfmodules);
            //
            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/AddSemain.jsp");
            dispatcher.include(request, response);
        } else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        HttpSession session = request.getSession();
        Daomodule Daomodule = new Daomodule();

        if (session.getAttribute("teacher") != null) {
            //
            String Module = request.getParameter("Module");
            String Debut_semain = request.getParameter("Debut_semain");
            String Fin_semain = request.getParameter("Fin_semain");

            //
            boolean added = Daomodule.add_semain(Module, Debut_semain, Fin_semain);

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