import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class Orsetto extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double widthScene = 1000.0, heightScene = 700.0;
		//variabili coordinate del soggetto
		Double x = widthScene*1/2, y = heightScene*1/2;
		//proporzioni fisiche del soggetto
		//testa
		Double raggioTesta = 200.0;
		//orecchie esterne
		Double distanzaOrecchie = raggioTesta*2/3;
		Double altezzaOrecchie = raggioTesta*2/3;
		Double raggioOrecchie = raggioTesta*1/2;
		//orecchie interne
		Double distanzaOrecchieInterne = distanzaOrecchie;
		Double altezzaOrecchieInterne = altezzaOrecchie;
		Double raggioOrecchieInterne = raggioOrecchie*2/3;
		//orbite
		Double distanzaOrbite = raggioTesta*1/4;
		Double radiusXOrbite = raggioTesta*2/5;
		Double radiusYOrbite = raggioTesta*2/3;
		//occhi
		Double distanzaOcchi = distanzaOrbite - distanzaOrbite*1/10;
		Double radiusXOcchi = radiusXOrbite*1/2;
		Double radiusYOcchi = radiusYOrbite*2/3;
		//pupille
		Double distanzaPupille = distanzaOcchi*3/4;
		Double radiusXPupille = radiusXOcchi*1/2;
		Double radiusYPupille = radiusYOcchi*1/2;
		//bocca
		Double altezzaBocca = raggioTesta*2/3;
		Double radiusXBocca = raggioTesta*2/3;
		Double radiusYBocca = raggioTesta*1/2;
		//naso
		Double altezzaNaso = raggioTesta - radiusYBocca*3/2;
		Double radiusXNaso = raggioTesta*1/8;
		Double radiusYNaso = raggioTesta*1/10;

		//Disegno del soggetto
		//cranio
		Circle cranio = new Circle(x, y, raggioTesta);
		//shape per fare orecchie interne
		Circle tD = cranio;
		Circle tS = cranio;
		//orecchie esterne
		Circle orecchioSinistro = new Circle(x-distanzaOrecchie, y-altezzaOrecchie, raggioOrecchie);
		Circle orecchioDestro = new Circle(x+distanzaOrecchie, y-altezzaOrecchie, raggioOrecchie);
		Shape orecchie = Shape.union(orecchioSinistro, orecchioDestro);
		//testa
		Shape testa = Shape.union(cranio, orecchie);
		testa.setFill(Color.BLACK);
		//orecchie interne
		//preparazione orecchie interne
		Circle internosinistro = new Circle(x-distanzaOrecchieInterne, y-altezzaOrecchieInterne, raggioOrecchieInterne);
		Circle internodestro = new Circle(x+distanzaOrecchieInterne, y-altezzaOrecchieInterne, raggioOrecchieInterne);
		Shape orecchioInternoSinistro = Shape.subtract(internosinistro, tS);
		Shape orecchioInternoDestro = Shape.subtract(internodestro, tD);
		Shape orecchieInterne = Shape.union(orecchioInternoSinistro, orecchioInternoDestro);
		orecchieInterne.setFill(Color.SANDYBROWN);
		//orbite
		Ellipse orbitaSinistra = new Ellipse(x-distanzaOrbite, y, radiusXOrbite, radiusYOrbite);
		Ellipse orbitaDestra = new Ellipse(x+distanzaOrbite, y, radiusXOrbite, radiusYOrbite);
		Shape orbite = Shape.union(orbitaSinistra, orbitaDestra);
		orbite.setFill(Color.SANDYBROWN);
		//occhi
		Ellipse occhioSinistro = new Ellipse(x-distanzaOcchi, y, radiusXOcchi, radiusYOcchi);
		Ellipse occhioDestro = new Ellipse(x+distanzaOcchi, y, radiusXOcchi, radiusYOcchi);
		Shape occhi = Shape.union(occhioSinistro, occhioDestro);
		occhi.setFill(Color.WHITE);
		//pupille
		Ellipse pupillaSinistra = new Ellipse(x-distanzaPupille, y, radiusXPupille, radiusYPupille);
		Ellipse pupillaDestra = new Ellipse(x+distanzaPupille, y, radiusXPupille, radiusYPupille);
		Shape pupille = Shape.union(pupillaSinistra, pupillaDestra);
		pupille.setFill(Color.BLACK);
		pupille.setStrokeWidth(2);
		//bocca
		Ellipse bocca = new Ellipse(x, y+altezzaBocca, radiusXBocca, radiusYBocca);
		bocca.setFill(Color.SANDYBROWN);
		//naso
		Ellipse naso = new Ellipse(x, y+altezzaNaso, radiusXNaso, radiusYNaso);
		naso.setFill(Color.BLACK);

		//stampa tutto
		Group topolino = new Group();
		topolino.getChildren().addAll(testa, orbite, occhi, pupille, bocca, naso, orecchieInterne);
		Scene scene = new Scene(topolino ,widthScene, heightScene);
		primaryStage.setTitle("Orsetto");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
