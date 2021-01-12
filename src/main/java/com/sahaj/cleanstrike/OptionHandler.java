package com.sahaj.cleanstrike;

import com.sahaj.cleanstrike.exceptions.InvalidInputException;
import com.sahaj.turnoutcome.TurnOutcome;
import com.sahaj.turnoutcome.TurnOutcomeFactory;

public class OptionHandler {

	public TurnOutcome handleOption(Integer option, Board cleanStrikeBoard)
			throws InvalidInputException {
		TurnOutcomeFactory turnOutcomeFactory = new TurnOutcomeFactory();
		switch (option) {
		case 1:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome("STRIKE");
			}
			throw new InvalidInputException(
					"Invalid input, enter valid move. No black coins left on board");
		case 2:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome("MULTISTRIKE");
			}
			throw new InvalidInputException("Invalid input, enter valid move. "
					+ "At least two black coins must be left on board");

		case 3:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome("REDSTRIKE");
			}
			throw new InvalidInputException(
					"Invalid input, enter valid move. No red coin left on board");

		case 4:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome("STRIKERSTRIKE");
			}
			throw new InvalidInputException(
					"Invalid input, enter valid move. No coins left on board");

		case 5:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome("DEFUNCTSTRIKE");
			}
			throw new InvalidInputException(
					"Invalid input, enter valid move. No coins left on board");

		case 6:
			if (isValidInput(option, cleanStrikeBoard)) {
				return turnOutcomeFactory.getTurnOutcome(null);
			}
			throw new InvalidInputException(
					"Invalid input, enter valid move. No coins left on board");

		default:
			throw new InvalidInputException("Invalid input, enter valid move.");

		}

	}

	private static boolean isValidInput(Integer option, Board cleanStrikeBoard) {
		switch (option) {
		case 1:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.BLACK) > 0) {
				return true;
			} 
			return false;
			
		case 2:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.BLACK) > 1) {
				return true;
			} 
			return false;
			
		case 3:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.RED) > 0) {
				return true;
			} 
			return false;
			
		case 4:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.BLACK) > 0
					|| cleanStrikeBoard.getCleanStrikeCoins().get(Coin.RED) > 0) {
				return true;
			} 
			return false;
			
		case 5:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.BLACK) > 0) {
				return true;
			} 
			return false;
			
		case 6:
			if (cleanStrikeBoard.getCleanStrikeCoins().get(Coin.BLACK) > 0
					|| cleanStrikeBoard.getCleanStrikeCoins().get(Coin.RED) > 0) {
				return true;
			} 
			return false;
			

		}
		return false;
	}

}
