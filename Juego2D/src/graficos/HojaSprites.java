package graficos;

public class HojaSprites {
	
	private final int lado;
	private final int[] pixeles;
	
	//Se pone final por buena costumbre, as� se le ayuda a JVM a interpretar el c�digo
	public HojaSprites(final String ruta, final int lado) {
		this.lado = lado;
		
		//El array tiene que tener el mismo tama�o que p�xeles tenga el SpriteSheet
		pixeles = new int[lado*lado];
	}
}
