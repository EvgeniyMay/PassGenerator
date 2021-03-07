package com.learning.passGenerator.dto;

public class PasswordConfigDTO {

    private int length;

    private boolean hasUpperChars;

    private boolean hasLowerChars;

    private boolean hasNumerals;

    private boolean hasSymbols;


    public int getLength() {
        return length;
    }

    public boolean hasUpperChars() {
        return hasUpperChars;
    }

    public boolean hasLowerChars() {
        return hasLowerChars;
    }

    public boolean hasNumerals() {
        return hasNumerals;
    }

    public boolean hasSymbols() {
        return hasSymbols;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHasUpperChars(boolean hasUpperChars) {
        this.hasUpperChars = hasUpperChars;
    }

    public void setHasLowerChars(boolean hasLowerChars) {
        this.hasLowerChars = hasLowerChars;
    }

    public void setHasNumerals(boolean hasNumerals) {
        this.hasNumerals = hasNumerals;
    }

    public void setHasSymbols(boolean hasSymbols) {
        this.hasSymbols = hasSymbols;
    }
}
