package com.firm.OX;

import java.util.Objects;

class Size {

    private int length;
    private int height;

    Size() {
        this(3,3);
    }

    Size(int length, int height) {
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

    public int getLength() {
        return length;
    }

    public int getHeight(){
        return height;
    }

    public boolean lowerThan(int i) {
        if (length < i || height < i){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return length + "_" + height;
    }
}
