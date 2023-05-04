package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import ConexaoFabrica.Conexao;

public class main {

	public static void main(String[] args) throws SQLException {
		//Conexao conn = new Conexao();
		//---------------------------------------------
		//Connection conn = new Conexao().conectar();	
		//---------------------------------------------
		
		String read =  "select * from carros";
		
		//Criado um método para conexão, para qualquer projeto
		Conexao conex = new Conexao();
		Connection con = null;
		con = conex.conectar();
		
		PreparedStatement pst = con.prepareStatement(read);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String nome = rs.getString("nome");
			String cor = rs.getString("cor");
			System.out.println(nome + " " + cor);
		}		
		conex.desligarConexao(con);
	}	
}
