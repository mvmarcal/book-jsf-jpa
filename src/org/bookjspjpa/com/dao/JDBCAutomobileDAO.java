package org.bookjspjpa.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bookjspjpa.com.entity.Automobile;

public class JDBCAutomobileDAO implements AutomobileDAO {

	private Connection getConnection() {
		
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			
			String serverName = "localhost";
			String mydatabase = "test";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String userName = "root";
			String password = "";
			
			return DriverManager.getConnection(url,userName,password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void save(Automobile automobile) {
		String sql = "insert into automobile"
				+ "(MANUFACTURE_YEAR, MODEL_YEAR, BRAND, MODEL, COMMENTS)"
				+ "values (?, ?, ?, ?, ?)";
		
		Connection cn = getConnection();
		
		try{
			PreparedStatement pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, automobile.getManufactureYear());
			pstmt.setInt(2, automobile.getModelYear());
			pstmt.setString(3, automobile.getBrand());
			pstmt.setString(4, automobile.getModel());
			pstmt.setString(5, automobile.getComments());
			
			pstmt.execute();
			pstmt.close();
		}catch(SQLException ex1){
			throw new RuntimeException(ex1);
		}finally{
			try {
				cn.close();
			} catch (SQLException ex2) {
				throw new RuntimeException(ex2);
			}
		}

	}

	@Override
	public List<Automobile> listAll() {
		Connection cn = getConnection();
		String sql = "select * from automobile";
		Automobile automovel;
		List<Automobile> automoveis = null;
		try {
			PreparedStatement pstmt = cn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				automovel = new Automobile();
				//, , marca, modelo, observacoes
				automovel.setId(rs.getLong("ID"));
				automovel.setManufactureYear(rs.getInt("MANUFACTURE_YEAR"));
				automovel.setModelYear(rs.getInt("MODEL_YEAR"));
				automovel.setBrand(rs.getString("BRAND"));
				automovel.setModel(rs.getString("MODEL"));
				automovel.setComments(rs.getString("COMMENTS"));
				
				automoveis.add(automovel);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			try {
				cn.close();
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
		}
		return automoveis;
	}

}
