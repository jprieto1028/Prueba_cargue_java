package com.cargue.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cargue.dao.ClienteDao;
import com.cargue.model.Cliente;




@WebServlet("/ClienteController")

public class ClienteController extends HttpServlet  {

	/**
	 * Servlet implementation class ProductoController
	 */
	
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ClienteController() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String opcion = request.getParameter("opcion");

			if (opcion.equals("crear")) {
				System.out.println("eligio la opcion crear");

				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/views/Crear.jsp");
				requestdispatcher.forward(request, response);

			} else if (opcion.equals("listar")) {
				ClienteDao clientedao = new ClienteDao();// se crea un nuevo objeto de producto dao
				List<Cliente> lista = new ArrayList<>();// se lista los productos
				try {
					lista = clientedao.obtenerproductos();

					for (Cliente cliente : lista) {// for each para recorrer e imprimir la lista
						System.out.println(cliente);
					}

					request.setAttribute("lista", lista);// se envia al vista para poder cargarla en la jsp
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("/views/Listar.jsp");
					requestdispatcher.forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (opcion.equals("meditar")) {
				// recibir el parametro como es un entreotoca parsearlo lo que viene del request
				// ;
				
				int Id =Integer.parseInt(request.getParameter("Id"));
				System.out.println("editar id" + Id);
				ClienteDao clientedao = new ClienteDao();// se crea un nuevo objeto de producto dao
				Cliente p = new Cliente(); // se crea un nuevo objeto de producto
				try {
					p = clientedao.obtenerproducto(Id);
					System.out.println(p);
					request.setAttribute("cliente", p);// se setea el atr4ibutp para poder enviarlo a ala jsp
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("/views/Editar.jsp");
					requestdispatcher.forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if (opcion.equals("eliminar")) {
				ClienteDao clientedao = new ClienteDao();
				
				int Id = Integer.parseInt(request.getParameter("Id"));
				try {
					clientedao.eliminar(Id);
					System.out.println("cliente Eliminado satisfactoriamente");
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
					requestdispatcher.forward(request, response);
		        } catch (SQLException e) {
		        	System.out.println("error al eliminar");
					e.printStackTrace();
				}
			}
			// response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			   String opcion = request.getParameter("opcion");

			

			if (opcion.equals("guardar")) {
				Cliente cliente = new Cliente();
				ClienteDao clientedao = new ClienteDao();
				cliente.setNombres(request.getParameter("Nombres"));
				cliente.setApellidos(request.getParameter("Apellidos"));
				cliente.setTelefono(request.getParameter("Telefono"));
				cliente.setDireccion(request.getParameter("Direccion"));

				;

				// CREAR EL OBJETO PARA PRESISTENCIA
				try {
					clientedao.guardar(cliente);
					System.out.println("Conexion enviada satisfactoriamente");
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
					requestdispatcher.forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (opcion.equals("actualizar")) {
				Cliente cliente = new Cliente();
				ClienteDao clientedao = new ClienteDao();
				cliente.setId(Integer.parseInt(request.getParameter("id")));
				cliente.setNombres(request.getParameter("Nombres"));
				cliente.setApellidos(request.getParameter("Apellidos"));
				cliente.setTelefono(request.getParameter("Telefono"));
				cliente.setDireccion(request.getParameter("Direccion"));
				try {
					clientedao.editar(cliente);
					System.out.println("Cliente Actualizado satisfactoriamente");
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
					requestdispatcher.forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} 

			// doGet(request, response);
		}

	}