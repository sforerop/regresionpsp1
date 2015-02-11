package edu.uniandes.ecos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class Main extends HttpServlet {

    public static String texto = "";

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()), "/*");
        server.start();
        server.join();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("elementos") != null){
            showHome(req, resp);
        }else{
            resp.getWriter().print("Ingrese loas datos X,Y entre parentesis separados por comas todos los datos seguidos\nEjemplo: (0,1)(2,5)!");
        PrintWriter out = resp.getWriter();
        out.print("<html>\n"
                + "<body>\n"
                + "<form action=\"Main\" method=\"GET\">\n"
                + "Datos: <input type=\"text\" name=\"elementos\">\n"
                + "<br />\n"
                + "<input type=\"submit\" value=\"Submit\" />\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>");
        }        
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String valor = req.getParameter("elementos");
        System.out.println(valor);
        
    }
}
