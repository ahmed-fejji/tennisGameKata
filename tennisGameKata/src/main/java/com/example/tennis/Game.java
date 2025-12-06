
package com.example.tennis;


public class Game {

    private int pointsA;
    private int pointsB;
    private GameState state;

    Game() {
        this.state = new NormalState();
    }

    void pointTo(PlayerId player) {
        state.pointTo(player, this);
    }

    String currentScore() {
        return state.formatScore(this);
    }

    boolean isFinished() {
        return state.isFinished();
    }

    int getPointsA() {
        return pointsA;
    }

    int getPointsB() {
        return pointsB;
    }

    void incrementPoints(PlayerId player) {
        if (player == PlayerId.A) {
            pointsA++;
        } else {
            pointsB++;
        }
    }

    void setState(GameState newState) {
        this.state = newState;
    }


    boolean isDeuceSituation() {
        return pointsA >= 3 && pointsB >= 3 && pointsA == pointsB;
    }


    PlayerId determineWinnerIfAny() {
        if (pointsA >= 4 && pointsA >= pointsB + 2) {
            return PlayerId.A;
        }
        if (pointsB >= 4 && pointsB >= pointsA + 2) {
            return PlayerId.B;
        }
        return null;
    }


    String translatePoints(int rawPoints) {
        return switch (rawPoints) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "";
        };
    }
}
