package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData() {
    }

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(Set<Task> unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                return getUnion(annsTasks,bobsTasks,carolsTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        HashSet<Task> total = new HashSet<>();
        for (Set<Task> taskSet : sets){
            total.addAll(taskSet);
        }
        return total;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersections = new HashSet<>(first);
        intersections.retainAll(second);
        return intersections;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }

}
