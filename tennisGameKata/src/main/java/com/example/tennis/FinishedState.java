
package com.example.tennis;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class FinishedState implements GameState {

    private  PlayerId winner;


    @Override
    public void pointTo(PlayerId player, Game game) {
        // Game is finished: additional points are ignored by the Game loop,
        // so this method should not normally be called.
    }

    @Override
    public String formatScore(Game game) {
        return winner.label() + " wins the game";
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
