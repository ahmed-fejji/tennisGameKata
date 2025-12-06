
package com.example.tennis;


public interface GameState {


    void pointTo(PlayerId player, Game game);

    String formatScore(Game game);

    boolean isFinished();
}
