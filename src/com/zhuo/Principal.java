package com.zhuo;

public class Principal {

	public static void main(String[] args) {
		int piezas = 8000;
		Almacen almacen = new Almacen(piezas);
		Retirada retirada = new Retirada(almacen);
		Envio envio = new Envio(almacen);
		
		retirada.start();
		envio.start();
		try {
			retirada.join();
			envio.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
