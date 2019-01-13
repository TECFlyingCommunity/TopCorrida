package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.TextField;
import Model.Chegada;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import MainApp.MainApp;
import Model.Pessoa;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author pedro
 */
public class TopColocacaoController implements Initializable {

    @FXML
    private TableView<Pessoa> tablePessoa;
    @FXML
    private Button btnRegistro;
    @FXML
    private Label PrimeiroNomeLabel, SegundoNomeLabel, RegistroLabel;
    @FXML
    private TableColumn<Pessoa, String> PrimeiroNomeColumnPessoa;
    @FXML
    private TableColumn<Pessoa, String> SegundoNomeColumnPessoa;
    @FXML
    private TableColumn<Pessoa, String> RegistroColumnPessoa;
    @FXML
    private TextField PesquisaField;
    private Chegada chegada;
    private MainApp mainApp;
    Tela2Controller tela;
    private boolean registroOk= false;

    @FXML
    private Label labelcronometro, labelArquivonNaoExiste;
   private int segundo;
    private int minuto;
    private int hora;
    private boolean cronometro = false;
    private String HoraChegada;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {//dados a ser inicializado em conjunto com a interface
        System.out.println("Interface de cadastrdos inicializada ");
      //tablePessoa.refresh();
      try{
      if(!primeira_cena.isShowing()){
                            contador.cancel();
                        } 
        
      }catch(Exception a){
          
      }
      
        
    }
    
  
     private Stage primeira_cena;

    public void setMainApp(MainApp mainApp,Stage primeira_cena) {
        System.out.println("setMainApp");
        this.mainApp = mainApp;
        this.primeira_cena=primeira_cena;
        tablePessoa.setItems(mainApp.getPersonData());
        
    }

   

    @FXML
    private void iniciarCronometro() {
        if (cronometro != true) {
            Cronometro();
        }
        cronometro = true;

    }

    @FXML
    private void pausarCronometro() {
        
        
        contador.cancel();
        cronometro = false;
    }

    @FXML
    private void zerarCronometro() {

        cronometro = false;
        minuto = 0;
        hora = 0;
        segundo = 0;
        contador.cancel();
        labelcronometro.setText("00:00:00");

    }
Task contador;
    @FXML
    void Cronometro() {
        contador = new Task() {

            @Override
            protected Object call() throws Exception {
                while (cronometro == true) {

                    segundo++;

                    if (segundo == 60) {
                        minuto++;
                        segundo = 0;
                    }

                    if (minuto == 60) {
                        hora++;
                        minuto = 0;
                    }
                    String hr = hora <= 9 ? "0" + hora : hora + "";
                    String min = minuto <= 9 ? "0" + minuto : minuto + "";
                    String seg = segundo <= 9 ? "0" + segundo : segundo + "";

                    Platform.runLater(() -> {

                        labelcronometro.setText(hr + ":" + min + ":" + seg);
                        HoraChegada = hr + ":" + min + ":" + seg;
                        if(!primeira_cena.isShowing()){
                            contador.cancel();
                        } 
                    });
                    Thread.sleep(1000);

                }
                return null;
            }
        };
        new Thread(contador).start();
       

    }
    
    @FXML
    private void registra(){
        handle();
        chegada();
    }
    
     private void chegada() {
         
       // ( Integer Registro,String nome, String SegundoNome,String Telefone,String Sexo,String Chegada,String Idade)
        Pessoa pessoa = tablePessoa.getSelectionModel().getSelectedItem();
         if(pessoa==null){
        pessoa=tablePessoa.getItems().get(0);
        
        }
//        if(pessoa!=null){
       Chegada chegada = new Chegada(
        pessoa.getRg(),
                pessoa.getNome(),
                pessoa.getSegundoNome(),
                pessoa.getTelefone(),
                pessoa.getSexo(),
                HoraChegada,
                pessoa.getData()
        
        );
       
//        }
          mainApp.getPersonData2().add(chegada);
        
         }
     
     
    
     
     private ObservableList<Pessoa> findItems() {
        ObservableList<Pessoa> itensEncontrados = FXCollections.observableArrayList();
        Integer ID;
        try {
            ID = Integer.parseInt(PesquisaField.getText());

        } catch (NumberFormatException a) {
            ID = null;

        }
        for (Pessoa itens : mainApp.getPersonData()) {

            //itens.getID().contains(Integer.valueOf( PesquisaField.getText())
            if (ID != null) {
                if (itens.getRg() == ID ) {
                    itensEncontrados.add(itens);
                  //  break;
                    
                } else {
                }
            } else {
                if (itens.getNome().contains(PesquisaField.getText()) ||itens.getNome().equalsIgnoreCase(PesquisaField.getText()) || itens.getSegundoNome().contains(PesquisaField.getText())) {
                    itensEncontrados.add(itens);

                }
            }
        }
        return itensEncontrados;
    }

   
 @FXML
        public void handle() { 
            if (!PesquisaField.getText().equals("")) {
                tablePessoa.setItems(findItems());
            } else {
                tablePessoa.setItems(mainApp.getPersonData());
            }
           
        }

}
