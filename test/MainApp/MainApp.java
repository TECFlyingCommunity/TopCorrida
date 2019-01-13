/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Model.Chegada;
import Model.Pessoa;
import Controller.CadastradosController;
import Controller.CadastroController;
import Controller.PalcoPrincipalController;
import Controller.Tela2Controller;
import Controller.TopColocacaoController;
import javafx.scene.image.Image;

/**
 *
 * @author pedro
 */
public class MainApp extends Application {

    private Stage primeriaCena;
   private  BorderPane PalcoPrincipal;
    private Pessoa pessoa;
    
    private final ObservableList<Pessoa> personData = FXCollections.observableArrayList();
    private final ObservableList<Chegada> personData2 = FXCollections.observableArrayList();

    
    public ObservableList<Pessoa> getPersonData() {
        personData.clear();
        personData.addAll(Pessoa.all());
        System.out.println(personData);
        return personData;
        }
    public ObservableList<Chegada> getPersonData2() {
        return personData2;
        }

    @Override
    public void start(Stage primeriaCena) {
        System.out.println("start");
        this.primeriaCena = primeriaCena;
        this.primeriaCena.setTitle("Corrida");
        Image image = new Image("/Estilo/corrida.jpg");

        primeriaCena.getIcons().add(image);
         
        System.out.println( Pessoa.all());
        PalcoPrincipal();
       
        TopColocacao();
       Tela2();
    }

    public Stage getprimeriaCena() {
        System.out.println("getprimeriaCena");
        return primeriaCena;
    }
        public MainApp() {
        
      
    
    
    }

    public void PalcoPrincipal() {
        System.out.println("PalcoPrincipal");
        try {
            
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/PalcoPrincipal.fxml"));
            PalcoPrincipal = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(PalcoPrincipal);
            primeriaCena.setScene(scene);
            
            // Dá ao controller o acesso ao main app.
            PalcoPrincipalController controller = loader.getController();
            controller.setMainApp(this);

            primeriaCena.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void cadastrados() {
        System.out.println("cadastrados");
    try {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/View/cadastrados.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Cria o palco dialogStage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastrados");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primeriaCena);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        Image image = new Image("/Estilo/corrida.jpg");
        dialogStage.getIcons().add(image);

        // Define a pessoa no controller.
         CadastradosController controller = loader.getController();
        controller.setMainApp(this);

        // Mostra a janela e espera até o usuário fechar.
        dialogStage.showAndWait();

        
    } catch (IOException e) {
        e.printStackTrace();
   
    }
     
}

    public boolean showPersonEditDialog(Pessoa pessoa) {
        System.out.println("showPersonEditDialog");
    try {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/View/Cadastro.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Cria o palco dialogStage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primeriaCena);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        Image image = new Image("/Estilo/corrida.jpg");
        dialogStage.getIcons().add(image);

        // Define a pessoa no controller.
        CadastroController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setpessoa(pessoa);

        // Mostra a janela e espera até o usuário fechar.
        controller.setMainApp(this);
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    public void TopColocacao() {
        System.out.println("TopColocacao");
        try {
            
            // Carrega a TabelaDeJogos.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/TopColocacao.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define a person overview no centro do PalcoPrincipal.
           //PalcoPrincipal.setCenter(personOverview);
            PalcoPrincipal.setLeft(personOverview);

            // Dá ao controlador acesso à the main app.
            TopColocacaoController controller = loader.getController();
            controller.setMainApp(this,primeriaCena);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void Tela2(){
        System.out.println("Tela2");
        try{
            
            // Carrega a TabelaDeJogos.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/View/Tela2.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define a person overview no centro do PalcoPrincipal.
           //PalcoPrincipal.setCenter(personOverview);
            PalcoPrincipal.setCenter(personOverview);

            // Dá ao controlador acesso à the main app.
            Tela2Controller controller = loader.getController();
            controller.setMainApp(this);
            
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("main");
        // TODO code application logic here
        launch(args);
    }

}
