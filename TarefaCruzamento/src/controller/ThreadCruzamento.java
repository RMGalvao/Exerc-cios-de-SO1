package controller;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class ThreadCruzamento extends Thread{
	private int idCarro;
	private Semaphore semaforo;
	private static int ordemSaida;
	
	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Ordem();
		try {
			semaforo.acquire();
			Saindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			Saida();
			semaforo.release();
		}
	}
	
	private void Ordem() {
		Random random = new Random();
		int sorte = random.nextInt(120);
		try {
			sleep(sorte);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Saindo() {
		Random random = new Random();
		int vm = random.nextInt(120);
		try {
			sleep(vm);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Saida() {
		ordemSaida++;
		System.out.println("O carro " + this.idCarro + " foi o " + ordemSaida + "o. a cruzar o cruzamento!");
	}
}
