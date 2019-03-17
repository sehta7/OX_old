package com.firm.OX;

import java.util.Objects;

public class Size {

    private int length;
    private int height;

    public Size(int length, int height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return length == size.length &&
                height == size.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }
}
