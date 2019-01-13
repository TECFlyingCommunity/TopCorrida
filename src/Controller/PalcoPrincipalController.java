
package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import MainApp.MainApp;
import Model.Pessoa;
import Ultil.RELATORIO;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro marinho
 */
public class PalcoPrincipalController  {

     private MainApp mainApp;
     private boolean novapessoaok=false;
     private Pessoa pessoa;
    public void setMainApp(MainApp mainApp) {
        System.out.println("setMainApp");
        this.mainApp = mainApp;
    }
    
    
    
    @FXML
    void Salvar() {
        RELATORIO.RELATORIO(mainApp);
    }

    /**
     * Cria uma agenda vazia.
     */
   
    @FXML
    private void cadastrados(){
        System.out.println("cadastrados");
         mainApp.cadastrados();
    }
//    @FXML
//    private void handleNew() {
//        System.out.println("handleNew");
//        mainApp.getPersonData().clear();
//        mainApp.setPersonFilePath(null);
//    }
    public boolean NovaPessoaOk(){
        return novapessoaok;
    }
    /**
     * Abre o FileChooser para permitir o usuário selecionar uma agenda
     * para carregar.
     */

@FXML
    private void NovaPessoa() {
        System.out.println("NovaPessoa");
        
        boolean okClicked = mainApp.showPersonEditDialog(null);
        
        /**
         * Inicializa a classe controller. Este método é chamado automaticamente
         * após o arquivo fxml ter sido carregado.
         */
    }
    
    
    //private Label lbNome;
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // lbNome.setText(pessoa.getNome()+" "+pessoa.getSegundoNome());
    }
    
    
}
