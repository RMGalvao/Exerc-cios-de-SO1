package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int idCarro = 1; idCarro <= 4; idCarro++ ) {
			Thread carros = new ThreadCruzamento(idCarro, semaforo);
			carros.start();
		}

	}

}
