package ksisters
;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class MCskin {
	private Double x;
	private Double y;
	private Double size;
	private Color colori[];
	private Integer matrix[][];
	private Rotate rotate;

	public MCskin(Double x, Double y, Double size, Color[] colori, Integer[][] matrix) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.colori = colori;
		this.matrix = matrix;
		this.rotate = new Rotate();
	}

        public MCskin(Double x, Double y, Double size, Color[] colori, Integer[][] matrix, Double angle) {
                super();
                this.x = x;
                this.y = y;
                this.size = size;
                this.colori = colori;
                this.matrix = matrix;
                this.rotate = new Rotate(angle);
		this.rotate.setPivotX(x + size*4);
		this.rotate.setPivotY(y + size*4);
        }

	public MCskin(Double x, Double y, Double size, Color[] colori, Integer[][] matrix, Rotate rotate) {
                super();
                this.x = x;
                this.y = y;
                this.size = size;
                this.colori = colori;
                this.matrix = matrix;
                this.rotate = rotate;
	}

	public Group draw(Group root) {
		for(int j=0 ; j < 8 ; j++) {
                        for(int i=0; i < 8; i++) {
				//creo un pixel calcolando la sua posizione
                                Rectangle pixel = new Rectangle(this.x + j * this.size, this.y + i*this.size, this.size, this.size);
                                //coloro il pixel tramite l'indice della matrice che mi indica la posizione del colore
				pixel.setFill(this.colori[this.matrix[i][j]]);
                                //il comando sotto fa eventuali rotazioni
				pixel.getTransforms().addAll(this.rotate);
				//aggiungo il pixel al resto del Group
				root.getChildren().add(pixel);
                        }
                }
                return root;
	}
}

