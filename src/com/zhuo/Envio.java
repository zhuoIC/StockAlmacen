package com.zhuo;

import java.util.Random;

public class Envio extends Thread{
	private int piezas;
	private Almacen almacen;
	private Random random;
	
	public Envio(Almacen almacen) {
		this.almacen = almacen;
		random = new Random();
	}

	@Override
	public void run() {
		while(!almacen.error){
			piezas = 400 + random.nextInt(601);
			almacen.enviar(piezas);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
