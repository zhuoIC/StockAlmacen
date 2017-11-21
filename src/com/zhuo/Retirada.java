package com.zhuo;

import java.util.Random;

public class Retirada extends Thread{
	private int piezas;
	private Almacen almacen;
	private Random random;
	
	public Retirada(Almacen almacen) {
		this.almacen = almacen;
		random = new Random();
	}
	
	@Override
	public void run() {
		while (!almacen.error){
			try {
				Thread.sleep(2400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			piezas = 2000 + random.nextInt(501);
			almacen.enviar(piezas);
		}
	}
}
