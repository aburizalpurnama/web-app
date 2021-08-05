package com.rizalpurnama.todolist.view;

import com.rizalpurnama.todolist.entity.TodoList;
import com.rizalpurnama.todolist.helper.DatabaseHelper;
import com.rizalpurnama.todolist.helper.KoneksiDatabase;
import com.rizalpurnama.todolist.repository.TodolistDao;
import com.rizalpurnama.todolist.repository.TodolistRepository;
import com.rizalpurnama.todolist.repository.TodolistRepositoryImpl;
import com.rizalpurnama.todolist.service.TodolistService;
import com.rizalpurnama.todolist.service.TodolistServiceImpl;
import lombok.SneakyThrows;

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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class AplikasiTodolist extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:mysql://localhost/db_todolist";
        String username = "root";
        String password = "admin";

        Class driver_class = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) driver_class.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(driver);
        try(Connection connection = DriverManager.getConnection(url, username, password)) {


            PrintWriter writer = resp.getWriter();
            TodolistRepository repository = new TodolistRepositoryImpl(connection);



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

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
