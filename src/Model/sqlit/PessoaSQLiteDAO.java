///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
package Model.sqlit;


import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;


/**
 * 
 * @author  PedroMarinho pedro.marinho238@gmail.com
 */
public class PessoaSQLiteDAO extends SQLiteBase{
    
    public PessoaSQLiteDAO(){
        open();
        try {
            
          
            
            
            
            
            
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Pessoa ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "rg INT NOT NULL UNIQUE ,"
                    + "Nome TEXT NOT NULL,"
                    + "SegundoNome TEXT NOT NULL,"
                    + "Telefone VARCHAR(15),"
                    + "Sexo VARCHAR(30),"
                    + "Data VARCHAR(30) NOT NULL"
                    + ");");
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
        
    }
    
    public void creat(Pessoa p){
         open();
        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Pessoa VALUES(?,?,?,?,?,?,?);");
            
            stm.setInt(2, p.getRg());
            stm.setString(3, p.getNome());
            stm.setString(4, p.getSegundoNome());
            stm.setString(5, p.getTelefone());
            stm.setString(6, p.getSexo());
            stm.setString(7, p.getData());
            
            
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
    }
    
    public List<Pessoa> all(){
        ArrayList<Pessoa> result = new ArrayList<>();
        
          open();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Pessoa ORDER BY id ASC;");
          
            ResultSet rs =stm.executeQuery();
            while(rs.next()){
                Pessoa p = new Pessoa(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7) 
                );
                 result.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
        return result;

}
     public void update(Pessoa p){
         conn=open();
         
      
         
         
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE Pessoa SET "
                    
                    + "rg = ?,"
                    + "Nome = ?,"
                    + "SegundoNome = ?,"
                    + "Telefone = ?,"
                    + "Sexo = ?,"
                    + "Data = ? "
                    + "WHERE id = ?;");
            
            stm.setInt(1,p.getRg());
            stm.setString(2,p.getNome());
            stm.setString(3, p.getSegundoNome());
            stm.setString(4, p.getTelefone());
            stm.setString(5, p.getSexo());
            stm.setString(6, p.getData());
            stm.setInt(7, p.getId());
            
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
    }
     public void delete(Pessoa p){
         conn=open();
        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Pessoa WHERE id = ?;");
            
            
            stm.setInt(1, p.getId());
            
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
    }
     
      public Pessoa find(int pk){
        Pessoa result = null;
        
          conn=open();
        try {
            PreparedStatement stm = conn.
                    prepareStatement("SELECT * FROM Pessoa WHERE id = ?;");
            stm.setInt(1, pk);
            
          
            ResultSet rs =stm.executeQuery();
            
            if(rs.next()){
                Pessoa p = new Pessoa(
                rs.getInt(1),//id
                rs.getInt(2),//id
                rs.getString(3),//
                rs.getString(4),//
                rs.getString(5),//
                rs.getString(6),//
                rs.getString(7)//
                );
                 result = p;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
        return result;

}

    
    
    
}
