package test01;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收浏览器提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.通过JDBC,获取该数据对应的User对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?;";
        try {
            User user = qr.query(sql, new BeanHandler<>(User.class), username, password);
            //3.解决响应时的乱码问题
            response.setContentType("text/html;charset=utf-8");
            //4.判断对象是否存在
            if (user != null) {
                response.getWriter().write("<font color='green'>登陆成功</font>");
            }else{
                response.getWriter().write("<font color='red'>登陆失败</font>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
