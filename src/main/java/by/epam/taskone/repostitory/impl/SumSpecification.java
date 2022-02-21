package by.epam.taskone.repostitory.impl;

import by.epam.taskone.action.impl.ArrayActionImpl;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.Specification;

public class SumSpecification implements Specification {

    private int sum;

    public SumSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = new ArrayActionImpl();
        return action.getSummary(arrayEntity) > sum;
    }
}
