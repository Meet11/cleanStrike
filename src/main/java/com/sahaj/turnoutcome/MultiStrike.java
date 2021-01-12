package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public class MultiStrike implements TurnOutcome {

	@Override
	public int getNumberOfPoints() {
		return 2;
	}

	@Override
	public int getNumberOfCoinsToRemove() {
		return 2;
	}

	@Override
	public boolean isFoul() {
		return false;
	}

	@Override
	public Coin getCoinType() {
		return Coin.BLACK;
	}

}
