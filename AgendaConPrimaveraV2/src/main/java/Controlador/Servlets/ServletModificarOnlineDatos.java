package Controlador.Servlets;

import Beans.Contacto;
import Controlador.AgendaController;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Created by Patata kawaii on 11/01/2017.
 */
@Component
@WebServlet("/modificar")
public class ServletModificarOnlineDatos extends HttpServlet {
//    @Autowired
//    @Qualifier("controlador")
//    private AgendaController controller;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.html");
        } else {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("tlf");
            String fechaCompleta = request.getParameter("date");
            //la fecha se separa por -
            Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");

            if (expresion.matches(expresion.pattern(), telefono)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaCompleta);
                fechaCompleta = fecha.format(formatter);
                Contacto user = new Contacto(nombre, apellido, telefono, fechaCompleta, (String) session.getAttribute("user"));
                user.setId(Integer.parseInt(request.getParameter("id")));

                ServletContext sc = getServletContext();
                WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
                AgendaController controller = (AgendaController) wac.getBean("controlador");
                controller.modificarPersona(user);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscarMes");
                rd.forward(request, response);
            } else {
                response.getWriter().append("telefono no valido");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        AgendaController controller = (AgendaController) wac.getBean("controlador");

        Contacto contacto = controller.recuperarPersona(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("contacto",contacto);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/PantallaModificar.jsp");
        rd.forward(request, response);
    }
}
