package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            req.setAttribute("message", "parameter ID is not entered");
        } else {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                if (UserService.deleteUser(id)){
                    req.setAttribute("message", "user with ID was deleted");
                } else {
                    req.setAttribute("message", "user with ID " + id + " does not exist");
                }
            } catch (NumberFormatException e) {
                req.setAttribute("message", "id not correct");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/delete_user.jsp").forward(req, resp);
    }
}
