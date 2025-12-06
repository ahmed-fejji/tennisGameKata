
package com.example.tennis;


public enum PlayerId {
    A("Player A"),
    B("Player B");

    private final String label;

    PlayerId(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
