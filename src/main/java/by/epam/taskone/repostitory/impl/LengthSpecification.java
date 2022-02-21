package by.epam.taskone.repostitory.impl;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.Specification;

public class LengthSpecification implements Specification {

    private int length;

    public LengthSpecification(int length) {
        this.length = length;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        return arrayEntity.getLength() == length;
    }
}