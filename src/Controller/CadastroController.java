/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainApp.MainApp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Pessoa;
import Ultil.DataUtil;
//import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class CadastroController {

    @FXML
    private TextField PrimeiroNomeField, TelefoneField;
    @FXML
    private TextField RegistroField;
    @FXML
    private TextField SobrenomeField;
    @FXML
    private DatePicker dpData;
    private LocalDate data;
    @FXML
    private Label SexoLabel;
    private Stage dialogStage;
    private Pessoa pessoa;
    private boolean okClicked = false;
    private String dateString;
    private String SexoString;
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    @FXML
    private Button bntSalva;
       @FXML
    private MenuButton btsexo;
     @FXML
    private TableView<Pessoa> registros;
    private PalcoPrincipalController palco;
             private MainApp mainApp;

    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente após
     * o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        System.out.println("initialize");
        bntSalva.disableProperty().bind(PrimeiroNomeField.textProperty().isEmpty().or(SobrenomeField.textProperty().isEmpty()).or(RegistroField.textProperty().isEmpty()));
        // dpData.setValue(DataUtil.parse(dateString));

    }

    public static LocalDate parse(String dateString) {

        return DATE_FORMATTER.parse(dateString, LocalDate::from);

    }
   
public void setMainApp(MainApp mainApp) {
        System.out.println("setMainApp");
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        // table.setItems(mainApp.getPersonData());
    }
    /**
     * Define o palco deste dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        System.out.println("setDialogStage");
        this.dialogStage = dialogStage;
    }

    /**
     * Define a pessoa a ser editada no dialog.
     *
     * @param pessoa
     */
    public void setpessoa(Pessoa pessoa) {
        System.out.println("setpessoa");
        this.pessoa = pessoa;
        if (pessoa != null) {
            PrimeiroNomeField.setText(pessoa.getNome());
            RegistroField.setText(String.valueOf(pessoa.getRg()));
            SobrenomeField.setText(pessoa.getSegundoNome());
            TelefoneField.setText(pessoa.getTelefone());
            SexoLabel.setText(pessoa.getSexo());
            SexoString=pessoa.getSexo();
            if (pessoa.getData() != null) {
                dpData.setValue(DataUtil.parse(pessoa.getData()));
            }
            

        }

    }

    /**
     * Retorna true se o usuário clicar OK,caso contrário false.
     *
     * @return
     */
    public boolean isOkClicked() {
        System.out.println("isOkClicked");
        return okClicked;
    }

    /**
     * Chamado quando o usuário clica OK.
     */
    @FXML
    private void handleOk() {
        System.out.println("handleOk");
        registros.getItems().clear();
        PrimeiroNomeField.setStyle("");
        SobrenomeField.setStyle("");
        TelefoneField.setStyle("");
        dpData.setStyle("");
        btsexo.setStyle("");
        
        
        if (isInputValid()) {
            
            System.out.println("Verificação -> pessoa");
           if (pessoa!=null) {
//                
                pessoa.setNome(PrimeiroNomeField.getText());
                pessoa.setSegundoNome(SobrenomeField.getText());
               pessoa.setRg(Integer.parseInt(RegistroField.getText()));
                pessoa.setSexo(SexoString);
                pessoa.setTelefone(TelefoneField.getText());
                data = dpData.getValue();
                dateString = DataUtil.format(data);
                pessoa.setData(dateString);
                pessoa.save();
//                
//                
           } else {
                data = dpData.getValue();
                dateString = DataUtil.format(data);

                Pessoa p = new Pessoa(
                        Integer.valueOf(RegistroField.getText()),
                        PrimeiroNomeField.getText(),
                        SobrenomeField.getText(),
                        TelefoneField.getText(),
                        SexoString,
                        dateString
                );
                p.save();

           }

            System.out.println(Pessoa.all());
            mainApp.getPersonData();

            okClicked = true;
            
            dialogStage.close();
        }
    }

    @FXML
    private void Homem() {
        SexoString = "Homem";
        SexoLabel.setText(SexoString);
    }

    @FXML
    private void Mulher() {
        SexoString = "Mulher";
        SexoLabel.setText(SexoString);
    }

    /**
     * Chamado quando o usuário clica Cancel.
     */
    @FXML
    private void Cancel() {
        System.out.println("Cancel");
        dialogStage.close();
    }

    /**
     * Valida a entrada do usuário nos campos de texto.
     *
     * @return true se a entrada é válida
     */
    private boolean isInputValid() {
        System.out.println("isInputValid");
        String errorMessage = "";

        if (PrimeiroNomeField.getText() == null || PrimeiroNomeField.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
            PrimeiroNomeField.setStyle("-fx-border-color:red");
            
        }

        if (RegistroField.getText() == null || RegistroField.getText().length() == 0) {
            RegistroField.setStyle("-fx-border-color:red");
            errorMessage += "Registro inválido!\n";
        } else {
            try {
                int id=Integer.parseInt(RegistroField.getText());
                for (Pessoa p: mainApp.getPersonData()){
                    if(p.getRg()==id && id!=pessoa.getRg()){
                        errorMessage += "Registro inválido!\n";
                        RegistroField.setStyle("-fx-border-color:red");
                        registros.getItems().add(p);                        
                    }
                }
            } catch (NumberFormatException e) {
                errorMessage += "Registro inválido (deve ser um inteiro)!\n";
                RegistroField.setStyle("-fx-border-color:red");
            }
        }

        if (SobrenomeField.getText() == null || SobrenomeField.getText().length() == 0) {
            SobrenomeField.setStyle("-fx-border-color:red");
            errorMessage += "Sobrenome inválido!\n";
        }
        if (SexoString == null ||SexoString.length() == 0) {
            btsexo.setStyle("-fx-border-color:red");
            errorMessage += "Sexo inválido!\n";
        }
        if (dpData.getValue()== null ) {
            dpData.setStyle("-fx-border-color:red");
            errorMessage += "Data inválido!\n";
        }
        
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostra a mensagem de erro.
            System.out.println(errorMessage);
//              Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert   .setTitle       ("Erro");
//            alert   .setHeaderText  ("Erro(s)");
//            alert   .setContentText (errorMessage);
//            alert   .showAndWait    ();
            return false;
        }
    }

}
