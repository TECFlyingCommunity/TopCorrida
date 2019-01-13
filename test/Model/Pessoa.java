/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.sqlit.PessoaSQLiteDAO;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pedro
 */
public class Pessoa {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty rg = new SimpleIntegerProperty();
    private final StringProperty Nome = new SimpleStringProperty();
    private final StringProperty SegundoNome = new SimpleStringProperty();
    private final StringProperty Telefone = new SimpleStringProperty();
    private final StringProperty Sexo = new SimpleStringProperty();
    private final StringProperty Data = new SimpleStringProperty();

    public Pessoa(Integer Registro,String nome, String SegundoNome, String Telefone, String Sexo, String Data) {
        System.out.println("inicializando classe model Pessoa -> 5 parametros ");
        this.rg.set(Registro);
        this.Nome .set( nome);
        this.SegundoNome .set( SegundoNome);
        this.Telefone .set( Telefone);
        this.Sexo .set( Sexo);
        this.Data .set( Data);
    }

    public Pessoa(Integer id,Integer Registro, String nome, String SegundoNome, String Telefone, String Sexo, String Data) {
        System.out.println("inicializando classe model Pessoa -> 6 parametros ");
        this.id .set( id);
        this.rg.set(Registro);
        this.Nome .set( nome);
        this.SegundoNome .set( SegundoNome);
        
        this.Telefone .set( Telefone);
        this.Sexo .set( Sexo);
        this.Data .set( Data);
    }
    

    public final int getId() {
        return id.get();
    }

    public final void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public final int getRg() {
        return rg.get();
    }

    public final void setRg(int value) {
        rg.set(value);
    }

    public IntegerProperty rgProperty() {
        return rg;
    }

    public final String getNome() {
        return Nome.get();
    }

    public final void setNome(String value) {
        Nome.set(value);
    }

    public StringProperty NomeProperty() {
        return Nome;
    }

    public final String getSegundoNome() {
        return SegundoNome.get();
    }

    public final void setSegundoNome(String value) {
        SegundoNome.set(value);
    }

    public StringProperty SegundoNomeProperty() {
        return SegundoNome;
    }

    public final String getTelefone() {
        return Telefone.get();
    }

    public final void setTelefone(String value) {
        Telefone.set(value);
    }

    public StringProperty TelefoneProperty() {
        return Telefone;
    }

    public final String getSexo() {
        return Sexo.get();
    }

    public final void setSexo(String value) {
        Sexo.set(value);
    }

    public StringProperty SexoProperty() {
        return Sexo;
    }

    public final String getData() {
        return Data.get();
    }

    public final void setData(String value) {
        Data.set(value);
    }

    public StringProperty DataProperty() {
        return Data;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", rg=" + rg + ", Nome=" + Nome + ", SegundoNome=" + SegundoNome + ", Telefone=" + Telefone + ", Sexo=" + Sexo + ", Data=" + Data + '}';
    }
    
    

    //---------------------------DAO

    private static PessoaSQLiteDAO dao = new PessoaSQLiteDAO();

  
    public void save(){ 
      //  System.out.println("Verificação para save: Registro ->" + id + " Resultado do DAO.find ->" + dao.find(id));

        if(id!=null && dao.find(id.get())!=null)
            dao.update(this);
        else 
            dao.creat(this);
    }

public void delete(){
    if(dao.find(id.get())!=null)
        dao.delete(this);
}

public static List<Pessoa> all(){
    return dao.all();
}
public static Pessoa find(int pk){
    return dao.find(pk);
}

}
