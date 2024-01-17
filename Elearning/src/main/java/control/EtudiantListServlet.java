package control;

import model.DaoUser;
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
import java.util.List;

public class EtudiantListServlet extends HttpServlet {
    //
    @Serial
    private static final long serialVersionUID = 102839875784239L;

    public EtudiantListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        DaoUser DaoUser = new DaoUser();

        if (session.getAttribute("admin") != null) {
            //
            List<User> listOfEtudiant = DaoUser.getEtudiants();
         
            session.setAttribute("listOfEtudiant", listOfEtudiant);

            dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/listOfEtudiantAdmin.jsp");
            dispatcher.forward(request, response);

        } else {
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