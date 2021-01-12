package com.sahaj.cleanstrike.exceptions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sahaj.cleanstrike.Board;
import com.sahaj.cleanstrike.Coin;
import com.sahaj.cleanstrike.OptionHandler;
import com.sahaj.turnoutcome.TurnOutcome;

public class InvalidInputExceptionTest {
	
	@Test
	public void testInvalidInputException() {
		
		boolean exceptionThrown = false;
		OptionHandler optionHandler = new OptionHandler();
		Board cleanStrikeBoard = new Board();
		cleanStrikeBoard.getCleanStrikeCoins().put(Coin.RED, 0);
		try {
			@SuppressWarnings("unused")
			TurnOutcome turnOutcome = optionHandler.handleOption(3, cleanStrikeBoard);
		} catch (InvalidInputException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
	
}
