package com.cargue.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cargue.conexion.Conexion;
import com.cargue.model.Cliente;


public class ClienteDao {

	public ClienteDao() {

	}

	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	// guardar es igual al insert
	public boolean guardar(Cliente producto) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerconexion();

		// transacciones apartir de aca
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO CLIENTES(Id,Nombres,Apellidos,Telefono,Direccion)VALUES(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, producto.getId());
			statement.setString(2, producto.getNombres());
			statement.setString(3, producto.getApellidos());
			statement.setString(4, producto.getTelefono());
			statement.setString(5, producto.getDireccion());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	// guardar
	public boolean editar(Cliente cliente) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerconexion();

		try {
			connection.setAutoCommit(false);
			sql = "UPDATE clientes set Nombres=?, Apellidos=?,Telefono=?,Direccion=? WHERE Id=?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, cliente.getNombres());
			statement.setString(2, cliente.getApellidos());
			statement.setString(3, cliente.getTelefono());
			statement.setString(4, cliente.getDireccion());
			statement.setInt(5, cliente.getId());
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();

		}

		return estadoOperacion;
	}

	// eliminar
	public boolean eliminar(int IdCliente) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerconexion();

		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM clientes WHERE Id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, IdCliente);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();

		}

		return estadoOperacion;
	}

	// listar producto
	public List<Cliente> obtenerproductos() throws SQLException {
		ResultSet resultset = null;// objeto que meobtiene tosos losregistros de la conuslta que se hace a la base
									// de datos
		List<Cliente> listaproducto = new ArrayList<>();
		String sql = null;
		estadoOperacion = false;
		connection = obtenerconexion();
		try {
			sql = "SELECT * FROM clientes";
			statement = connection.prepareStatement(sql);
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Cliente p = new Cliente();
				p.setId(resultset.getInt(1));
				p.setNombres(resultset.getString(2));
				p.setApellidos(resultset.getString(3));
				p.setTelefono(resultset.getString(4));
				p.setDireccion(resultset.getString(5));
				listaproducto.add(p);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listaproducto;
	}

	// obtener un solo producto
	public Cliente obtenerproducto(int IdCliente) throws SQLException {

		ResultSet resultset = null;// objeto que me obtiene todos los registros de la conuslta que se hace a la
									// base
									// de datos
		Cliente p = new Cliente();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerconexion();
		try {
			sql = "select * FROM clientes where Id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, IdCliente);
			resultset = statement.executeQuery();

			if (resultset.next()) {
				p.setId(resultset.getInt(1));
				p.setNombres(resultset.getString(2));
				p.setApellidos(resultset.getString(3));
				p.setTelefono(resultset.getString(4));
				p.setDireccion(resultset.getString(5));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return p;
	}

	// obtener conexion llama la clase Conexion
	private Connection obtenerconexion() throws SQLException {
		return Conexion.getConnection();
	}

}
