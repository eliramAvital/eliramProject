package com.example.myproject;

public class FruitInformation {
    String fruitName;
    int calories;

    public FruitInformation(String fruitName, int calories) {
        this.fruitName = fruitName;
        this.calories = calories;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
