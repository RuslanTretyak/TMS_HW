import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class SaveRequestServlet extends HttpServlet {
    String name = "";
    String surname = "";
    int age = 0;
    String email = "";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name").length() != 0) {
            req.setAttribute("isNameCorrect", true);
            name = req.getParameter("name");
            req.setAttribute("nameLine", name);
        } else if (name.length() == 0) {
            req.setAttribute("isNameCorrect", false);
            req.setAttribute("nameLine", "Name");
        } else {
            req.setAttribute("isNameCorrect", true);
            req.setAttribute("nameLine", name);
        }
        if (req.getParameter("surname").length() != 0) {
            req.setAttribute("isSurnameCorrect", true);
            surname = req.getParameter("surname");
            req.setAttribute("surnameLine", surname);
        } else if (surname.length() == 0) {
            req.setAttribute("isSurnameCorrect", false);
            req.setAttribute("surnameLine", "Surname");
        } else {
            req.setAttribute("isSurnameCorrect", true);
            req.setAttribute("surnameLine", surname);
        }
        if (req.getParameter("age").length() != 0) {
            req.setAttribute("isAgeCorrect", true);
            age = Integer.parseInt(req.getParameter("age"));
            req.setAttribute("ageLine", age);
        } else if (age <= 0) {
            req.setAttribute("isAgeCorrect", false);
            req.setAttribute("ageLine", "Age");
        } else {
            req.setAttribute("isAgeCorrect", true);
            req.setAttribute("ageLine", age);
        }
        if (req.getParameter("email").length() != 0) {
            req.setAttribute("isEmailCorrect", true);
            email = req.getParameter("email");
            req.setAttribute("emailLine", email);
        } else if (email.length() == 0) {
            req.setAttribute("isEmailCorrect", false);
            req.setAttribute("emailLine", "Email");
        } else {
            req.setAttribute("isEmailCorrect", true);
            req.setAttribute("emailLine", email);
        }
        if (name.length() != 0 && surname.length() != 0 && age > 0 && email.length() != 0) {
            req.setAttribute("name", name);
            req.setAttribute("surname", surname);
            req.setAttribute("age", age);
            req.setAttribute("email", email);
            getServletContext().getRequestDispatcher("/save_success.jsp").forward(req, resp);
            name = "";
            surname = "";
            age = 0;
            email = "";
        } else {
            getServletContext().getRequestDispatcher("/save-request.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isNameCorrect", true);
        req.setAttribute("isSurnameCorrect", true);
        req.setAttribute("isAgeCorrect", true);
        req.setAttribute("isEmailCorrect", true);
        req.setAttribute("nameLine", "Name");
        req.setAttribute("surnameLine", "Surname");
        req.setAttribute("ageLine", "Age");
        req.setAttribute("emailLine", "Email");
        getServletContext().getRequestDispatcher("/save-request.jsp").forward(req, resp);
    }
}
