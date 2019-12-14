package com.example.scripturestudyapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Will store the users test history and return their current percentage.
 */
public class KnowledgeModel {
    private int bomScore;
    private int otScore;
    private int ntScore;
    private int pgpScore;
    private int dcScore;
    private  int invScore;
    private int[] sortedScores;
    public KnowledgeModel(){
        bomScore = 0;//get from database
        otScore = 0;
        ntScore = 0;
        pgpScore = 0;
        dcScore = 0;
        invScore = 0;
        sortedScores = new int[5];
    }

    public String getLowest(){
        //get score at end of sorted array
        return "lowest";
    }

    //highest to lowest
    public String sortScores(){
        for(int i = 0;i < sortedScores.length;i++){
            //if()
        }
        return "sorted scores";
    }

    public int getBomScore() {
        return bomScore;
    }

    public void setBomScore(int bomScore) {
        this.bomScore = bomScore;
    }

    public int getOtScore() {
        return otScore;
    }

    public void setOtScore(int otScore) {
        this.otScore = otScore;
    }

    public int getNtScore() {
        return ntScore;
    }

    public void setNtScore(int ntScore) {
        this.ntScore = ntScore;
    }

    public int getPgpScore() {
        return pgpScore;
    }

    public void setPgpScore(int pgpScore) {
        this.pgpScore = pgpScore;
    }

    public int getDcScore() {
        return dcScore;
    }

    public void setDcScore(int dcScore) {
        this.dcScore = dcScore;
    }
}
