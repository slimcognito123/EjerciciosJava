package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.GestionUsuarios;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Servletlogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionUsuarios gestionUsuarios;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        gestionUsuarios= new GestionUsuarios();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nombre=request.getParameter("nombreUsuario");
		String password= request.getParameter("password");
		if(gestionUsuarios.login(nombre, password)){
			HttpSession sesion= request.getSession(true);
			sesion.setAttribute("usuarioLogado",nombre);
			response.sendRedirect("ServletPrincipal");
		}else{
			RequestDispatcher requestDispatcher= getServletContext().getRequestDispatcher("/login.html");
			response.getWriter().print("<p style=\"color:red\"> Error de Login </p>");
			requestDispatcher.include(request, response);
		}
			
		
	}

}
