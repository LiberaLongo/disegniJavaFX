package mixati;

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

	public MCskin(Double centerX, Double centerY, Double size, Color[] colori, Integer[][] matrix) {
		super();
		this.x = centerX - size*4;
		this.y = centerY - size*4;
		this.size = size;
		this.colori = colori;
		this.matrix = matrix;
		//nessuna rotazione effettiva (ruota di 0 gradi)
		this.rotate = new Rotate();
		this.rotate.setPivotX(centerX);
		this.rotate.setPivotY(centerY);
	}

        public MCskin(Double centerX, Double centerY, Double size, Color[] colori, Integer[][] matrix, Double angle) {
                super();
		this.x = centerX - size*4;
		this.y = centerY - size*4;
                this.size = size;
                this.colori = colori;
                this.matrix = matrix;
		//rotazione dall'angolo inserito
                this.rotate = new Rotate(angle);
		//il cui centro di rotazione è al centro della skin
		this.rotate.setPivotX(centerX);
		this.rotate.setPivotY(centerY);
        }

	public MCskin(Double centerX, Double centerY, Double size, Color[] colori, Integer[][] matrix, Rotate rotate) {
                super();
		this.x = centerX - size*4;
		this.y = centerY - size*4;
                this.size = size;
                this.colori = colori;
                this.matrix = matrix;
		//per fare altre rotazioni precedentemente settate
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

