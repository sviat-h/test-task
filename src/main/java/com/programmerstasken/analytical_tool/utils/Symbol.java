package com.programmerstasken.analytical_tool.utils;

public enum Symbol {
    C("C"), //waiting timeline
    D("D"), //query
    P("P"), //first answer
    N("N"), //next answer
    DOT("."),
    SPACE(" "),
    ASTERISK("*"), //it means query match all  services/question types
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
