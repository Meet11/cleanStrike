package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public class RedStrike implements TurnOutcome {

	@Override
	public int getNumberOfPoints() {
		return 3;
	}

	@Override
	public int getNumberOfCoinsToRemove() {
		return 0;
	}

	@Override
	public boolean isFoul() {
		return false;
	}

	@Override
	public Coin getCoinType() {
		return Coin.RED;
	}

}
