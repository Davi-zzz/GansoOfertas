package dao;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Dao <User>{
		
		public boolean create (User usuario) {
			
			boolean retorno = false;
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO user ");
			sql.append("	(login, senha, nome, email, id,  godMod");
			sql.append(" VALUES ");
			sql.append("	( ? , ? , ? , ?, ?, ?) ");
			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				stat.setString(1, usuario.getLogin());
				stat.setString(2, usuario.getSenha());
				stat.setString(3, usuario.getNome());
				stat.setInt(4, usuario.getId());
				stat.setBoolean(5, usuario.isGodMod());
				
				stat.execute();
				
				conn.commit();
				
				retorno = true;

			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return retorno;
		}

		@Override
		public boolean update(User usuario) {
			boolean retorno = false;
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE user ");
			sql.append("	SET login=?, senha=?, nome=?, email=?,id=?, godMod=? ");
			sql.append(" WHERE ");
			sql.append(" id = ? ");
			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				stat.setString(1, usuario.getLogin());
				stat.setString(2, usuario.getSenha());
				stat.setString(3, usuario.getNome());
				stat.setInt(4, usuario.getId());
				stat.setBoolean(5, usuario.isGodMod());
				
				stat.execute();
				
				conn.commit();
				
				retorno = true;

			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return retorno;		
			
		}

		@Override
		public boolean delete(int id) {
			
			boolean retorno = false;
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE FROM user ");
			sql.append(" WHERE ");
			sql.append(" id = ?");
			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				stat.setInt(1, id);
				
				stat.execute();
				
				conn.commit();
				
				retorno = true;

			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return retorno;
		}

		@Override
		public List<User> findAll() {
			List<User> listaUsuario = new ArrayList<User>();
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(" 	id, nome, login, senha, email, godMod ");
			sql.append("FROM ");
			sql.append("	usuario ");
			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				
				ResultSet rs = stat.executeQuery();
				
				User usuario = null;
				
				while(rs.next()) {
					usuario = new User();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(rs.getString("email"));
					usuario.setGodMod((rs.getBoolean("godMod")));
					
					listaUsuario.add(usuario);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return listaUsuario;
		}
		

		@Override
		public User findById(int id) {
			User usuario = null;
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(" 	id, nome, login, senha, email, godMod ");
			sql.append("FROM ");
			sql.append("	usuario ");
			sql.append("WHERE ");
			sql.append("	id = ? ");

			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				stat.setInt(1, id);
				
				ResultSet rs = stat.executeQuery();
				
				while(rs.next()) {
					usuario = new User();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(rs.getString("email"));
					usuario.setEmail(rs.getString("email"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return usuario;
		}
	

		public User verificarLoginSenha(String login, String senha, String email) {
			User usuario = null;
			Connection conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(" 	id, nome, login, senha, email, ");
			sql.append("FROM ");
			sql.append("	usuario ");
			sql.append("WHERE ");
			sql.append("	login = ? ");
			sql.append("	AND senha = ? ");
			sql.append("	AND email = ? ");
			
			PreparedStatement stat = null;
			try {
				stat = conn.prepareStatement(sql.toString());
				stat.setString(1, login);
				stat.setString(2, senha);
				stat.setString(3, email);
				
				ResultSet rs = stat.executeQuery();
				
				while(rs.next()) {
					usuario = new User();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setGodMod((rs.getBoolean("godMod")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				rollback(conn);
			} finally {
				closeStatement(stat);
				closeConnection(conn);
			}
			return usuario;
			
		}
		

	}


		
	

	


