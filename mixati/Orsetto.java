package mixati;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Orsetto {
	private Double x;
	private Double y;
	private Double size;
	private Color pelle;
	private Color pellechiara;
	private Double angle;

	Orsetto(Double x, Double y, Double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.pelle = Color.BROWN;
		this.pellechiara = Color.SANDYBROWN;
		this.angle = 20.;
	}

	Orsetto(Double x, Double y, Double size, Color pelle, Color pellechiara) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.pelle = pelle;
		this.pellechiara = pellechiara;
		this.angle = 20.;
	}

	Orsetto(Double x, Double y, Double size, Color pelle, Color pellechiara, Double angle) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.pelle = pelle;
		this.pellechiara = pellechiara;
		this.angle = angle;
	}

	public Group drawHead(Group root) {
		//PROPORZIONI

		Double Ytesta = y-size * 2;
		//orecchie esterne
		Double distanzaOrecchie = size*2/3;
		Double altezzaOrecchie = size*2/3;
		Double raggioOrecchie = size*1/2;
		//orecchie interne
		Double distanzaOrecchieInterne = distanzaOrecchie;
		Double altezzaOrecchieInterne = altezzaOrecchie;
		Double raggioOrecchieInterne = raggioOrecchie*2/3;
		//orbite
		Double distanzaOrbite = size*1/4;
		Double radiusXOrbite = size*2/5;
		Double radiusYOrbite = size*2/3;
		//occhi
		Double distanzaOcchi = distanzaOrbite - distanzaOrbite*1/10;
		Double radiusXOcchi = radiusXOrbite*1/2;
		Double radiusYOcchi = radiusYOrbite*2/3;
		//pupille
		Double distanzaPupille = distanzaOcchi*3/4;
		Double radiusXPupille = radiusXOcchi*1/2;
		Double radiusYPupille = radiusYOcchi*1/2;
		//guance
		Double altezzaGuance = size*2/3;
		Double radiusXGuance = size*2/3;
		Double radiusYGuance = size*1/2;
		//naso
		Double altezzaNaso = size - radiusYGuance*3/2;
		Double radiusXNaso = size*1/8;
		Double radiusYNaso = size*1/10;
		
		//DISEGNO
		
		//cranio
		Circle cranio = new Circle(x, Ytesta, size);
		//orecchie esterne
		Circle orecchioSinistro = new Circle(x - distanzaOrecchie, Ytesta-altezzaOrecchie, raggioOrecchie);
		Circle orecchioDestro = new Circle(x + distanzaOrecchie, Ytesta-altezzaOrecchie, raggioOrecchie);
		Shape orecchie = Shape.union(orecchioSinistro, orecchioDestro);
		//testa
		Shape testa = Shape.union(cranio, orecchie);
		testa.setFill(pelle);
		//orecchie interne
		//preparazione orecchie interne
	        Circle tD = cranio;
	        Circle tS = cranio;
		Circle internosinistro = new Circle(x - distanzaOrecchieInterne, Ytesta-altezzaOrecchieInterne, raggioOrecchieInterne);
		Circle internodestro = new Circle(x + distanzaOrecchieInterne, Ytesta-altezzaOrecchieInterne, raggioOrecchieInterne);
		Shape orecchioInternoSinistro = Shape.subtract(internosinistro, tS);
		Shape orecchioInternoDestro = Shape.subtract(internodestro, tD);
		Shape orecchieInterne = Shape.union(orecchioInternoSinistro, orecchioInternoDestro);
		orecchieInterne.setFill(pellechiara);
		//orbite
		Ellipse orbitaSinistra = new Ellipse(x-distanzaOrbite, Ytesta, radiusXOrbite, radiusYOrbite);
		Ellipse orbitaDestra = new Ellipse(x+distanzaOrbite, Ytesta, radiusXOrbite, radiusYOrbite);
		Shape orbite = Shape.union(orbitaSinistra, orbitaDestra);
		orbite.setFill(pellechiara);
		//occhi
		Ellipse occhioSinistro = new Ellipse(x - distanzaOcchi, Ytesta, radiusXOcchi, radiusYOcchi);
		Ellipse occhioDestro = new Ellipse(x + distanzaOcchi, Ytesta, radiusXOcchi, radiusYOcchi);
		Shape occhi = Shape.union(occhioSinistro, occhioDestro);
		occhi.setFill(Color.WHITE);
		occhi.setStroke(Color.BLACK);
		//pupille
		Ellipse pupillaSinistra = new Ellipse(x - distanzaPupille, Ytesta, radiusXPupille, radiusYPupille);
		Ellipse pupillaDestra = new Ellipse(x + distanzaPupille, Ytesta, radiusXPupille, radiusYPupille);
		Shape pupille = Shape.union(pupillaSinistra, pupillaDestra);
		pupille.setFill(Color.BLACK);
		//guance
		Ellipse guance = new Ellipse(x, Ytesta+altezzaGuance, radiusXGuance, radiusYGuance);
		guance.setFill(pellechiara);
		guance.setStroke(Color.BLACK);
		//naso
		Ellipse naso = new Ellipse(x, Ytesta+altezzaNaso, radiusXNaso, radiusYNaso);
		naso.setFill(pelle);
		
		//INSERISCO IN GROUP
		root.getChildren().addAll(testa, orbite, occhi, pupille, guance, naso, orecchieInterne);
		return root;		
	}

	public Group drawBody(Group root) {
		//PROPORZIONI

		//corpo
		Double radiusXCorpo = size*2/3;
		Double radiusYCorpo = size*3/2;
		//pancia
		Double radiusXPancia = radiusXCorpo*2/3;
		Double radiusYPancia = radiusYCorpo*2/3;
		//braccia
		Double attaccaturaAltezzaBraccia = size*2/3;
		Double attaccaturaDistanzaBraccia = size;
		Double radiusXBraccia = radiusYCorpo;
		Double radiusYBraccia = radiusXCorpo/2;
		//gambe
		Double radiusXGambe = radiusXCorpo/2;
		Double radiusYGambe = radiusYCorpo;
		Double attaccaturaAltezzaGambe = radiusYCorpo+radiusXGambe;
		Double attaccaturaDistanzaGambe = size/2;

		//DISEGNO
		
		//corpo
		Ellipse corpo = new Ellipse(x, y, radiusXCorpo, radiusYCorpo);
		corpo.setFill(pelle);
		//pancia
		Ellipse pancia = new Ellipse(x, y, radiusXPancia, radiusYPancia);
		pancia.setFill(pellechiara);
		//braccia
			//braccio sinistro
		Ellipse braccioSinistro = new Ellipse(x - attaccaturaDistanzaBraccia, y-attaccaturaAltezzaBraccia, radiusXBraccia, radiusYBraccia);
		Rotate rotazioneBraccioSinistro = new Rotate();
		rotazioneBraccioSinistro.setAngle(-angle);
		rotazioneBraccioSinistro.setPivotX(x - attaccaturaDistanzaBraccia);
		rotazioneBraccioSinistro.setPivotY(y-attaccaturaAltezzaBraccia);
		braccioSinistro.getTransforms().addAll(rotazioneBraccioSinistro);
			//braccio destro
		Ellipse braccioDestro = new Ellipse(x + attaccaturaDistanzaBraccia, y-attaccaturaAltezzaBraccia, radiusXBraccia, radiusYBraccia);
		Rotate rotazioneBraccioDestro = new Rotate();
		rotazioneBraccioDestro.setAngle(angle);
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
		rotazioneGambaSinistra.setAngle(angle);
		rotazioneGambaSinistra.setPivotX(x - attaccaturaDistanzaGambe);
		rotazioneGambaSinistra.setPivotY(y+attaccaturaAltezzaGambe);
		gambaSinistra.getTransforms().addAll(rotazioneGambaSinistra);
			//gamba destra
		Ellipse gambaDestra = new Ellipse(x + attaccaturaDistanzaGambe, y+attaccaturaAltezzaGambe, radiusXGambe, radiusYGambe);
		Rotate rotazioneGambaDestra = new Rotate();
		rotazioneGambaDestra.setAngle(-angle);
		rotazioneGambaDestra.setPivotX(x + attaccaturaDistanzaGambe);
		rotazioneGambaDestra.setPivotY(y+attaccaturaAltezzaGambe);
		gambaDestra.getTransforms().addAll(rotazioneGambaDestra);
			//entrambe le gambe
		Shape gambe = Shape.union(gambaSinistra, gambaDestra);
		gambe.setFill(pelle);

		//INSERISCO IN GROUP
		root.getChildren().addAll(gambe, braccia, corpo, pancia);
		return root;
	}
	public Group draw(Group root) {
		root = this.drawBody(root);
		root = this.drawHead(root);
		return root;		
	}
}
