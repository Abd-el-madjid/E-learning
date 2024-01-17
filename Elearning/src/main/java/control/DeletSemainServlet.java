package control;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Daomodule;

public class DeletSemainServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        Daomodule Daomodule = new Daomodule();

        if (session.getAttribute("teacher") != null) {
            //
            String semain_id = request.getParameter("delet_semain");

          int   semainId = Integer.parseInt(semain_id);
            //
            boolean deleted = Daomodule.delete_semain(semainId);

            if (deleted) {
                //
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
