package edu.ncc.nest.nestapp;

public class FoodEntry {
    private long id;
    private String name;
    private int min;
    private int max;
    private String metric;

    public FoodEntry() {

    }

    public FoodEntry(String name, int min, int max, String metric) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.metric = metric;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public boolean equals(Object otherFood) {
        return this.name.equals(((FoodEntry)otherFood).name);}


    @Override
    public String toString() {
        return id + ": " +  "Name: " + name + "\nExp min: " + min +
                "\nExp max: " + max + "Metric: " + metric;
    }
}
