package by.epam.taskone.action;

import by.epam.taskone.entity.ArrayEntity;

public interface ArraySorting {

    ArrayEntity bubbleSort(ArrayEntity arrayEntity);

    ArrayEntity selectionSort(ArrayEntity arrayEntity);

    ArrayEntity insertionSort(ArrayEntity arrayEntity);
}
