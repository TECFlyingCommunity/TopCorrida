/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import MainApp.MainApp;
import Model.Chegada;




/**
 * FXML Controller class
 *
 * @author pedro
 */
public class Tela2Controller implements Initializable {
    
    @FXML
    private TableView<Chegada> table;
    
    private MainApp  mainApp;
    @FXML
    private TableColumn<Chegada, String> PrimeiroNomeColumn;
    @FXML
    private TableColumn<Chegada, String> SegundoNomeColumn;
    @FXML
    private TableColumn<Chegada, String> TChegadaColumn;
    @FXML
    private Button btnDelete;
    private Chegada chegada;
    private  String PrimeiroNome, SegundoNome;
    private TopColocacaoController top;
    Integer Registro ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

         btnDelete.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        
    }    
     private void DetalhesPessoais(Chegada chegada) {// mostra dados do usuario selecionado da tabea chegada
                System.out.println("DetalhesPessoais");

        if (chegada != null) {
            PrimeiroNome=chegada.getNome();//motra o primeiro nome 
            SegundoNome=chegada.getSegundoNome();//mostra o segundo nome 
            Registro= chegada.getRegistro();//mostra o registro do usuario
    
        }
//        top.DetalhesPessoais();
    }



     
     
   
    public void setMainApp(MainApp mainApp) {
        this.mainApp    =   mainApp;

        // Adiciona os dados da observable list na tabela
        table.setItems(mainApp.getPersonData2());
//        table.setItems(mainApp.getPersonData());
        
    }
    @FXML
    private void DeletaPessoa() {
        System.out.println("DeletaPessoa");
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            table.getItems().remove(selectedIndex);
        } else {
            // Nada selecionado.

//        Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert   .setTitle       ("Erro");
//            alert   .setHeaderText  ("Selecione uma Pessoa");
//            alert   .setContentText ("Por favor, selecione uma pessoa na tabela.");
//            alert   .showAndWait    ();
        }
    }
    
}
