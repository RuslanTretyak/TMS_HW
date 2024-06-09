package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class ChangeLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null | req.getParameter("login") == null) {
            req.setAttribute("message", "one or all parameters are not entered");
        } else {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                String newLogin = req.getParameter("login");
                if (UserService.changeUserLogin(id, newLogin)){
                    req.setAttribute("message", "new login applied");
                } else {
                    req.setAttribute("message", "user with ID " + id + " does not exist");
                }
            } catch (NumberFormatException e) {
                req.setAttribute("message", "id not correct");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/change_login.jsp").forward(req, resp);
    }
}
