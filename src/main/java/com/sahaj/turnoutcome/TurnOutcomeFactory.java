package com.sahaj.turnoutcome;

public class TurnOutcomeFactory {
	public TurnOutcome getTurnOutcome(String turnType) {
		if (turnType == null) {
			return null;
		}
		if (turnType.equalsIgnoreCase("STRIKE")) {
			return new Strike();
		} else if (turnType.equalsIgnoreCase("MULTISTRIKE")) {
			return new MultiStrike();
		} else if (turnType.equalsIgnoreCase("REDSTRIKE")) {
			return new RedStrike();
		} else if (turnType.equalsIgnoreCase("STRIKERSTRIKE")) {
			return new StrikerStrike();
		} else if (turnType.equalsIgnoreCase("DEFUNCTSTRIKE")) {
			return new DefunctStrike();
		}
		return null;
	}
}