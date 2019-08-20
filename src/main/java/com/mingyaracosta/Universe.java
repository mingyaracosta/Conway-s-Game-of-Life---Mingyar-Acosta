package com.mingyaracosta;

public class Universe {
    private static final int DEFAULT_HEIGHT = 10;
    private static final int DEFAULT_WIDTH = 10;

    private int height;
    private int width;

    public Universe(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Universe() {
        this.height = Universe.DEFAULT_HEIGHT;
        this.width = Universe.DEFAULT_WIDTH;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
