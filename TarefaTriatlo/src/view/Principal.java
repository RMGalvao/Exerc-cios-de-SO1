package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTriatlo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore esperaTiro = new Semaphore(5);
		
		for(int i = 0; i < 25; i++) {
			ThreadTriatlo triatlo = new ThreadTriatlo(esperaTiro);
			triatlo.start();
		}
		

	}

}
