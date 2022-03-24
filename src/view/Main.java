package view;
import java.util.concurrent.Semaphore;

import controller.Correr;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforoCorrer = new Semaphore(1);
		
		for(int i=0; i < 4; i++)
			new Correr(semaforoCorrer).start();
	}
}