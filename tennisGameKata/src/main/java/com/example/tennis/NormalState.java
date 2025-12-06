
package com.example.tennis;

/**
 * Normal scoring state: no deuce, no advantage, game not yet finished.
 */
public class NormalState implements GameState {

    @Override
    public void pointTo(PlayerId player, Game game) {
        game.incrementPoints(player);

        PlayerId winner = game.determineWinnerIfAny();
        if (winner != null) {
            game.setState(new FinishedState(winner));
            return;
        }

        if (game.isDeuceSituation()) {
            game.setState(new DeuceState());
        }
    }

    @Override
    public String formatScore(Game game) {
        return "Player A : " + game.translatePoints(game.getPointsA())
             + " / Player B : " + game.translatePoints(game.getPointsB());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
