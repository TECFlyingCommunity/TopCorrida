/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import MainApp.MainApp;
import Model.Pessoa;
//import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class CadastradosController implements Initializable {

    @FXML
    private TableView<Pessoa> table;
    @FXML
    private TextField PesquisaField;
    @FXML
    private Label PrimeiroNomeLabel, SegundoNomeLabel, RegistroLabel, SexoLabel, TelefoneLabel, IdadeLabel;
    @FXML
    private TableColumn<Pessoa, String> PrimeiroNomeColumnPessoa;
    @FXML
    private TableColumn<Pessoa, String> SegundoNomeColumnPessoa;
    @FXML
    private TableColumn<Pessoa, String> RegistroColumnPessoa;

    @FXML
    private TextField txtPrimeiroNome, txtSegundoNome;
    @FXML
    private Button btnDeleta, btnEditar;
    @FXML
    private Button bntSalva;
    private MainApp mainApp;
    private Pessoa pessoa = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Interface de cadastrdos inicializada 12 ");
       

        table.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> showPessoaDetails(newValue));

        btnDeleta.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        btnEditar.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());

    }

   
       
        
       

   

    private ObservableList<Pessoa> findItems() {
        ObservableList<Pessoa> itensEncontrados = FXCollections
                .observableArrayList();
        for (Pessoa itens : Pessoa.all()) {
            if (itens.getNome().contains(PesquisaField.getText())) {
                itensEncontrados.add(itens);
            }
        }
        return itensEncontrados;
    }

    @FXML
    public void handle() {
        if (!PesquisaField.getText().equals("")) {
            table.setItems(findItems());
        } else {
            table.setItems(mainApp.getPersonData());
        }
    }

    private void showPessoaDetails(Pessoa pessoa) {
        System.out.println("showPessoaDetails");
        //updadeList();
//        pessoa pessoa =new pessoa();
        // Data( pessoa);

        if (pessoa != null) {

            // Preenche as labels com informações do objeto person.
            PrimeiroNomeLabel.setText(pessoa.getNome());
            RegistroLabel.setText(String.valueOf(pessoa.getId()));
            SegundoNomeLabel.setText(pessoa.getSegundoNome());
            SexoLabel.setText(pessoa.getSexo());
            TelefoneLabel.setText(pessoa.getTelefone());
            IdadeLabel.setText(pessoa.getData() + "");

        } else {
            // Person é null, remove todo o texto.
            PrimeiroNomeLabel.setText("");
            RegistroLabel.setText("");
            SegundoNomeLabel.setText("");
            SexoLabel.setText("");
            TelefoneLabel.setText("");
            IdadeLabel.setText("");
        }
    }

    public void setMainApp(MainApp mainApp) {
        System.out.println("setMainApp");
        this.mainApp = mainApp;
 table.setItems(mainApp.getPersonData());
        // Adiciona os dados da observable list na tabela
        // table.setItems(mainApp.getPersonData());
    }

    @FXML
    private void EditarPessoa() {
        System.out.println("EditarPessoa");
        Pessoa selectedPerson = table.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                // showPessoaDetails(selectedPerson);
            }

        } else {

        }

    }

    @FXML
    private void NovaPessoa() {
        System.out.println("NovaPessoa");
        Pessoa tempPerson = null;
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
//            mainApp.getPersonData().add(tempPerson);
mainApp.getPersonData();
        }
       }

    @FXML
    private void DeletaPessoa() {
        System.out.println("DeletaPessoa");
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
//            table.getItems().remove(selectedIndex);
            Pessoa p= table.getSelectionModel().getSelectedItem();
            p.delete();
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
