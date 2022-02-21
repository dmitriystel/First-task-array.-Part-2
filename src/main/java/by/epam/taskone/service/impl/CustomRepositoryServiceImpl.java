package by.epam.taskone.service.impl;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.impl.ArrayRepositoryImpl;
import by.epam.taskone.service.CustomRepositoryService;
import by.epam.taskone.service.IdGenerator;

import java.util.List;

public class CustomRepositoryServiceImpl implements CustomRepositoryService {

    @Override
    public void addArrayInRepo(ArrayEntity array){
        ArrayRepositoryImpl arrayRepository = ArrayRepositoryImpl.getInstance();
        arrayRepository.addArray(array);
        CustomWarehouseServiceImpl filler = new CustomWarehouseServiceImpl();
        filler.putArrayInWarehouse(array);
    }

    @Override
    public void addNumberInRepo(int... args){
        ArrayEntity array = new ArrayEntity(IdGenerator.idGenerate(), args);
        addArrayInRepo(array);
    }

    @Override
    public void addListInRepo(List<ArrayEntity> arrayEntities){
        for (ArrayEntity array: arrayEntities) {
            addArrayInRepo(array);
        }
    }

}
