package com.its.dao;

import com.its.enities.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DemoDao {

    public boolean save(Demo demo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC","ws","011226");
            String sql="insert into demo(info,remark) values(?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, demo.getInfo());
            ps.setString(2, demo.getRemark());
            int i=ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public List<Demo> query() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC","ws","011226");
            String sql="select * from demo";
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<Demo> list=new ArrayList<>();
            while (rs.next()) {
                Demo demo=new Demo();
                int id=rs.getInt("id");
                String info=rs.getString("info");
                String remark=rs.getString("remark");
                demo.setId(id);
                demo.setInfo(info);
                demo.setRemark(remark);
                list.add(demo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
