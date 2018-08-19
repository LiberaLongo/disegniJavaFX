import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Orsetto extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//colori
		Color pellechiara = Color.SANDYBROWN;
		Color pelle = Color.BROWN;
		//variabili ampiezza schermo
		Double widthScene = 1000.0, heightScene = 700.0;
		//variabili coordinate del soggetto
		Double x = widthScene*1/2, y = heightScene*1/2;
		//proporzioni fisiche del soggetto

		//TESTA
		Double Xtesta = x;
		Double Ytesta = y-200;
		Double raggioTesta = 100.0;
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
		//guance
		Double altezzaGuance = raggioTesta*2/3;
		Double radiusXGuance = raggioTesta*2/3;
		Double radiusYGuance = raggioTesta*1/2;
		//naso
		Double altezzaNaso = raggioTesta - radiusYGuance*3/2;
		Double radiusXNaso = raggioTesta*1/8;
		Double radiusYNaso = raggioTesta*1/10;

		//CORPO
		Double radiusXCorpo = raggioTesta*2/3;
		Double radiusYCorpo = raggioTesta*3/2;
		//pancia
		Double radiusXPancia = radiusXCorpo*2/3;
		Double radiusYPancia = radiusYCorpo*2/3;
		//braccia
		Double attaccaturaAltezzaBraccia = raggioTesta*2/3;
		Double attaccaturaDistanzaBraccia = raggioTesta;
		Double radiusXBraccia = radiusYCorpo;
		Double radiusYBraccia = radiusXCorpo/2;
		Double angoloBraccia = 20.;
		//gambe
		Double radiusXGambe = radiusXCorpo/2;
		Double radiusYGambe = radiusYCorpo;
		Double attaccaturaAltezzaGambe = radiusYCorpo+radiusXGambe;
		Double attaccaturaDistanzaGambe = raggioTesta/2;
		Double angoloGambe = 20.;

		//Disegno del soggetto
		//TESTA
		//cranio
		Circle cranio = new Circle(Xtesta, Ytesta, raggioTesta);
		//orecchie esterne
		Circle orecchioSinistro = new Circle(Xtesta - distanzaOrecchie, Ytesta-altezzaOrecchie, raggioOrecchie);
		Circle orecchioDestro = new Circle(Xtesta + distanzaOrecchie, Ytesta-altezzaOrecchie, raggioOrecchie);
		Shape orecchie = Shape.union(orecchioSinistro, orecchioDestro);
		//testa
		Shape testa = Shape.union(cranio, orecchie);
		testa.setFill(pelle);
		//orecchie interne
		//preparazione orecchie interne
                Circle tD = cranio;
                Circle tS = cranio;
		Circle internosinistro = new Circle(Xtesta - distanzaOrecchieInterne, Ytesta-altezzaOrecchieInterne, raggioOrecchieInterne);
		Circle internodestro = new Circle(Xtesta + distanzaOrecchieInterne, Ytesta-altezzaOrecchieInterne, raggioOrecchieInterne);
		Shape orecchioInternoSinistro = Shape.subtract(internosinistro, tS);
		Shape orecchioInternoDestro = Shape.subtract(internodestro, tD);
		Shape orecchieInterne = Shape.union(orecchioInternoSinistro, orecchioInternoDestro);
		orecchieInterne.setFill(pellechiara);
		//orbite
		Ellipse orbitaSinistra = new Ellipse(Xtesta-distanzaOrbite, Ytesta, radiusXOrbite, radiusYOrbite);
		Ellipse orbitaDestra = new Ellipse(Xtesta+distanzaOrbite, Ytesta, radiusXOrbite, radiusYOrbite);
		Shape orbite = Shape.union(orbitaSinistra, orbitaDestra);
		orbite.setFill(pellechiara);
		//occhi
		Ellipse occhioSinistro = new Ellipse(Xtesta - distanzaOcchi, Ytesta, radiusXOcchi, radiusYOcchi);
		Ellipse occhioDestro = new Ellipse(Xtesta + distanzaOcchi, Ytesta, radiusXOcchi, radiusYOcchi);
		Shape occhi = Shape.union(occhioSinistro, occhioDestro);
		occhi.setFill(Color.WHITE);
		//pupille
		Ellipse pupillaSinistra = new Ellipse(Xtesta - distanzaPupille, Ytesta, radiusXPupille, radiusYPupille);
		Ellipse pupillaDestra = new Ellipse(Xtesta + distanzaPupille, Ytesta, radiusXPupille, radiusYPupille);
		Shape pupille = Shape.union(pupillaSinistra, pupillaDestra);
		pupille.setFill(Color.BLACK);
		pupille.setStrokeWidth(2);
		//guance
		Ellipse guance = new Ellipse(Xtesta, Ytesta+altezzaGuance, radiusXGuance, radiusYGuance);
		guance.setFill(pellechiara);
		//naso
		Ellipse naso = new Ellipse(Xtesta, Ytesta+altezzaNaso, radiusXNaso, radiusYNaso);
		naso.setFill(pelle);

		//CORPO
		Ellipse corpo = new Ellipse(x, y, radiusXCorpo, radiusYCorpo);
		corpo.setFill(pelle);
		//pancia
		Ellipse pancia = new Ellipse(x, y, radiusXPancia, radiusYPancia);
		pancia.setFill(pellechiara);
		//braccia
			//braccio sinistro
		Ellipse braccioSinistro = new Ellipse(x - attaccaturaDistanzaBraccia, y-attaccaturaAltezzaBraccia, radiusXBraccia, radiusYBraccia);
		Rotate rotazioneBraccioSinistro = new Rotate();
		rotazioneBraccioSinistro.setAngle(-angoloBraccia);
		rotazioneBraccioSinistro.setPivotX(x - attaccaturaDistanzaBraccia);
		rotazioneBraccioSinistro.setPivotY(y-attaccaturaAltezzaBraccia);
		braccioSinistro.getTransforms().addAll(rotazioneBraccioSinistro);
			//braccio destro		
		Ellipse braccioDestro = new Ellipse(x + attaccaturaDistanzaBraccia, y-attaccaturaAltezzaBraccia, radiusXBraccia, radiusYBraccia);
		Rotate rotazioneBraccioDestro = new Rotate();
		rotazioneBraccioDestro.setAngle(angoloBraccia);
		rotazioneBraccioDestro.setPivotX(x + attaccaturaDistanzaBraccia);
		rotazioneBraccioDestro.setPivotY(y-attaccaturaAltezzaBraccia);
		braccioDestro.getTransforms().addAll(rotazioneBraccioDestro);
			//entrambe le braccia
		Shape braccia = Shape.union(braccioSinistro, braccioDestro);
		braccia.setFill(pelle);
		//gambe
			//gamba sinistra
		Ellipse gambaSinistra = new Ellipse(x - attaccaturaDistanzaGambe, y+attaccaturaAltezzaGambe, radiusXGambe, radiusYGambe);
		Rotate rotazioneGambaSinistra = new Rotate();
		rotazioneGambaSinistra.setAngle(angoloGambe);
		rotazioneGambaSinistra.setPivotX(x - attaccaturaDistanzaGambe);
		rotazioneGambaSinistra.setPivotY(y+attaccaturaAltezzaGambe);
		gambaSinistra.getTransforms().addAll(rotazioneGambaSinistra);
			//gamba destra		
		Ellipse gambaDestra = new Ellipse(x + attaccaturaDistanzaGambe, y+attaccaturaAltezzaGambe, radiusXGambe, radiusYGambe);
		Rotate rotazioneGambaDestra = new Rotate();
		rotazioneGambaDestra.setAngle(-angoloGambe);
		rotazioneGambaDestra.setPivotX(x + attaccaturaDistanzaGambe);
		rotazioneGambaDestra.setPivotY(y+attaccaturaAltezzaGambe);
		gambaDestra.getTransforms().addAll(rotazioneGambaDestra);
			//entrambe le gambe
		Shape gambe = Shape.union(gambaSinistra, gambaDestra);
		gambe.setFill(pelle);

		//stampa tutto
		Group topolino = new Group();
		topolino.getChildren().addAll(gambe, braccia, corpo, pancia, testa, orbite, occhi, pupille, guance, naso, orecchieInterne);
		Scene scene = new Scene(topolino ,widthScene, heightScene);
		primaryStage.setTitle("Orsetto");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
