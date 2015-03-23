package graficos;

public class HojaSprites {
	
	private final int lado;
	private final int[] pixeles;
	
	//Se pone final por buena costumbre, así se le ayuda a JVM a interpretar el código
	public HojaSprites(final String ruta, final int lado) {
		this.lado = lado;
		
		//El array tiene que tener el mismo tamaño que píxeles tenga el SpriteSheet
		pixeles = new int[lado*lado];
	}
}
