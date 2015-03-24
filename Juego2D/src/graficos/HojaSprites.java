package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	
//Atributos
	private final int ANCHO;
	private final int ALTO;
	private final String RUTA;
	private BufferedImage imagen;
	public final int[] pixeles;
	
//Constructor			Se pone final por buena costumbre, así se le ayuda a JVM a interpretar el código
	
	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.ANCHO = ancho;
		this.ALTO = alto;
		this.RUTA = ruta;
		
		//El array tiene que tener el mismo tamaño que píxeles tenga el SpriteSheet
		pixeles = new int[ancho*alto];

		cargar();
	}
	
	private void cargar(){
		//Cargar el spritesheet como imagen y cargarlo en el array de int como píxeles individuales
		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(RUTA));
			imagen.getRGB(0, 0, ANCHO, ALTO, pixeles, 0, ANCHO);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//Getter
	public int getAncho(){
		return ANCHO;
	}
}
