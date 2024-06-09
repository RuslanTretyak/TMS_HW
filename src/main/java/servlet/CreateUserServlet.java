package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String age = req.getParameter("age");
        if (login.isEmpty() | name.isEmpty() | surname.isEmpty() | age.isEmpty()) {
            req.setAttribute("message", "not all data was entered!");
            getServletContext().getRequestDispatcher("/WEB-INF/create_user.jsp").forward(req, resp);
        } else {
            try {
                UserService.createUser(name, surname, login, Integer.parseInt(age));
                req.setAttribute("message", "user " + login + " created successful");
                getServletContext().getRequestDispatcher("/WEB-INF/create_user_successful.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/create_user.jsp").forward(req, resp);
    }
}
