import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NOMEFILE extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        //variabili ampiezza schermo
        Double width = 600.0, height = 300.0;
        //cosa voglio disegnare
        
        //Stampa tutto
        Group root = new Group();
        Scene scene = new Scene(root , width, height);
        primaryStage.setTitle("Simple Application");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	public static void main(String args[]){
        launch(args);
	}
}
