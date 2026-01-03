package com.flow.flowpolitics;

import com.flow.flowpolitics.war.War;

public class Faction extends PolitStructure{
    public Faction(String name, double treasury, int maxSoldiers, int currentSoldiers, War war) {
        super(name, treasury, maxSoldiers, currentSoldiers, war);

    }
}