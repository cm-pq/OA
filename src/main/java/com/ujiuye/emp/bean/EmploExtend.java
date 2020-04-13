package com.ujiuye.emp.bean;

import com.ujiuye.position.bean.Position;

public class EmploExtend extends Employee {
    private Position position;

    @Override
    public String
    toString() {
        return "EmploExtend{" +
                "position=" + position +
                '}';
    }

    public Position getPosition() {

        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
