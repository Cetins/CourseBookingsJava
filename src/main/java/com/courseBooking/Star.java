package com.courseBooking;

public enum Star {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final Integer rating;

    Star(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }
}
