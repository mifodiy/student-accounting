package students.web;

import students.logic.Group;
import students.logic.ManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class HelloWorldServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Список групп</H1>");
        pw.println("<table border = 1>");

        try {
            List<Group> gr = ManagementSystem.getInstance().getGroups();

            for (Group g : gr){
                pw.println("<tr>");
                pw.println("<td>" + g.getGroupId() + "</td>");
                pw.println("<td>" + g.getNameGroup() + "</td>");
                pw.println("<td>" + g.getSpeciality() + "</td>");
                pw.println("<td>" + g.getCurator() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
