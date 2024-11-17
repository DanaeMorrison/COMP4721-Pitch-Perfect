package Model;

import java.util.HashMap;

public class User {
    private int userID;
    private String username;
    private String password;
    private Score[] userScores;
    private HashMap<Integer, Boolean> access;
    private int dayStreak;
    private int points;

    public int getID() {
        return userID;
    }

    public String getUser() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Score getScore(int flashcardID) {
        for (Score score : userScores) {
            if (score.getFlashcard() == flashcardID) {
                return score;
            }
        }
        return null;
    }

    public void updateAccess(int ID, boolean hasAccess) {
        access.put(ID, hasAccess);
    }

    public boolean checkAccess(int ID) {
        return access.getOrDefault(ID, false);
    }

    public void increaseDayStreak() {
        dayStreak++;
    }

    public void resetDayStreak() {
        dayStreak = 0;
    }

    public void increasePointsBy(int points) {
        this.points += points;
    }
}
