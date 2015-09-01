package org.bookjspjpa.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.bookjspjpa.com.entity.Automovel;

public class JDBCAutomovelDAO implements AutomovelDAO {

	private Connection abreConexao() {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void salva(Automovel automovel) {
		String sql = "insert into automoveis"
				+ "(anoFabricacao, anoModelo, marca, modelo, observacoes)"
				+ "values (?, ?, ?, ?, ?)";
		
		Connection cn = abreConexao();
		
		try{
			PreparedStatement pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, automovel.getAnoFabricacao());
			pstmt.setInt(2, automovel.getAnoModelo());
			pstmt.setString(3, automovel.getMarca());
			pstmt.setString(4, automovel.getModelo());
			pstmt.setString(5, automovel.getObservacoes());
			
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
	public List<Automovel> lista() {
		Connection cn = abreConexao();
		String sql = "select * from automoveis";
		Automovel automovel;
		List<Automovel> automoveis = null;
		try {
			PreparedStatement pstmt = cn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				automovel = new Automovel();
				//, , marca, modelo, observacoes
				automovel.setId(rs.getLong("id"));
				automovel.setAnoFabricacao(rs.getInt("anoFabricacao"));
				automovel.setAnoModelo(rs.getInt("anoModelo"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setModelo(rs.getString("modelo"));
				automovel.setObservacoes(rs.getString("observacoes"));
				
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
