package com.avinash.learn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

	private static final int ANY_NUMBER = 123;

	@Test
	@Parameters({ "0", "3", "5" })
	public void constructorShouldSetGamesWon(int nbOfGamesWon) {
		FootballTeam team = new FootballTeam(nbOfGamesWon);
		assertEquals(nbOfGamesWon + " games passed to constructor, but " + team.getGamesWon() + " were returned",
				nbOfGamesWon, team.getGamesWon());
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters({ "-10", "-1" })
	public void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNbOfGames) {
		new FootballTeam(illegalNbOfGames);
	}

	@Test
	public void shouldBePossibleToCompareTeams() {
		FootballTeam team = new FootballTeam(ANY_NUMBER);
		assertTrue("FootballTeam should implement Comparable", team instanceof Comparable);
	}

	@Test
	public void teamsWithMoreMatchesWonShouldBeGreater() {
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		assertTrue(team_3.compareTo(team_2) > 0);
	}

	@Test
	public void teamsWithLessMatchesWonShouldBeLesser() {
		FootballTeam team_2 = new FootballTeam(2);
		FootballTeam team_3 = new FootballTeam(3);
		assertTrue("team with " + team_2.getGamesWon() + " games won should be ranked after the team with "
				+ team_3.getGamesWon() + " games won", team_2.compareTo(team_3) < 0);
	}

	@Test
	public void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
		FootballTeam teamA = new FootballTeam(2);
		FootballTeam teamB = new FootballTeam(2);
		assertTrue("both teams have won the same number of games: " + teamA.getGamesWon() + " vs. "
				+ teamB.getGamesWon() + " and should be ranked equal", teamA.compareTo(teamB) == 0);
	}

}
