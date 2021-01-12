package com.sahaj.turnoutcome;

import com.sahaj.cleanstrike.Coin;

public interface TurnOutcome {

	public int getNumberOfCoinsToRemove();

	public int getNumberOfPoints();

	public Coin getCoinType();

	public boolean isFoul();

}
