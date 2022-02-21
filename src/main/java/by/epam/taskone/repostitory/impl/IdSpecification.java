package by.epam.taskone.repostitory.impl;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.Specification;

public class IdSpecification implements Specification {

    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        return arrayEntity.getId() == id;
    }
}
