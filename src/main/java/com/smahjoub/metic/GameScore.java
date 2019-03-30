package com.smahjoub.metic;

/**
 * The score manager class
 * @author smahjoub
 */
public class GameScore {

    private static final TennisScore WINNING_SCORE = TennisScore.Victory;
    private TennisScore currentScore;

    /**
     * Get a socre object with score set to 'Zero'
     */
    public GameScore(){
        currentScore = TennisScore.Zero;
    }

    /**
     * Increase the score
     * @param opponentPlayerScore
     * @throws IllegalArgumentException
     */
    public void increase(GameScore opponentPlayerScore)
            throws IllegalArgumentException {

        if(opponentPlayerScore.getCurrentScore() == TennisScore.Victory){
            throw new IllegalArgumentException("Cannot increase the current score if opponent player already won!");
        }

        TennisScore newScore = null;
        switch (currentScore){
            case Zero:
                newScore = TennisScore.Fifteen;
                break;
            case Fifteen:
                newScore = TennisScore.Thirty;
                break;
            case Thirty:
                newScore = TennisScore.Forty;
                break;
            case Forty:
                if(opponentPlayerScore.getCurrentScore() == TennisScore.Forty){
                    newScore = TennisScore.Advantage;
                } else if(opponentPlayerScore.getCurrentScore() == TennisScore.Advantage){
                    opponentPlayerScore.removeAdvantage();
                    newScore = TennisScore.Forty;
                } else {
                    newScore = TennisScore.Victory;
                }
                break;
            case Advantage:
                newScore = TennisScore.Victory;
                break;
            case Victory:
                newScore = TennisScore.Victory;
                break;
        }

        currentScore = newScore;
    }

    /**
     * Change the score from 'Advantage' to 'Forty'
     */
    public void removeAdvantage()
            throws UnsupportedOperationException {
        if(currentScore != TennisScore.Advantage){
            throw new UnsupportedOperationException("The current score is not advantage");
        }
        currentScore = TennisScore.Forty;
    }

    /**
     * The current score
     * @return
     */
    public TennisScore getCurrentScore() {
        return currentScore;
    }

    /**
     * if the current score is winning score.
     * @return a boolean flag
     */
    public boolean isWinningScore() {
        return WINNING_SCORE == currentScore;
    }
}
