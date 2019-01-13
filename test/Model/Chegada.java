/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pedro
 */
public class Chegada {

    private StringProperty Nome = new SimpleStringProperty();
    private StringProperty SegundoNome = new SimpleStringProperty();
    private final IntegerProperty Registro = new SimpleIntegerProperty();
    private final StringProperty Chegada = new SimpleStringProperty();
    private final StringProperty Telefone = new SimpleStringProperty();
    private final StringProperty Sexo = new SimpleStringProperty();
    private final StringProperty Idade = new SimpleStringProperty("11.11.2000");

    public Chegada( Integer Registro,String nome, String SegundoNome,String Telefone,String Sexo,String Chegada,String Idade) {
        this.Nome.set(nome);
        this.SegundoNome.set(SegundoNome);
        this.Registro.set(Registro);
        this.Telefone.set(Telefone);
        this.Sexo.set(Sexo);
        this.Chegada.set(Chegada);
        this.Idade.set(Idade);
    }

    public Chegada() {
        this(null, null, null,null,null,null,null);
    }

    public String getNome() {
        System.out.println("->getNome->Chegada");
        return Nome.get();
    }

    public void setPrimeiroNome(String Nome) {
        System.out.println("->setPrimeiroNome->Chegada");
        this.Nome.set(Nome);
    }

    public StringProperty NomeProperty() {
        System.out.println("->NomeProperty->Chegada");
        return Nome;
    }

    public String getSegundoNome() {
        System.out.println("->getSegundoNome->Chegada");
        return SegundoNome.get();
    }

    public void setSegundoNome(String SegundoNome) {
        System.out.println("->setSegundoNome->Chegada");
        this.SegundoNome.set(SegundoNome);
    }

    public StringProperty SegundoNomeProperty() {
        System.out.println("->SegundoNomeProperty->Chegada");
        return SegundoNome;
    }

    public IntegerProperty RegistroProperty() {
        System.out.println("->RegistroProperty->Chegada");
        return Registro;
    }

    public Integer getRegistro() {
        System.out.println("->getRegistro->Chegada");
        return Registro.get();
    }

    public void setRegistro(Integer Registro) {
        System.out.println("->setRegistro->Chegada");
        this.Registro.set(Registro);
    }

    public String getSexo() {
        return Sexo.get();
    }

    public void setSexo(String value) {
        Sexo.set(value);
    }

    public StringProperty SexoProperty() {
        return Sexo;
    }

    public String getTelefone() {
        return Telefone.get();
    }

    public void setTelefone(String value) {
        Telefone.set(value);
    }

    public StringProperty TelefoneProperty() {
        return Telefone;
    }

    public String getChegada() {
        return Chegada.get();
    }

    public void setChegada(String value) {
        Chegada.set(value);
    }

    public StringProperty ChegadaProperty() {
        return Chegada;
    }
    public String getIdade() {
        return Idade.get();
    }

    public void setIdade(String value) {
        Idade.set(value);
    }

    public StringProperty IdadeProperty() {
        return Idade;
    }

    @Override
    public String toString() {
        return "Chegada{" + "Nome=" + Nome + ", SegundoNome=" + SegundoNome + ", Registro=" + Registro + ", Chegada=" + Chegada + ", Telefone=" + Telefone + ", Sexo=" + Sexo + ", Idade=" + Idade + '}';
    }
    
    
    
    
}
