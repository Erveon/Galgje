package net.ultradev.galgje.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	String solution;
	int triesLeft;
	//We gebruiken hier geen char omdat het moeilijker is om case insensitive te werken dan (moet toch een string worden)
	List<String> guesses;
	
	boolean running;
	
	public Game(String solution) {
		this.solution = solution;
		this.triesLeft = 6; //Is dit de standaard? Dunno
		this.guesses = new ArrayList<>();
		this.running = true;
	}
	
	public String getWordsDisplay() {
		StringBuffer sb = new StringBuffer();
		for(Character letter : solution.toCharArray()) {
			if(guesses.contains(letter.toString().toLowerCase()) || letter == ' ')
				sb.append(letter);
			else
				sb.append('_');
		}
		return sb.toString();
	}
	
	public boolean foundSolution() {
		for(Character letter : solution.toCharArray()) {
			if(!guesses.contains(letter.toString().toLowerCase()))
				return false;
		}
		return true;
	}
	
	public void makeGuess(Character guess) {
		makeGuess(guess.toString());
	}
	
	public void makeGuess(String guess) {
		if(!running || guess.length() != 1 || !Character.isLetter(guess.charAt(0)))
			return;
		//We gebruiken lowercase zodat we het als lowercase kunnen vergelijken met de oplossing
		guesses.add(guess.toLowerCase());
		if(foundSolution())
			win();
		else if(--triesLeft <= 0)
			lose();
	}
	
	public boolean solutionContains(char letter) {
		return solution.contains(String.valueOf(letter));
	}
	
	public void lose() {
		this.running = false;
		System.out.println("Ouch! You got freaking lynched, bruh.");
		System.out.println("The solution was '" + solution + "'");
	}
	
	public void win() {
		this.running = false;
		System.out.println("Ayy mate you got it!!");
		System.out.println("The solution was '" + solution + "'");
	}
	
}
