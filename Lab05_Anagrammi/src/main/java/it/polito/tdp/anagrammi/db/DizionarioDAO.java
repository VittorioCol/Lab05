package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DizionarioDAO {
	List<String> dizionario;
	public DizionarioDAO(){
	}
	
	public List<String> getDizionario(){
		String sql="SELECT nome FROM parola";
		dizionario=new ArrayList<String>();
		Connection conn= DBConnect.getConnection();
		 try {
			 PreparedStatement st=conn.prepareStatement(sql);
			 ResultSet rs=st.executeQuery();
			 
			 while(rs.next()) {
				 dizionario.add(rs.getString("nome"));
			 }
			 rs.close();
			 st.close();
			 conn.close();
			 return dizionario;
		 }
		 catch(SQLException e) {
				e.printStackTrace();
				return null;
		}
	}
}
