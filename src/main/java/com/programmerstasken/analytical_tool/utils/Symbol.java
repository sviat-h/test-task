package com.programmerstasken.analytical_tool.utils;

public enum Symbol {
    C("C"),
    D("D"),
    P("P"),
    N("N"),
    DOT("."),
    SPACE(" "),
    ASTERISK("*"),
    HYPHEN("-");

    private final String symbol;

    Symbol(final String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
