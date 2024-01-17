package control;


import model.Daomodule;
import model.User;
import model.module;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class ModuleListServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 1680462654L;

    public ModuleListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        Daomodule Daomodule = new Daomodule();
        List<module> listOfmodules = new ArrayList<>();
        if (session.getAttribute("teacher") != null) {
            //*
        
            User teacher = (User) session.getAttribute("teacher");
            listOfmodules = Daomodule.getteacher_modules(teacher.getEmail());
            session.setAttribute("listOfmodules",  listOfmodules);

            dispatcher = request.getRequestDispatcher("/WEB-INF/Teacher/moduleTeacher.jsp");
            dispatcher.forward(request, response);

        } else if (session.getAttribute("etudiant") != null) {
            //
            User student = (User) session.getAttribute("etudiant");
             listOfmodules = Daomodule.getEtudiandt_modules(student.getEmail());
            session.setAttribute("listOfmodules", listOfmodules);

            dispatcher = request.getRequestDispatcher("/WEB-INF/Etudiant/moduleEtudiant.jsp");
            dispatcher.forward(request, response);

        } else {
            //
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
