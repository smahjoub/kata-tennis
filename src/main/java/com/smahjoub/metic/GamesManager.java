package com.smahjoub.metic;

import java.util.LinkedList;

/**
 * A basic abstraction for GameScore class to enable score counting for matches
 * @author smahjoub
 */
public class GamesManager {

    private final LinkedList<GameScore> scores;

    private int score;
    private State state;

    /**
     * Create a new instance of GamesManager
     */
    public GamesManager(){
        scores = new LinkedList<>();
        state = State.NotReady;
    }

    public void initialize(){
        scores.clear();
        score = 0;
        moveNextGame();
        state = State.Ready;
    }

    /**
     * Start managing games
     */
    public void start(){
        state = State.Playing;
    }

    /**
     * Get the current game instance
     * @return
     * @throws UnsupportedOperationException if the manager state is 'Not Ready'
     */
    public GameScore getCurrentGame()
            throws UnsupportedOperationException {
        if(state == State.NotReady){
            throw new UnsupportedOperationException("Cannot get set score if the game is not ready");
        }

        return scores.getLast();
    }

    /**
     * Add one point
     * @param opponentGamesManager the opponent game manager
     * @throws IllegalArgumentException if the argument is null
     * @throws UnsupportedOperationException if the the method is called on the wrong state
     */
    public void score(GamesManager opponentGamesManager)
            throws IllegalArgumentException, UnsupportedOperationException {

        if(opponentGamesManager == null){
            throw new IllegalArgumentException("Opponent player GamesManager should not be null");
        }

        if(state != State.Playing){
            throw new UnsupportedOperationException("Cannot score on this state: " + state.getName());
        }

        GameScore currentPlayerScore = getCurrentGame();
        currentPlayerScore.increase(opponentGamesManager.getCurrentGame());

        if(currentPlayerScore.isWinningScore()){
            score++;
            moveNextGame();
            opponentGamesManager.moveNextGame();
        }
    }

    public int getScore() {
        return score;
    }

    public State getState() {
        return state;
    }

    public void end()
            throws UnsupportedOperationException{
        if(state != State.Playing){
            throw new UnsupportedOperationException("Cannot end game at this state: " + state.getName());
        }
        state = State.Finished;
    }

    public void moveNextGame() {
        scores.add(new GameScore());
    }
}
