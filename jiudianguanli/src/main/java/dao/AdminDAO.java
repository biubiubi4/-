package dao;

import model.Admin;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    public static Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // 实际建议加密
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = new Admin(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
}