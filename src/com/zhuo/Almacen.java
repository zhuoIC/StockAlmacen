package com.zhuo;

public class Almacen {
	boolean error;
	private static final int MAXIMO = 20000;
	private int piezas;
	private int dia;
	public Almacen(int piezas) {
		this.error = false;
		this.piezas = piezas;
	}
	
	public synchronized void retirar(int piezas){
		if (!error){
			dia++;
			System.out.println();
			System.out.println("Día " + dia);
			System.out.println("Pedido de " + piezas + " piezas.");
			if (this.piezas < piezas) {
				error = true;
				System.out.println("¡No hay piezas suficientes!");
			}
			else{
				this.piezas -= piezas;
				System.out.println("Hay "+ this.piezas+ " piezas en al almacén.");
		
			}
		}
	}
	
	public synchronized void enviar(int piezas){
		if (!error){
			System.out.println("Llegan " + piezas + " piezas.");
			if ((this.piezas + piezas) > MAXIMO) {
				error = true;
				System.out.println("¡Hay demasiadas piezas!");
			}
			else{
				this.piezas += piezas;
				System.out.println("Hay " + this.piezas + " piezas en el almacén.");
			}
		}
	}
}
