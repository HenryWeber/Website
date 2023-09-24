package edu.wsu.se;

import java.util.ArrayList;
import java.util.Random;

import edu.wsu.se.Match.Player;

public class Game {

	boolean gameEnd = false;
	int gameNumber = 0;
	int whoseTurn = 1;
	int whomWon = -1;
	boolean[][] playerMatrix = new boolean[4][4];
	Player[] players = null;
	Match match = null;

	int totalGames = 4;

/////////////////////////////////////////////////////////////////(A.2)Game Constructor
	public Game(Player[] players, int totalGames, Match m) {
		this.players = players;
		this.match = m;
		this.totalGames = totalGames;
	}

	public void resetGame() {
		//used to reset variables so a new game can be played
		Random rand = new Random();
		gameEnd = false; //the game is not over
		whoseTurn = 1 + rand.nextInt(4); //random starting turn
		whomWon = -1; //nobody won yet
		for (int i = 0; i < 4; i++) { //empty everyone's hand
			players[i].resetHand();
		}
	}

///////////////////////////////////////////////////(B)Matrix Display
	public String displayMatrix() {
		//print the matrix to the console
		String matrix = "P1: [";
		for (int i = 0; i < 4; i++) {
			matrix += playerMatrix[0][i] + " ";
		}
		matrix += "]\n";
		matrix += "P2: [";
		for (int i = 0; i < 4; i++) {
			matrix += playerMatrix[1][i] + " ";
		}
		matrix += "]\n";
		matrix += "P3: [";
		for (int i = 0; i < 4; i++) {
			matrix += playerMatrix[2][i] + " ";
		}
		matrix += "]\n";
		matrix += "P4: [";
		for (int i = 0; i < 4; i++) {
			matrix += playerMatrix[3][i] + " ";
		}
		matrix += "]\n";
		return matrix;
	}

	public void calculateScores() {
		boolean win = false;
		//calculate scores based on whether this person won or not
		for (int i = 0; i < 4; i++) {
			if (i + 1 == getWhomWon())
				win = true;
			else
				win = false;
			players[i].calculateScore(win);
		}

	}

	public void start() {
		//start the game
		while (gameNumber++ < totalGames) { //do the full amounmt of games in a match
			resetGame(); //reset variables
			generateHands(); //randomly create starting hands
			while (!gameEnd) { //loop through turns until someone wins
				// do a turn
				match.gui.dropDown.setEnabled(false);
				if(gameNumber != 1) {
					try {
						Thread.sleep(3000); //wait for clients to acknowledge the winner
					} catch (InterruptedException e) {
						match.gui.PROMPT_MESSAGE("Something Went Wrong! Game Closing!");
						System.exit(0);
					}
				}
				if (match.netHandler.isServer()) {
					match.netHandler.broadcast("" + whoseTurn); //tell everyone whos turn it is
					for (int i = 0; i < 3; i++) {
						match.netHandler.readFromClient(i); //read an acknowledgment
					}
				} else {
					// client

					System.out.println("starting-client");
					
					whoseTurn = Integer.parseInt(match.netHandler.readFromServer()); //get whos turn from server
					match.netHandler.sendToServer("howdy!"); //send acknowledgment
				}

				match.gui.updateDisplay(); //update gui based on turn, hand, matrix, etc.

				if (whoseTurn == match.netHandler.getMyNumber()) { //my turn
					while (whoseTurn == match.netHandler.getMyNumber()) {
						try {
							Thread.sleep(10); //wait for them to pick a number
						} catch (InterruptedException e) {
							match.gui.PROMPT_MESSAGE("Something Went Wrong! Game Closing!");
							System.exit(0);
						}
					}
				} else {
					// someone else's turn
					if (match.netHandler.isServer()) { //server waits for number and broadcasts it to everyone else
						System.out.println("Server Waiting For Client Choice");
						int num = Integer.parseInt(match.netHandler.readFromClient(whoseTurn - 2));
						match.netHandler.broadcastException(num + "", whoseTurn);
						newTurn(whoseTurn, num); // process their selection
					} else { //wiat for the server to tell you what they chose
						System.out.println("Client Waiting For Server To Forward Other Client Choice");
						int num = Integer.parseInt(match.netHandler.readFromServer());
						newTurn(whoseTurn, num); //process their selection
					}
				}
			}
			//game is over
			calculateScores(); // calculate scores based on winner
			match.gui.updateDisplay(); //update gui to show them

			match.gui.PROMPT_MESSAGE("Player " + whomWon + " won the game!"); //tell them who won
			match.gui.TITLE_MESSAGE("Waiting For Server..."); //wait until the next games starts

		}
		//match is over
		match.gui.TITLE_MESSAGE("Match Finished!");
		ArrayList<Integer> winners = match.getWinner(gameEnd); //have list of winners in case of tie
		String s = "Player(s) " + winners.get(0);
		for (int i = 1; i < winners.size(); i++) {
			s += ", " + winners.get(i);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.exit(0);
		}
		match.gui.PROMPT_MESSAGE(s + " won the match! Woo Hoo!"); //prompt winner(s)
		System.exit(0);
	}

	public void updateMatrix() {

		for (int i = 0; i < 4; i++) {
			// for each player
			for (int j = 0; j < 4; j++) {
				// loop through each of the players and compare hands
				if (players[i].getHand().containsAll(players[j].getHand())) {
					// player i has everything player j has
					playerMatrix[i][j] = true;
				} else {
					playerMatrix[i][j] = false;
				}
			}
		}
	}

	public void generateHands() {
		// generate player hands
		NetworkHandler handler = match.netHandler;
		if (handler.isServer()) {
			Random rand = new Random();
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 3; y++) {
					int i = rand.nextInt(20) + 1;
					if (players[x].getHand().contains(i)) { //no repeated numbers at start
						y--;
					} else {
						
						newTurn(x + 1, i);
						handler.broadcast(i + "");
					}
				}
			}
		} else {
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 3; y++) {
					int i = Integer.parseInt(handler.readFromServer());
					newTurn(x + 1, i);
				}
			}
		}
		updateMatrix();
		checkWin(); //see if anyone is winning yet
	}

////////////////////////////////////////////////////////////////(D)New Turn
	public void newTurn(int playerNum, int wanted) {

		players[playerNum - 1].addNumber(wanted); //add their number to hand
		updateMatrix(); //check win conditions
		checkWin(); //check for a win
		whoseTurn++; //next players turn
		if (whoseTurn > 4) {
			whoseTurn = 1;
		}

	}

///////////////////////////////////////////////////(E)Check If Wins
	public void checkWin() {
		
		boolean alreadyWon = false;

		gameEnd = false;
		//check for all green row, while preparing for tie breakers (whoever played last)
		for (int i = 0; i < 4; i++) {
			int playersBeat = 0;
			for (int j = 0; j < 4; j++) {
				if (playerMatrix[i][j]) {
					playersBeat++;
				}
			}
			if (playersBeat >= 4) {
				// this player won
				alreadyWon = true;
				whomWon = i + 1;
				gameEnd = true;
				players[i].addWin();
			}
		}
		
		if(alreadyWon) { //tie breaker
			whomWon = whoseTurn;
		}
	}

/////////////////////////////////////////////////////(H)Getters and Setters
/////////////////////////////////////////////////////Turn Number
	public int getTurnNumber() {
		return gameNumber;
	}

	public void setTurnNumber(int turnNumber) {
		this.gameNumber = turnNumber;
	}

/////////////////////////////////////////////////////Whose Turn
	public int getWhoseTurn() {
		return whoseTurn;
	}

	public void setWhoseTurn(int whoseTurn) {
		this.whoseTurn = whoseTurn;
	}

/////////////////////////////////////////////////////Game End
	public boolean isGameEnd() {
		return gameEnd;
	}

	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

/////////////////////////////////////////////////////Who Won
	public int getWhomWon() {
		return whomWon;
	}

	public void setWhomWon(int whomWon) {
		this.whomWon = whomWon;
	}

/////////////////////////////////////////////////////Matrix
	public boolean[][] getPlayerMatrix() {
		return playerMatrix;
	}

	public void setPlayerMatrix(boolean[][] playerMatrix) {
		this.playerMatrix = playerMatrix;
	}
}
