# Metic

This project aims to manage a tennis score board.
## Build

Run `mvn install` to build the project. 

## Running unit tests

Run `mvn  test` to execute the unit tests via Junit4.

# Scoring rules
## Win a game
In a standard game (as opposed to a tie-break), each point increases the score of the player to the next value of the following sequence : 0, 15, 30, 40.

If a player has 40 and scores, then he wins the game.

### Deuce state
If both players have 40, then it's deuce. The next player to score a point will have the advantage (yes, it is not the winning point !). If the opponent then scores, the advantage is lost and they are back to deuce (40-40).

To win in deuce, a player must :

1. gain the advantage
2. score while he has the advantage

### Tie-break
In a tie-break game, points are counted as integers and not using the 0-15-30-40 sequence.

To win a tie-break game, a player must score :
* at least 7 points
* 2 more points than the opponent
(Rules explained [here](https://en.wikipedia.org/wiki/Tennis_scoring_system#Scoring_a_tiebreak_game))

## Win a set
To win a game, a player must win :
* at least 6 games
* 2 more games than the opponent

### Tie-break
If both players have 6 games, then the next game is a tie-break.

The winner of the tie-breaker game wins the set.
