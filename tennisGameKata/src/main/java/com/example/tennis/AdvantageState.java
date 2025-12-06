
package com.example.tennis;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdvantageState implements GameState {

    private PlayerId advantaged;

    @Override
    public void pointTo(PlayerId player, Game game) {
        game.incrementPoints(player);

        PlayerId winner = game.determineWinnerIfAny();
        if (winner != null) {
            game.setState(new FinishedState(winner));
            return;
        }

        // If the other player scores, we go back to deuce.
        if (player != advantaged) {
            game.setState(new DeuceState());
        }
    }

    @Override
    public String formatScore(Game game) {
        return "Advantage " + advantaged.label();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
