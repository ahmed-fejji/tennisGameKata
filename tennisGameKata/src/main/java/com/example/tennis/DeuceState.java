
package com.example.tennis;


public class DeuceState implements GameState {

    @Override
    public void pointTo(PlayerId player, Game game) {
        game.incrementPoints(player);

        PlayerId winner = game.determineWinnerIfAny();
        if (winner != null) {
            game.setState(new FinishedState(winner));
        } else {
            // From deuce, a single point always gives advantage to the player who scored.
            game.setState(new AdvantageState(player));
        }
    }

    @Override
    public String formatScore(Game game) {
        return "Deuce";
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
