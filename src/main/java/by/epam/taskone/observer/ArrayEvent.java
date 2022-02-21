package by.epam.taskone.observer;

import by.epam.taskone.entity.AbstractArrayEntity;
import by.epam.taskone.entity.ArrayEntity;
import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(AbstractArrayEntity source) {
        super(source);
    }

    @Override
    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }
}
