
package com.example.tennis;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class TennisGame {

    public void startAndPrintResultGame(String sequence) {
        List<String> lines = startGame(sequence);
        for (String line : lines) {
            System.out.println(line);
        }
    }


    public List<String> startGame(String sequence) {
        validateInput(sequence);

        Game game = new Game();
        List<String> outputs = new ArrayList<>();

        char[] chars = sequence.trim().toCharArray();
        for (char c : chars) {
            if (game.isFinished()) {
                break;
            }

            PlayerId player = toPlayer(c);
            game.pointTo(player);
            outputs.add(game.currentScore());
        }

        if (!game.isFinished()) {
            throw new IllegalArgumentException("Input sequence does not represent a complete game");
        }

        return outputs;
    }

    private void validateInput(String sequence) {
        if (StringUtils.isBlank(sequence)){
            throw new IllegalArgumentException("Input sequence must not be null or empty");
        }
    }

    private PlayerId toPlayer(char c) {
        if (c == 'A') {
            return PlayerId.A;
        }
        if (c == 'B') {
            return PlayerId.B;
        }
        throw new IllegalArgumentException("Invalid character in sequence: " + c);
    }

    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        game.startAndPrintResultGame("ABABAB");
    }
}
