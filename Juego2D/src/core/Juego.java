package core;

import java.awt.Canvas;

import control.Teclado;

public class Juego extends Canvas implements Runnable {

//Atributos
	private static final long serialVersionUID = -1308273005477917009L;
	private static volatile boolean enFuncionamiento = false;

	private static Ventana ventana;
	private static Thread thread;
	private static Teclado teclado;

	private static int aps = 0;
	private static int fps = 0;

//Constructor
	private Juego() {
		ventana = new Ventana(this);
		teclado = new Teclado();
		addKeyListener(teclado);
		requestFocus();
	}

	private void actualizar() {
		teclado.actualizar();
		accionTeclado();
		aps++;
	}

	private void accionTeclado() {
		if (teclado.arriba) 
			System.out.println("Arriba");
		if (teclado.abajo) 
			System.out.println("Abajo");
		if (teclado.izquierda) 
			System.out.println("Izquierda");
		if (teclado.derecha) 
			System.out.println("Derecha");
	}

	private void mostrar() {
		fps++;
	}

	private synchronized void iniciar() {
		enFuncionamiento = true;

		thread = new Thread(this, "Thread Gráficos");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// Anotaciones
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 30;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}
			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				ventana.setTitle(Ventana.getNombreVentana() + " -||- APS: " + aps + " || FPS: " + fps);
				
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
	
//Main
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();
	}
}
