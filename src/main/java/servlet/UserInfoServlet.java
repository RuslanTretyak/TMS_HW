package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                User user = null;
                try {
                    user = UserService.getUserInfo(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (user != null) {
                    req.setAttribute("isReqSuccessful", true);
                    req.setAttribute("name", user.getName());
                    req.setAttribute("surname", user.getSurname());
                    req.setAttribute("login", user.getLogin());
                    req.setAttribute("age", user.getAge());
                } else {
                    req.setAttribute("isReqSuccessful", false);
                    req.setAttribute("message", "id " + id + " not found");
                }
            } catch (NumberFormatException e) {
                req.setAttribute("isReqSuccessful", false);
                req.setAttribute("message", "id not correct");
            }
        } else {
            req.setAttribute("isReqSuccessful", false);
            req.setAttribute("message", "ID is not specified in the request");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/userinfo.jsp").forward(req, resp);
    }
}
