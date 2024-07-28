package com.its.dao;

import com.its.enities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public boolean checklogin(String username, String password, HttpServletRequest request) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC", "ws", "011226");
            String sql = "select * from user where username=? and password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                user.setId(id);
                user.setName(name);
                user.setUsername(username);
                user.setPassword(password);
                list.add(user);
            }
            if (list.size() > 0) {
                HttpSession session = request.getSession();
                User user = list.get(0);
                user.setPassword("-------");
                session.setAttribute("user", user);
            }
            return list.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
