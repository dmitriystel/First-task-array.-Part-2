package by.epam.taskone.action;

import by.epam.taskone.entity.ArrayEntity;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayAction {

    OptionalInt getMinValue(ArrayEntity arrayEntity);

    OptionalInt getMaxValue(ArrayEntity arrayEntity);

    OptionalDouble getAvgValue(ArrayEntity arrayEntity);

    int getSummary(ArrayEntity arrayEntity);

    long getNumberOfPlusElements(ArrayEntity arrayEntity);

    long getNumberOfMinusElements(ArrayEntity arrayEntity);

    ArrayEntity replaceElement(ArrayEntity arrayEntity, int desiredElement, int newElement);
}
