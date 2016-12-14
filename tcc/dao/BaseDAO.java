package br.com.tcc.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.enterprise.module.bootstrap.Main;

public class BaseDAO {
	public BaseDAO() throws IOException{
		
		
		try{
			//Necessario para utilizar o driver JDBC do MySQL
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			//Erro de driver JDBC (adicione o driver .jar do MySQL em /WEB-INF/lib ou Maven)
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException, IOException{
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("src//main//resources//conexao.properties");
			// load a properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//URL de conexao com o banco de dados
		//String url = "jdbc:mysql://localhost/salao";
		String url = prop.getProperty("jdbc.url");
		//Conecta utilizando a url , usuario e senha
		//Connection conn = DriverManager.getConnection(url,"root","");
		Connection conn = DriverManager.getConnection(url,prop.getProperty("jdbc.username"),prop.getProperty("jdbc.password"));
		return conn;
	}	
}