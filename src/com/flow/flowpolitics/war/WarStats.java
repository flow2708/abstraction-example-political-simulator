package com.flow.flowpolitics.war;

import com.flow.flowpolitics.PolitStructure;

public class WarStats {
    int battlesFought;
    int territoriesCaptured;
    int casualties;
    public WarStats(int battlesFought, int territoriesCaptured, int casualties) {
        this.battlesFought = battlesFought;
        this.territoriesCaptured = territoriesCaptured;
        this.casualties = casualties;
    }
    public void setBattlesFought(int battlesFought) {
        this.battlesFought = battlesFought;
    }

    public void setTerritoriesCaptured(int territoriesCaptured) {
        this.territoriesCaptured = territoriesCaptured;
    }

    public void setCasualties(int casualties) {
        this.casualties = casualties;
    }

    public int getBattlesFought() {
        return battlesFought;
    }

    public int getTerritoriesCaptured() {
        return territoriesCaptured;
    }

    public int getCasualties() {
        return casualties;
    }
}
