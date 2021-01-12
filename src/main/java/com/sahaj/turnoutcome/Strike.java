package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public class Strike implements TurnOutcome {

	@Override
	public int getNumberOfPoints() {
		return 1;
	}

	@Override
	public int getNumberOfCoinsToRemove() {
		return 1;
	}

	@Override
	public Coin getCoinType() {
		return Coin.BLACK;
	}

	@Override
	public boolean isFoul() {
		return false;
	}

}
