package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadTriatlo extends Thread{
	private int pTotal = 0;
	private int totalPontos = 0;
	private static int[] classificacao = new int[25];
	private Semaphore esperaTiro;
	private static int posicaoC = 0;
	private static int posicao = 0;
	//private static int verif;
	
	public ThreadTriatlo(Semaphore esperaTiro) {
		// TODO Auto-generated constructor stub
		this.esperaTiro = esperaTiro;
		
	}
	
	@Override
	public void run() {
		corrida();
		ciclismo();
	}
	
	public void corrida() {
		int distanciaTotal = 0;
		int distanciaPercorrida;
		Random rcorrida = new Random();
		int tcorrida = rcorrida.nextInt(1);
		while(distanciaTotal<3000) {
			if(tcorrida == 0) {
				distanciaPercorrida = 20;
			} else {
				distanciaPercorrida = 25;
			}
			
			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			distanciaTotal = distanciaTotal + distanciaPercorrida;
		}
		
		System.out.println("O atleta #"+getId()+"percorreu "+distanciaTotal+" metros.");
			posicaoC++;
			System.out.println("O atleta #"+getId()+" chegou em "+posicaoC+" lugar");
			try {
				esperaTiro.acquire();
				tiro();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				esperaTiro.release();
			}
		
	}
	
	public void tiro() {
		Random precisao = new Random();
		int tempoTiro;
		int pTiro;
				
		for (int i = 1; i <= 3; i++) {
			tempoTiro = precisao.nextInt(2500)+500;
			pTiro = precisao.nextInt(10);
			pTotal = pTotal + pTiro;
			try {
				sleep(tempoTiro);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("O atleta #"+getId()+" obteve "+pTotal+" pontos na prova de tiro.");
	}
	
	public void ciclismo() {
		Random rciclismo = new Random();
		int pontos = 250;
		int distanciaTotal = 0;
		int distanciaPercorrida;
		int tCiclismo = rciclismo.nextInt(1);
		
		while(distanciaTotal<5000) {
			if(tCiclismo == 0) {
				distanciaPercorrida = 30;
			}else {
				distanciaPercorrida = 40;
			}
			
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			distanciaTotal = distanciaTotal + distanciaPercorrida;
		}

			classificacao[posicao] = (int) getId();
			pontos = pontos - 10*posicao;
			posicao++;
			totalPontos = pontos + pTotal;
			//verif++;
			System.out.println("O atleta #"+getId()+" terminou o circuito em "+posicao+" lugar e ficou com um total de "+totalPontos+" pontos");
			//classificacao();
	}
	
	public void classificacao() {
		 
	}
}
