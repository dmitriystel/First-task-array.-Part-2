package by.epam.taskone.service;

import by.epam.taskone.entity.ArrayEntity;

import java.util.List;

public interface CustomWarehouseService {

    void putArrayInWarehouse(ArrayEntity array);

    void putNumbersInWarehouse(int... args);

    void putListInWarehouse(List<ArrayEntity> arrayEntities);

}
