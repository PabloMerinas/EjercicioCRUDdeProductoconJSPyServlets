package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import bdController.BdController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

/**
 * Servlet implementation class SvRegisterUser
 */
public class SvRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvRegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = new PrintWriter(response.getOutputStream());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Double peso = Double.parseDouble(request.getParameter("peso"));
		Integer stock = Integer.parseInt(request.getParameter("stock"));
				
		Producto producto = new Producto(nombre, descripcion, peso, stock);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Mensaje de éxito</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>");
		out.println("setTimeout(function () {");
		out.println("    window.location.href = 'index.html';");
		out.println("}, 1500);"); // Tiempo para que vuelva al index.html
		out.println("</script>");
		if (BdController.addProducto(producto)) {
			out.println("Producto añadido correctamente");
		} else {
			out.println("Error al añadir el producto");
		}
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
