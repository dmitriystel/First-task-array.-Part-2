package by.epam.taskone.service;

import by.epam.taskone.entity.ArrayEntity;

import java.util.List;

public interface CustomRepositoryService {

    void addArrayInRepo(ArrayEntity array);

    void addNumberInRepo(int... args);

    void addListInRepo(List<ArrayEntity> arrayEntities);
}
