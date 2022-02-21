package by.epam.taskone.repostitory.impl;

import by.epam.taskone.action.impl.ArrayActionImpl;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.Specification;

public class PositiveSpecification implements Specification {

    private int numberOfPositiveElements;

    public PositiveSpecification(int numberOfPositiveElements) {
        this.numberOfPositiveElements = numberOfPositiveElements;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        ArrayActionImpl action = new ArrayActionImpl();
        return action.getNumberOfPlusElements(arrayEntity) < numberOfPositiveElements;
    }


}