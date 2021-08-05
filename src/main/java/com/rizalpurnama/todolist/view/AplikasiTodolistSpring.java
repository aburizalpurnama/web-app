package com.rizalpurnama.todolist.view;

import com.rizalpurnama.todolist.entity.TodoList;
import com.rizalpurnama.todolist.helper.KoneksiDatabase;
import com.rizalpurnama.todolist.repository.TodolistDao;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/listSpring")
public class AplikasiTodolistSpring extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter writer = resp.getWriter();

            ApplicationContext springContainer = new ClassPathXmlApplicationContext("web-app.xml");
            TodolistDao repository = (TodolistDao) springContainer.getBean("repository");

            writer.println("<html>" +
                    "<head> " +
                    "<title>Todolist Application</title>" +
                    "</head> ");
            writer.println(     "<body>");
            writer.println(         "<h1>Todolist</h1>");
            writer.println(         "<table border=1>" +
                    "<thead>" +
                    "<tr>" +
                    "<th>Nomor</th>" +
                    "<th>Kegiatan</th>" +
                    "</tr>" +
                    "</thead>");
            writer.println(             "<tbody>");

            List<TodoList> list = repository.getAll();

            for (TodoList x : list){
                writer.println(                 "<tr>" +
                        "<td>"+ x.getId()+"</td>" +
                        "<td>"+ x.getActivity()+"</td>" +
                        "</tr>");
            }
            writer.println(             "</tbody>" +
                    "</table>");
            writer.println(     "</body>" +
                    "</html>");
            writer.close();

    }
}
