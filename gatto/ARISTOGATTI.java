package gatto;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class ARISTOGATTI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1300.0, height = 700.0;
		//variabili utili
		Double YAdulti = height*3/8;
		Double YGiovani = height*2/3;
		Double sizeAdulti = 75.;
		Double sizeGiovani = sizeAdulti*2/3;
		//cosa voglio disegnare
		Group root = new Group();
		//ARISTOGATTI
		//adulti
		Gatto Duchessa = new Gatto(width*1/3, YAdulti, sizeAdulti, Color.LIGHTGREY, Color.BLUE, Color.WHITE);
		Duchessa.setStroke();
		Gatto Romeo = new Gatto(width*2/3, YAdulti, sizeAdulti, Color.ORANGE, Color.BROWN, Color.YELLOW);
		Romeo.setMuso(Romeo.getPancia());
		Romeo.setNaso(Color.BLACK);
		Romeo.setOrecchie(Color.DARKORANGE);
		//giovani
		Gatto Minou = new Gatto(width*5/6, YGiovani, sizeGiovani, Duchessa.getPelle(), Duchessa.getOcchi(), Duchessa.getPancia());
		Minou.setStroke();		
		Gatto Bizet = new Gatto(width/2, YGiovani, sizeGiovani, Color.BLACK, Color.BLUE, Color.DARKGREY);
		Bizet.setNaso(Color.BLACK);
		Gatto Matisse = new Gatto(width*1/6, YGiovani, sizeGiovani, Romeo.getPelle(), Romeo.getOcchi(), Romeo.getPancia());
		Matisse.setNaso(Color.BLACK);
		Matisse.setOrecchie(Romeo.getOrecchie());
		//disegno aristogatti
		root = Duchessa.draw(root);
		root = Romeo.draw(root);
		root = Minou.draw(root);
		root = Matisse.draw(root);
		root = Bizet.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Gli ARISTOGATTI by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
