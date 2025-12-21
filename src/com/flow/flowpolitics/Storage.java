package com.flow.flowpolitics;

import com.flow.flowpolitics.enums.Resource;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Resource, Double> resources = new HashMap<>(); /**Количество ресурсов**/
    public Storage() {
        for (Resource res : Resource.values()) {
            resources.put(res, 0.0);
        }
    }
    public Double getAmount(Resource res) {
        return this.resources.get(res);
    }
    public void addResource(Resource resource, double amount) {
        double current = resources.get(resource);
        resources.put(resource, current + amount);
    }
    /**Вычесть ресурс**/
    public boolean subtractResource(Resource resource, double amount) {
        if (resources.get(resource) >= amount) {
            resources.put(resource, resources.get(resource) - amount);
            return true;
        }
        return false;
    }
    public Map<Resource, Double> getResources() {
        return this.resources;
    }
    public void printResources() {
        for (Resource res : Resource.values()) {
            System.out.printf("  %s: %.1f%n", res.getName(), getAmount(res));
        }
    }
}
