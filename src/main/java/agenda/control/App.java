package agenda.control;

import agenda.modelo.Persona;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;    

    /**
    * Los datos como listado observable de Personas.
    */    
    private ObservableList<Persona> datoPersona = FXCollections.observableArrayList();

    /**
     * Cosntructor
     */
    
    public App(){
        //Agregando algunos datos de muestra        
        datoPersona.add(new Persona("Hans", "Muster"));
	datoPersona.add(new Persona("Ruth", "Mueller"));
	datoPersona.add(new Persona("Heinz", "Kurz"));
	datoPersona.add(new Persona("Cornelia", "Meier"));
	datoPersona.add(new Persona("Werner", "Meyer"));
	datoPersona.add(new Persona("Lydia", "Kunz"));
	datoPersona.add(new Persona("Anna", "Best"));
	datoPersona.add(new Persona("Stefhan", "Meier"));
	datoPersona.add(new Persona("Martin", "Mueller"));
    }
    /**
     * Devuelve los datos como una lista observable de Personas.
     * @return
     */
    public ObservableList<Persona> getDatoPersona(){
        return datoPersona;
    }
    
    
    
    
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AgendaApp");
        
        initRootLayout();
        showPersonOverview();
    }
    /**
    * Inicializa el diseño raíz.
    */
    private void initRootLayout() {
        try {          
            // Carga el diseño raíz desde el archivo fxml. 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/agenda/vista/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Muestra la escena que contiene el diseño raíz.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Muestra la descripción general de la persona dentro del diseño raíz.
    */    

    private void showPersonOverview() {
        try {
            // Cargar descripción general de la persona.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/agenda/vista/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Establecer la descripción general de la persona en el centro del diseño raíz.
            rootLayout.setCenter(personOverview); 
            //Dale al controlador acceso a la aplicación principal.
            PersonOverviewController controlador = loader.getController();
            controlador.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    * Abre un cuadro de diálogo para editar los detalles de la persona especificada. Si el usuario
    * hace clic en Aceptar, los cambios se guardan en el objeto de persona proporcionado y son verdaderos
    * es regresado.
    *
    * @param persona el objeto persona a editar
    * @return verdadero si el usuario hizo clic en Aceptar, falso en caso contrario.
    */
    
    public boolean showPersonEditDialog(Persona persona){
        try{
            // Cargue el archivo fxml y cree una nueva etapa para el cuadro de diálogo emergente.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/agenda/vista/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Crear el escenario de diálogo.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

           // Establecer la persona en el controlador.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPersona(persona);

            // Mostrar el diálogo y esperar hasta que el usuario lo cierre
            dialogStage.showAndWait();

            return controller.isOkClicked();
        }catch(IOException e){
            e.printStackTrace();
            return false;            
        }
    }
   
        /**
        * Vuelve al escenario principal.
        * @return
        */
        public Stage getPrimaryStage(){
            return primaryStage;
        }
    public static void main(String[] args) {
        launch(args);
    } 
}