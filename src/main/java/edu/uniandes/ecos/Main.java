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
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter pagina=resp.getWriter();
        resp.setContentType("text/html");
        String valor = req.getParameter("elementos");        
        App app = new App();        
        App.cargarDatosPantalla(valor);
        PrintWriter out = resp.getWriter();
        out.print("B0 =" + App.getB0() + "\n");
        out.print("B1 =" + App.getB1()+ "\n");
        out.print("R =" + App.getR()+ "\n");
        out.print("R2 =" + App.getR2()+ "\n");
        out.print("YK =" + App.getYK()+ "\n");
        out.print("XK =" + App.getXK()+ "\n");
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("elementos") != null){
            showHome(req, resp);
        }else{
        PrintWriter out = resp.getWriter();
        out.print("<html>\n"
                + "<body>\n"
                + "<form action=\"/Main\" method=\"POST\">\n"
                +"Ingrese loas datos X,Y separados por comas y separe las duplas con -> \nEjemplo: 0,1->2,5->3,6\n"
                + "<br/>\n"
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
        
        
    }
}
