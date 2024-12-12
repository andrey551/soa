package com.tad.node2rework.entities;

public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION,
    REGULAR,
    PROBATION;

    public String value() {
        return name();
    }

    public static Status fromValue(String v) {
        return valueOf(v);
    }
}
