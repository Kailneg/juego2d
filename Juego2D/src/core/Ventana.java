package core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1789031712502011123L;
	
	private static final short ANCHO = 800;
	private static final short ALTO = 600;
	private static final String NOMBRE_VENTANA = "[Proyecto] Juego de Rol 2D";
	private static Juego canvas;

	public Ventana(Canvas canvas) {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		

		this.setTitle(NOMBRE_VENTANA);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static String getNombreVentana(){
		return NOMBRE_VENTANA;
	}
}
