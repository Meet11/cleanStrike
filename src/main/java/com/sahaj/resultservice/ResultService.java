package com.sahaj.resultservice;

import com.sahaj.cleanstrike.Board;
//import com.sahaj.cleanstrike.Player;
import com.sahaj.cleanstrike.Scores;

public abstract class ResultService {

	final int MINIMUM_POINTS_NO_DRAW = 5;
	final int MINIMUM_LEAD_TO_WIN = 3;

//	private Player cleanStrikeWinner;
//
//	public Player getCleanStrikeWinner() {
//		return cleanStrikeWinner;
//	}
//
//	protected void setCleanStrikeWinner(Player cleanStrikeWinner) {
//		this.cleanStrikeWinner = cleanStrikeWinner;
//	}

	abstract boolean isGameDraw(int playerOneScores, int playerTwoScores, int pointDifference);

	abstract void setWinner(Scores playerOneScores, Scores playerTwoScores, Board cleanStrikeBoard);
}
