package com.example.scripturestudyapp;

/******************************************8
 * Example goals: Read 2 chapters of boM daily
 * Make 3 lesson plans
 * Get NT knowledge score up to 4
 */

/**
 * Will allow the user to set a goal, and this activity will track their progress
 */
public class Goal {
    String history;
    String userGoal;
    int indicator;

    public void setUserGoal(String goalText)
    {

    }
    public String getUserGoal()
    {
        return userGoal;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
