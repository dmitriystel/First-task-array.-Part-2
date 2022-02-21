package by.epam.taskone.comparator;

import by.epam.taskone.entity.ArrayEntity;

import java.util.Comparator;

public class ArrayEntityByIdComparator implements Comparator<ArrayEntity> {

    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
