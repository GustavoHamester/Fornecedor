/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaoBD;
import java.sql.*;
/**
 *
 * @author Suporte
 */
public class Conexao {
    public static Connection Conector(){
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/senac?characterEncoding=utf-8";
        String user = "henrique";
        String password = "Dobi_203242";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
}
