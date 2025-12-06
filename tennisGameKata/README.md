

## Domain model

- `TennisGame` : main class of the kata. 
- `Game` : domain object representing a single tennis game, holds the raw points and a `GameState`.
- `PlayerId` : enum for the two players (`A`, `B`) with their display labels.
- `GameState` : interface for the different game states.
  - `NormalState` : regular scoring (0, 15, 30, 40) before deuce.
  - `DeuceState` : when both players have at least 40 and the same score.
  - `AdvantageState` : when  a player has the advantage.
  - `FinishedState` : the game has a winner.

    

## Tests

Tests are implemented with JUnit 5 in `TennisGameTest`:

- Input validation:
  - null input
  - empty input
  - invalid character
  - incomplete game (no winner)
- Functional behavior:
  - exact sample from the kata
  - deuce / advantage scenario

Run the tests with:

```bash
mvn test
```

## How to run

- Build the project:

  ```bash
  mvn clean install
  ```

- Run the example main:

   run `TennisGame.main` from your IDE. you can change the sequence input in the main method of class TennisGame

