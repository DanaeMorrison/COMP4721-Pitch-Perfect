package Model;

import java.util.HashMap;

/**
 * Represents a user with an ID, username, password, scores, access rights, day
 * streak, and points.
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private Score[] userScores;
    private HashMap<Integer, Boolean> access;
    private int dayStreak;
    private int points;

    /**
     * Gets the user ID.
     * 
     * @return the user ID.
     */
    public int getID() {
        return userID;
    }

    /**
     * Gets the username.
     * 
     * @return the username.
     */
    public String getUser() {
        return username;
    }

    /**
     * Sets the password.
     * 
     * @param password the new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the score for a specific flashcard.
     * 
     * @param flashcardID the ID of the flashcard.
     * @return the score for the flashcard, or null if not found.
     */
    public Score getScore(int flashcardID) {
        for (Score score : userScores) {
            if (score.getFlashcard() == flashcardID) {
                return score;
            }
        }
        return null;
    }

    /**
     * Updates the access rights for a specific ID.
     * 
     * @param ID        the ID to update.
     * @param hasAccess the access right to set.
     */
    public void updateAccess(int ID, boolean hasAccess) {
        access.put(ID, hasAccess);
    }

    /**
     * Checks the access rights for a specific ID.
     * 
     * @param ID the ID to check.
     * @return true if the user has access, false otherwise.
     */
    public boolean checkAccess(int ID) {
        return access.getOrDefault(ID, false);
    }

    /**
     * Increases the day streak by one.
     */
    public void increaseDayStreak() {
        dayStreak++;
    }

    /**
     * Resets the day streak to zero.
     */
    public void resetDayStreak() {
        dayStreak = 0;
    }

    /**
     * Increases the points by a specified amount.
     * 
     * @param points the amount to increase by.
     */
    public void increasePointsBy(int points) {
        this.points += points;
    }

    /**
     * Gets the total points.
     * 
     * @return the total points.
     */
    public int getPoints() {
        return points;
    }
}
