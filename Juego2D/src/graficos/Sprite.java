package graficos;

import java.awt.image.BufferedImage;

public final class Sprite {
	
//Atributos
	private final int lado; //Tamaño de un lado del sprite. Normalmente es 32, 64...
	private final HojaSprites hoja;
	
	private int x, y;
	private BufferedImage imagen;
	
	public int pixeles[];
	
//Constructor
	public Sprite (final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		this.hoja = hoja;
		
		this.x = columna * lado;
		this.y = fila * lado;
		
		//El array tiene que tener el mismo tamaño que píxeles tenga el Sprite
		pixeles = new int[lado*lado];
		
		for (int y = 0; y < lado; y++){
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}
}
