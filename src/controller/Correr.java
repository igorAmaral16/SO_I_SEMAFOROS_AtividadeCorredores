package controller;

import java.util.concurrent.Semaphore;

public class Correr extends Thread {
	private int velo;
	private int distanciaPerco;
	private int tamanhoCo = 20;
	private int tempoCruza;
		
	private Semaphore semaforo_corredor;
	
	public Correr(Semaphore semaforoCorrer) {
		semaforo_corredor = semaforoCorrer;
		velo = (int) ((Math.random() * 3) + 4);
		tempoCruza = (int) ((Math.random() * 1001) + 1000);
	}

	public void run() {
		andar();
		
		try {
			semaforo_corredor.acquire();
			atravessarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo_corredor.release();
		}
		
	}
	
	private void andar() {
		System.out.println("#"+getId() + " andando...");
		while(distanciaPerco < tamanhoCo) {
			try {
				distanciaPerco = distanciaPerco + velo;
				System.out.println("#"+getId()+" percorreu: " + distanciaPerco + " metros");
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void atravessarPorta() {
		System.out.println("#"+getId() + " Atravessando...");
		
		try {
			sleep(tempoCruza);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#"+getId() + " saiu.");
	}
}