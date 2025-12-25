package com.flow.flowpolitics.war;

import com.flow.flowpolitics.PolitStructure;
import com.flow.flowpolitics.enums.WarStatus;
import com.flow.flowpolitics.enums.WarType;

import java.util.*;

public class War {
    private final String id;
    private final WarType warType;
    private WarStatus warStatus;
    private final PolitStructure aggressor;
    private final PolitStructure defender;
    private List<Battle> battles;
    private Map<PolitStructure, WarStats> statistics;
    public War(WarType warType, WarStatus warStatus, PolitStructure aggressor, PolitStructure defender) {
        this.id = "war_" + UUID.randomUUID().toString().substring(0, 8);
        this.warType = warType;
        this.warStatus = warStatus;
        this.aggressor = aggressor;
        this.defender = defender;
        this.battles = new ArrayList<>();
        this.statistics = new HashMap<>();
        this.statistics.put(aggressor, new WarStats(0, 0, 0));
        this.statistics.put(defender, new WarStats(0, 0, 0));
    }
    public void setWarStatus(WarStatus warStatus) {
        this.warStatus = warStatus;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    public void setStatistics(Map<PolitStructure, WarStats> statistics) {
        this.statistics = statistics;
    }
    public String getId() {
        return id;
    }

    public WarType getWarType() {
        return warType;
    }

    public WarStatus getWarStatus() {
        return warStatus;
    }

    public PolitStructure getAggressor() {
        return aggressor;
    }

    public PolitStructure getDefender() {
        return defender;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public Map<PolitStructure, WarStats> getStatistics() {
        return statistics;
    }
}
