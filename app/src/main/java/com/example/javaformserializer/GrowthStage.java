package com.example.javaformserializer;

public enum GrowthStage {
    Arrival("Arrival"),
    Seedling("Seedling"),
    GrowingPlant("GrowingPlant"),
    MaturePlant("MaturePlant"),
    Drying("Drying"),
    Exporting("Exporting");


    private final String name;

    /**
     * @param name
     */
    private GrowthStage(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
