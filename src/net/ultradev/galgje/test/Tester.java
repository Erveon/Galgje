package net.ultradev.galgje.test;

import net.ultradev.galgje.game.Game;

public class Tester {

	public void test() {
		testWin();
		testLose();
	}
	
	public void testWin() {
		Game g1 = new Game("Puppy");
		g1.makeGuess("p"); //Moet uppercase en lowercase p vinden
		g1.makeGuess("U"); //Moet de lowercase u vinden
		for(int i = 0; i < 10; i++) //Zal geen beurten aftrekken omdat de input invalid is
			g1.makeGuess("invalide string voor veel beurten");
		g1.makeGuess('y'); //Zal de y raden met character als input
		if(!g1.foundSolution())
			System.out.println("ERROR -> Test failed: Puppy was not found. (" + g1.getWordsDisplay() + ")");
	}
	
	public void testLose() {
		Game g1 = new Game("Puppy");
		g1.makeGuess("p"); //Moet uppercase en lowercase p vinden
		g1.makeGuess("U"); //Moet de lowercase u vinden
		for(int i = 0; i < 10; i++) //Zal beurten aftrekken, meer dan mogelijke beurten proberen
			g1.makeGuess("x");
		g1.makeGuess('y'); //Zal de y niet meer raden omdat de beurten op zijn
		if(g1.foundSolution())
			System.out.println("ERROR -> Test failed: Puppy was found when it shouldn't. (" + g1.getWordsDisplay() + ")");
	}
	
}
