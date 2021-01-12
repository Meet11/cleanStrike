package com.sahaj.resultservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sahaj.cleanstrike.Board;
import com.sahaj.cleanstrike.Player;
import com.sahaj.cleanstrike.Scores;

public class ResultServiceTest {

	@Test
	public void testMatchDraw() { 
		ResultServiceGetResult resultService;
		resultService = new ResultServiceGetResult();
		Player playerOne = new Player("Meet", "97");
		Player playerTwo = new Player("Rigved", "99");
		Scores playerOneScores = new Scores(playerOne);
		Scores playerTwoScores = new Scores(playerTwo);
		playerOneScores.updatePlayerPoints(2);
		playerTwoScores.updatePlayerPoints(2);
		int playerOnePoints = playerOneScores.getPlayerPoints();
		int playerTwoPoints = playerTwoScores.getPlayerPoints();
		int pointDifference = getPointDifference(playerOnePoints, playerTwoPoints);
		assertTrue(resultService.isGameDraw(playerOnePoints, playerTwoPoints,
				pointDifference));
	}
	
	@Test
	public void testNoCoinsLeftWinner() { 
		ResultServiceGetResult resultService;
		resultService = new ResultServiceGetResult();
		Board board = new Board();
		Player playerOne = new Player("Meet", "97");
		Player playerTwo = new Player("Rigved", "99");
		Scores playerOneScores = new Scores(playerOne);
		Scores playerTwoScores = new Scores(playerTwo);
		playerOneScores.updatePlayerPoints(4);
		playerTwoScores.updatePlayerPoints(9);
		int playerOnePoints = playerOneScores.getPlayerPoints();
		int playerTwoPoints = playerTwoScores.getPlayerPoints();
		int pointDifference = getPointDifference(playerOnePoints, playerTwoPoints);
		resultService.setWinner(playerOneScores, playerTwoScores, board);
		assertFalse(resultService.isGameDraw(playerOnePoints, playerTwoPoints,
				pointDifference));
		Player winner = resultService.getCleanStrikeWinner();
		assertEquals(winner, playerTwo);
	}
	
	
	public static int getPointDifference(int playerOnePoints, int playerTwoPoints) {
		int pointDifference = Math.abs(playerOnePoints - playerTwoPoints);
		return pointDifference;
	}
}
