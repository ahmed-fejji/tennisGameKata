
package com.example.tennis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {



    @Test
    void shouldThrowExceptionWhenInputIsEmpty() {
        TennisGame game = new TennisGame();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> game.startGame(""));
        assertEquals("Input sequence must not be null or empty", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenInputIsBlank() {
        TennisGame game = new TennisGame();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> game.startGame(null));
        assertEquals("Input sequence must not be null or empty", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenInputContainsInvalidCharacter() {
        TennisGame game = new TennisGame();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> game.startGame("ABXABA"));
        assertTrue(ex.getMessage().toLowerCase().contains("invalid character"));
    }

    @Test
    void shouldThrowExceptionWhenNoWinnerAtEndOfSequence() {
        TennisGame game = new TennisGame();
        // Example: 6 points, alternating, ends at 40-40 (Deuce) with no winner
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> game.startGame("ABABAB"));
        assertEquals("Input sequence does not represent a complete game", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenGameStopsBeforeWin() {
        TennisGame game = new TennisGame();
        // Example: "AA" -> 30/0 but no winner yet
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> game.startGame("AA"));
        assertEquals("Input sequence does not represent a complete game", ex.getMessage());
    }

    @Test
    void shouldComputeSimpleGameSampleFromStatement() {
        TennisGame game = new TennisGame();
        List<String> result = game.startGame("ABABAA");

        assertEquals(6, result.size());
        assertEquals("Player A : 15 / Player B : 0", result.get(0));
        assertEquals("Player A : 15 / Player B : 15", result.get(1));
        assertEquals("Player A : 30 / Player B : 15", result.get(2));
        assertEquals("Player A : 30 / Player B : 30", result.get(3));
        assertEquals("Player A : 40 / Player B : 30", result.get(4));
        assertEquals("Player A wins the game", result.get(5));
    }

    @Test
    void shouldHandleDeuceAndAdvantageScenario() {
        TennisGame game = new TennisGame();
        // Sequence leading to: 40-40 (Deuce), Advantage A, back to Deuce, Advantage A, A wins
        List<String> result = game.startGame("ABABABABAA");

        assertFalse(result.isEmpty());
        String last = result.get(result.size() - 1);
        assertEquals("Player A wins the game", last);
    }
}
