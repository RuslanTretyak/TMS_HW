package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                Map<String, String> userInfo = null;
                try {
                    userInfo = Util.getUserInfo(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (userInfo != null) {
                    req.setAttribute("isReqSuccessful", true);
                    req.setAttribute("name", userInfo.get("name"));
                    req.setAttribute("surname", userInfo.get("surname"));
                    req.setAttribute("login", userInfo.get("login"));
                    req.setAttribute("age", userInfo.get("age"));
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
