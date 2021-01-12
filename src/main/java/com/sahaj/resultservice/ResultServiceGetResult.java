package com.sahaj.resultservice;

import com.sahaj.cleanstrike.Board;
import com.sahaj.cleanstrike.Player;
import com.sahaj.cleanstrike.Scores;

public class ResultServiceGetResult extends ResultService {

	private Player cleanStrikeWinner;

	@Override
	public void setWinner(Scores playerOne, Scores playerTwo, Board cleanStrikeBoard) {

		int playerOnePoints = playerOne.getPlayerPoints();
		int playerTwoPoints = playerTwo.getPlayerPoints();
		int pointDifference = getPointDifference(playerOnePoints, playerTwoPoints);
		if (cleanStrikeBoard.isGameOver()) {
			if (!isGameDraw(playerOnePoints, playerTwoPoints, pointDifference)) {
				setHighestScorerAsWinnerEmptyBoard(playerOne, playerTwo, playerOnePoints,
						playerTwoPoints);
			}
			return;

		}
		setHighestScorerAsWinner(playerOne, playerTwo, playerOnePoints, playerTwoPoints,
				pointDifference);

	}

	private void setHighestScorerAsWinnerEmptyBoard(Scores playerOne, Scores playerTwo,
			int playerOnePoints, int playerTwoPoints) {
		if (isPlayerOneHighestScorer(playerOnePoints, playerTwoPoints)) {
			setCleanStrikeWinner(playerOne.getPlayer());
			return;
		}
		setCleanStrikeWinner(playerTwo.getPlayer());

	}

	private void setHighestScorerAsWinner(Scores playerOne, Scores playerTwo, int playerOnePoints,
			int playerTwoPoints, int pointDifference) {
		if (isPlayerOneHighestScorer(playerOnePoints, playerTwoPoints)) {
			updateCleanStrikeWinner(playerOne, playerOnePoints, pointDifference);
			return;
		}
		updateCleanStrikeWinner(playerTwo, playerTwoPoints, pointDifference);
	}

	private void updateCleanStrikeWinner(Scores player, int playerPoints, int pointDifference) {
		if (playerPoints >= MINIMUM_POINTS_NO_DRAW && pointDifference >= MINIMUM_LEAD_TO_WIN)
			setCleanStrikeWinner(player.getPlayer());
	}

	@Override
	public boolean isGameDraw(int playerOnePoints, int playerTwoPoints, int pointDifference) {
		if (playerOnePoints == playerTwoPoints)
			return true;
		int highestScore = getHighestScore(playerOnePoints, playerTwoPoints);
		if (gameDrawCondition(highestScore, pointDifference))
			return true;
		return false;
	}

	private boolean gameDrawCondition(int playerPoints, int pointDifference) {
		return playerPoints < MINIMUM_POINTS_NO_DRAW && pointDifference < MINIMUM_LEAD_TO_WIN;
	}

	public static int getPointDifference(int playerOnePoints, int playerTwoPoints) {
		int pointDifference = Math.abs(playerOnePoints - playerTwoPoints);
		return pointDifference;
	}

	private int getHighestScore(int playerOnePoints, int playerTwoPoints) {
		if (playerOnePoints > playerTwoPoints)
			return playerOnePoints;

		return playerTwoPoints;
	}

	public static boolean isPlayerOneHighestScorer(int playerOnePoints, int playerTwoPoints) {
		if (playerOnePoints > playerTwoPoints)
			return true;

		return false;
	}

	public Player getCleanStrikeWinner() {
		return cleanStrikeWinner;
	}

	protected void setCleanStrikeWinner(Player cleanStrikeWinner) {
		this.cleanStrikeWinner = cleanStrikeWinner;
	}

}
