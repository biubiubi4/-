package servlet;

import dao.AdminDAO;
import dao.UserDAO;
import model.Admin;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        HttpSession session = req.getSession();
        if ("admin".equals(role)) { // 管理员登录
            Admin admin = AdminDAO.getAdminByUsernameAndPassword(username, password);
            if (admin != null) {
                session.setAttribute("admin", admin);
                resp.sendRedirect("admin_dashboard.jsp");
            } else {
                req.setAttribute("error", "管理员账号或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else { // 用户登录
            User user = UserDAO.getUserByUsernameAndPassword(username, password);
            if (user != null) {
                session.setAttribute("user", user);
                resp.sendRedirect("room_types.jsp");
            } else {
                req.setAttribute("error", "用户账号或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}