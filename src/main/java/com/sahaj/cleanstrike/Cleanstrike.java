package com.sahaj.cleanstrike;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sahaj.cleanstrike.exceptions.InvalidInputException;
import com.sahaj.resultservice.ResultServiceGetResult;
import com.sahaj.turnoutcome.TurnOutcome;

public class Cleanstrike {

	private static String playerId = "1";
	private static boolean playerOneTurn = true;
	private static final OptionHandler optionHandler = new OptionHandler();

	private File inputFile = null;
	private BufferedReader br;
	private GameResult gameResult;
	private Player playerOne;
	private Player playerTwo;
	private Scores playerOneScores;
	private Scores playerTwoScores;
	private Board cleanStrikeBoard;
	private ResultServiceGetResult resultService;

	public Cleanstrike(File inputFile, String playerOneName, String playerTwoName) {

		this.inputFile = inputFile;

		try {
			this.br = new BufferedReader(new FileReader(this.inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		initializeGameProperties(playerOneName, playerTwoName);

	}

	private void initializeGameProperties(String playerOneName, String playerTwoName) {
		this.gameResult = new GameResult();
		this.playerOne = new Player(playerOneName, getPlayerId());
		this.playerTwo = new Player(playerTwoName, getPlayerId());
		this.playerOneScores = new Scores(playerOne);
		this.playerTwoScores = new Scores(playerTwo);
		this.cleanStrikeBoard = new Board();
		this.resultService = new ResultServiceGetResult();
	}

	public void startGame() {

		playerOneTurn = true;
		do {
			displayPlayerStats(playerOneScores, playerTwoScores);
			if (playerOneTurn) {
				playerExecuteMove(cleanStrikeBoard, playerOne, playerOneScores);
			} else {
				playerExecuteMove(cleanStrikeBoard, playerTwo, playerTwoScores);
			}
			resultService.setWinner(playerOneScores, playerTwoScores, cleanStrikeBoard);
		} while (!cleanStrikeBoard.isGameOver(resultService));

		getAndDisplayResult(playerOneScores, playerTwoScores, resultService);

	}
	
	//Move to result Service
	private void getAndDisplayResult(Scores playerOneScores, Scores playerTwoScores,
			ResultServiceGetResult resultService) {

		Player winner = resultService.getCleanStrikeWinner();

		if (winner != null) {
			gameResult.setWinner(winner);
			System.out.println("Winner is: " + winner.getPlayerName());
			System.out.println("Final score is: ");
			displayPlayerStats(playerOneScores, playerTwoScores);
			return;
		}

		gameResult.setGameDrawed(true);
		System.out.println("Game Draw!");
		System.out.println("Final score is: ");
		displayPlayerStats(playerOneScores, playerTwoScores);
		return;

	}

	private void playerExecuteMove(Board cleanStrikeBoard, Player player, Scores score) {

		displayPlayerOptions(player, cleanStrikeBoard);
		try {
			playerTurn(cleanStrikeBoard, player, score);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			togglePlayerOneTurn();
		}
		togglePlayerOneTurn();

	}

	private void playerTurn(Board cleanStrikeBoard, Player player, Scores score)
			throws IOException, InvalidInputException {

		Integer option = Integer.parseInt(br.readLine());
		TurnOutcome turnOutcome = optionHandler.handleOption(option, cleanStrikeBoard);
		if (turnOutcome == null) {
			trackTurnsNoPointsScored(score);
			return;
		}
		// updatePlayerScores
		udpatePlayerScores(turnOutcome, player, score);
		updateCleanStrikeBoard(turnOutcome, cleanStrikeBoard, player, score);

	}

	private void trackTurnsNoPointsScored(Scores score) {

		score.updateNoCoinPocketedSuccessiveTurn();
		int noPointsPocketedSuccessiveTurns = score.getNoCoinPocketedSuccessiveTurn();
		if (noPointsPocketedSuccessiveTurns == 3) {
			score.resetNoCoinPocketedSuccessiveTurn();
			score.updatePlayerPoints(-1);
		}
	}

	// updated function
	private void udpatePlayerScores(TurnOutcome turnOutcome, Player player, Scores score) {
		score.updatePlayerPoints(turnOutcome.getNumberOfPoints());
	}

	private void updateCleanStrikeBoard(TurnOutcome turnOutcome, Board cleanStrikeBoard,
			Player player, Scores score) {

		if (turnOutcome.isFoul()) {
			trackPlayerFouls(score);
		}
		if (turnOutcome.getCoinType() == Coin.RED) {
			cleanStrikeBoard.getCleanStrikeCoins().put(Coin.RED, 0);
		}
		Integer numberOfCoinsRemainingOnBoard = cleanStrikeBoard.getCleanStrikeCoins()
				.get(Coin.BLACK) - turnOutcome.getNumberOfCoinsToRemove();
		cleanStrikeBoard.getCleanStrikeCoins().put(Coin.BLACK, numberOfCoinsRemainingOnBoard);

	}

	private void trackPlayerFouls(Scores score) {

		score.incrementPlayerFoulCount();
		if (score.getPlayerFoulCount() % 3 == 0) {
			score.updatePlayerPoints(-1);
		}

	}

	private void displayPlayerStats(Scores playerOneScores, Scores playerTwoScores) {

		System.out.println("---------------Game Score Board---------------");
		System.out.println(playerOneScores);
		System.out.println(playerTwoScores);
		System.out.println("----------------------------------------------");

	}

	private void displayPlayerOptions(Player player, Board board) {

		System.out.println("Number of coins on board: ");
		System.out.println("Black Coins: " + board.getCleanStrikeCoins().get(Coin.BLACK));
		System.out.println("Red Coins: " + board.getCleanStrikeCoins().get(Coin.RED));
		System.out.println(player.getPlayerName() + " : Choose an outcome from the list below");
		System.out.println("1. Strike");
		System.out.println("2. Multistrike");
		System.out.println("3. Red strike");
		System.out.println("4. Striker strike");
		System.out.println("5. Defunct coin");
		System.out.println("6. None");

	}

	private String getPlayerId() {

		String playerId = Cleanstrike.playerId;
		Integer newPlayerId = Integer.parseInt(playerId) + 1;
		Cleanstrike.playerId = newPlayerId.toString();
		return playerId;

	}

	private void togglePlayerOneTurn() {

		playerOneTurn = !playerOneTurn;

	}

	public GameResult getGameResult() {

		return gameResult;

	}

	public Scores getPlayerOneScores() {

		return playerOneScores;

	}

	public Scores getPlayerTwoScores() {

		return playerTwoScores;

	}

}