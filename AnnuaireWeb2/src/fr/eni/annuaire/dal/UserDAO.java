package fr.eni.annuaire.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.annuaire.bo.User;

public class UserDAO {
	
		private static UserDAO instance = null;
		
		private UserDAO() {
			
		}
		
		public static UserDAO getInstance() {
			if(instance == null) {
				instance = new UserDAO();
			}
			return instance;
		}

		public void save(User user) {
			try {
				Connection cnx = ConnectionProvider.getConnection();
				
				PreparedStatement pstmt = cnx.prepareStatement("insert into Utilisateur values(?,?,?,?,?)");
				pstmt.setString(1, user.getNom());
				pstmt.setString(2, user.getPrenom());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getMdp());
				pstmt.setString(5, user.getDate());
				
				pstmt.executeUpdate();
				
				pstmt.close();
				cnx.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public List<User> findAll() {
			
			List<User> users = new ArrayList<>();
			
			try {
				Connection cnx = ConnectionProvider.getConnection();
				
				PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateur");
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setMdp(rs.getString("mdp"));
					user.setId(rs.getInt("id"));
					user.setDate(rs.getString("date_inscription"));
					
					users.add(user);
				}
				
				pstmt.close();
				cnx.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}
		
		
		public User findById(int id) {
			
			User user = new User();
			
			try {
				Connection cnx = ConnectionProvider.getConnection();
				
				PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateur where id=?");
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				rs.next();
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setMdp(rs.getString("mdp"));
					user.setDate(rs.getString("date_inscription"));
				
				pstmt.close();
				cnx.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
		
		public void update(User user)  {
			
			Connection cnx;
			try {
				cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement("update Utilisateur set nom=?,prenom=?,email=? where id=?");
				pstmt.setString(1, user.getNom());
				pstmt.setString(2, user.getPrenom());
				pstmt.setString(3, user.getEmail());
				pstmt.setInt(4, user.getId());
				
				int rows = pstmt.executeUpdate();
				System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
				
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}

		
		public void deleteByEmail(String email) {
			try {
				Connection cnx = ConnectionProvider.getConnection();
				
				PreparedStatement pstmt = cnx.prepareStatement("delete from Utilisateur where email=?");
				pstmt.setString(1, email);
				
				int rows = pstmt.executeUpdate();
				System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
				
				pstmt.close();
				cnx.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteById(int id) {
			try {
				Connection cnx = ConnectionProvider.getConnection();
				
				PreparedStatement pstmt = cnx.prepareStatement("delete from Utilisateur where id=?");
				pstmt.setInt(1, id);
				
				int rows = pstmt.executeUpdate();
				System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
				
				pstmt.close();
				cnx.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		private Connection connexionBDD() throws ClassNotFoundException, SQLException {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://localhost:1433;databaseName=Annuaire";
//			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
//			return cnx;
//		}

	
	

}
