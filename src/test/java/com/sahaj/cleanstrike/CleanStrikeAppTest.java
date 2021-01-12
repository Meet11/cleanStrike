package com.sahaj.cleanstrike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class CleanStrikeAppTest {
	
	@Test
	public void testGameDraw() {
		System.out.println("---------------Test Game Draw---------------------");
		System.out.println("Condition - No Coins left and minimum lead / \n"
				+ "minimum points win criteria not satisfied");
		System.out.println("--------------------------------------------------");
		File inputFile = new File("src/test/resources/input_game_draw.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
		assertTrue(cleanStrike.getGameResult().isGameDrawed());
		
	}
	
	@Test
	public void testGameDrawEqualPoints() {
		
		System.out.println("---------------Test Game Draw---------------------");
		System.out.println("Condition - Both players score same points");
		System.out.println("--------------------------------------------------");
			
		File inputFile = new File("src/test/resources/input_game_draw_equal_points.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
		
		int playerOnePoints = cleanStrike.getPlayerOneScores().getPlayerPoints();
		int playerTwoPoints = cleanStrike.getPlayerTwoScores().getPlayerPoints();
		
		assertTrue(cleanStrike.getGameResult().isGameDrawed());
		assertTrue(playerOnePoints == playerTwoPoints);
		
	}
	
	@Test
	public void testPlayerOneWinsMinimumFivePointsNoCoinsLeft() {
		
		System.out.println("---------------Player One Wins--------------------");
		System.out.println("Condition - Leading player has minimum points when \n "
				+ "no coins are left on board");
		System.out.println("--------------------------------------------------");
		
		String expectedValue = "Tom";
		
		File inputFile = new File("src/test/resources/input_player_one_wins.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
			
		String actualValue = cleanStrike.getGameResult().getWinner().getPlayerName();
		
		assertFalse(cleanStrike.getGameResult().isGameDrawed());
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	public void testPlayerOneWinsMinimumPointsAndLeadCondition() {
		
		System.out.println("---------------Player One Wins--------------------");
		System.out.println("Condition - Leading player has minimum points \n"
				+ "required and is leading by more than three points when \n"
				+ "coins are left on board");
		System.out.println("--------------------------------------------------");
		
		String expectedValue = "Tom";
		
		File inputFile = new File("src/test/resources/input_has_winner_general_case.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
		
		String actualValue = cleanStrike.getGameResult().getWinner().getPlayerName();
		
		assertFalse(cleanStrike.getGameResult().isGameDrawed());
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	public void testPlayerOneWinsByLeadingWhenNoCoinsLeft() {
		
		System.out.println("---------------Player One Wins--------------------");
		System.out.println("Condition - Leading player has minimum lead \n"
				+ "required when no coins are left on board");
		System.out.println("--------------------------------------------------");
		
		String expectedValue = "Tom";
		
		File inputFile = new File("src/test/resources/input_has_winner_no_coins_left.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
		
		String actualValue = cleanStrike.getGameResult().getWinner().getPlayerName();
		
		assertFalse(cleanStrike.getGameResult().isGameDrawed());
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	public void testPlayerLosesAdditionalPointOnThreeFouls() {
		
		System.out.println("------Player Loses Point on Three Fouls-----------");
		System.out.println("Condition - Player two loses additional point \n"
				+ "by commiting three fouls");
		System.out.println("--------------------------------------------------");
		
		String expectedValue = "Tom";
		int expectedPlayerScore = -1;
		int expectedPlayerFoulCount = 3;
		
		File inputFile = new File("src/test/resources/input_has_winner_no_coins_left.txt");
		Cleanstrike cleanStrike = new Cleanstrike(inputFile, "Tom", "Jerry");
		cleanStrike.startGame();
		
		String actualValue = cleanStrike.getGameResult().getWinner().getPlayerName();
		int actualPlayerScore = cleanStrike.getPlayerTwoScores().getPlayerPoints();
		int actualPlayerFoulCount = cleanStrike.getPlayerTwoScores().getPlayerFoulCount();
		
		assertFalse(cleanStrike.getGameResult().isGameDrawed());
		assertEquals(expectedPlayerScore, actualPlayerScore);
		assertEquals(expectedPlayerFoulCount, actualPlayerFoulCount);
		assertEquals(expectedValue, actualValue);
		
	}


}
