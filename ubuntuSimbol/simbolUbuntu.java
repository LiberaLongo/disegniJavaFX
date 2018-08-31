package ubuntuSimbol;

import javafx.scene.Group;	//devo fare group e non shape perchè ci sono colori diversi
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class simbolUbuntu {
	private Double x;
	private Double y;
	private Double size;
	private Color colore1;
	private Color colore2;
	private Color colore3;
	private Boolean interno;

	simbolUbuntu(Double x, Double y, Double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.colore1 = Color.RED;
		this.colore2 = Color.ORANGE;
		this.colore3 = Color.YELLOW;
		this.interno = true;
	}
	simbolUbuntu(Double x, Double y, Double size, Color colore1, Color colore2, Color colore3) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.colore1 = colore1;
		this.colore2 = colore2;
		this.colore3 = colore3;
		this.interno = true;
	}
	simbolUbuntu(Double x, Double y, Double size, Color colore1, Color colore2, Color colore3, Boolean interno) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.colore1 = colore1;
		this.colore2 = colore2;
		this.colore3 = colore3;
		this.interno = interno;
	}

	public Group draw(Group root) {
		//Proporzioni
		Double proporzione = this.size/3;
		Double proporzioneSpazi = proporzione/4;
		//raggi
		Double raggioEsterno = this.size;
		Double raggioInterno = raggioEsterno - proporzione;
		Double raggioTeste = proporzione/2;	/* il simbolo di Ubuntu simboleggia fratellanza
							*  sono 3 persone di colori diversi che si danno la mano
							*  in modo molto schematico */
		Double raggioSpazio = raggioTeste + proporzioneSpazi;
		//
		Double distanza = this.size;
		//cerchi di preparazione
		//Nota: testa1 è a pigreco/3, testa2 a pigreco, testa3 a 5/3*pigreco
		//preparazione delle braccia
		Circle esterno = new Circle (x, y, raggioEsterno);
		Circle interno = new Circle (x, y, raggioInterno);
		Shape bracciaUnite = Shape.subtract (esterno, interno);		
		Circle spazioTesta1 = new Circle (x + distanza*Math.cos(Math.PI*1/3), y - distanza*Math.sin(Math.PI*1/3), raggioSpazio);
		bracciaUnite = Shape.subtract(bracciaUnite, spazioTesta1);
		Circle spazioTesta2 = new Circle (x + distanza*Math.cos(Math.PI*3/3), y - distanza*Math.sin(Math.PI*3/3), raggioSpazio);
		bracciaUnite = Shape.subtract(bracciaUnite, spazioTesta2);
		Circle spazioTesta3 = new Circle (x + distanza*Math.cos(Math.PI*5/3), y - distanza*Math.sin(Math.PI*5/3), raggioSpazio);
		bracciaUnite = Shape.subtract(bracciaUnite, spazioTesta3);
		//braccia
		//costructor detail of Arc (https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Arc.html)
		//public Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
		//braccio1
		Arc arc1 = new Arc(x + proporzioneSpazi*Math.cos(Math.PI*1/3), y - proporzioneSpazi*Math.sin(Math.PI*1/3), raggioEsterno, raggioEsterno, 0., 120.); 
		arc1.setType(ArcType.ROUND);
		Shape braccia1 = Shape.intersect(bracciaUnite, arc1);
		braccia1.setFill(this.colore2);
		//braccio2
		Arc arc2 = new Arc(x + proporzioneSpazi*Math.cos(Math.PI*3/3), y - proporzioneSpazi*Math.sin(Math.PI*3/3), raggioEsterno, raggioEsterno, 120., 120.); 
		arc2.setType(ArcType.ROUND);
		Shape braccia2 = Shape.intersect(bracciaUnite, arc2);
		braccia2.setFill(this.colore3);
		//braccio3
		Arc arc3 = new Arc(x + proporzioneSpazi*Math.cos(Math.PI*5/3), y - proporzioneSpazi*Math.sin(Math.PI*5/3), raggioEsterno, raggioEsterno, 240., 120.); 
		arc3.setType(ArcType.ROUND);
		Shape braccia3 = Shape.intersect(bracciaUnite, arc3);
		braccia3.setFill(this.colore1);
		//teste
		Circle testa1 = new Circle (x + distanza*Math.cos(Math.PI*1/3), y - distanza*Math.sin(Math.PI*1/3), raggioTeste);
		testa1.setFill(this.colore1);
		Circle testa2 = new Circle (x + distanza*Math.cos(Math.PI*3/3), y - distanza*Math.sin(Math.PI*3/3), raggioTeste);
		testa2.setFill(this.colore2);
		Circle testa3 = new Circle (x + distanza*Math.cos(Math.PI*5/3), y - distanza*Math.sin(Math.PI*5/3), raggioTeste);
		testa3.setFill(this.colore3);
		root.getChildren().addAll(braccia1, braccia2, braccia3, testa1, testa2, testa3);
		return root;
	}
}




