package com.avinash.learn;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class FootballTeam implements Comparable<FootballTeam> {

	private int gamesWon;

	@Override
	public int compareTo(final FootballTeam other) {
		return new CompareToBuilder().append(gamesWon, other.gamesWon).toComparison();
	}

	public FootballTeam(int gamesWon) {
		if (gamesWon < 0)
			throw (new IllegalArgumentException("Cannot have negative number of games won"));
		this.gamesWon = gamesWon;
	}

	public int getGamesWon() {
		return gamesWon;
	}

}
