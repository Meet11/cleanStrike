package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public class StrikerStrike implements TurnOutcome {

	@Override
	public int getNumberOfPoints() {
		return -1;
	}

	@Override
	public int getNumberOfCoinsToRemove() {
		return 0;
	}

	@Override
	public Coin getCoinType() {
		return Coin.STRIKER;
	}

	@Override
	public boolean isFoul() {
		return true;
	}

}
