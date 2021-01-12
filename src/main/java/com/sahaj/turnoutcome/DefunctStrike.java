package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public class DefunctStrike implements TurnOutcome {

	@Override
	public int getNumberOfPoints() {
		return -2;
	}

	@Override
	public int getNumberOfCoinsToRemove() {
		return 1;
	}

	@Override
	public boolean isFoul() {
		return true;
	}

	@Override
	public Coin getCoinType() {
		return Coin.BLACK;
	}

}
