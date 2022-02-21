package by.epam.taskone.service.impl;

import by.epam.taskone.action.impl.ArrayActionImpl;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.entity.ArrayEntityStatistics;
import by.epam.taskone.entity.Warehouse;
import by.epam.taskone.service.CustomWarehouseService;
import by.epam.taskone.service.IdGenerator;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomWarehouseServiceImpl implements CustomWarehouseService {

    @Override
    public void putArrayInWarehouse(ArrayEntity array){
        long id = array.getId();
        ArrayActionImpl action = ArrayActionImpl.getInstance();
        int sum = action.getSummary(array);
        OptionalInt min = action.getMinValue(array);
        OptionalInt max = action.getMaxValue(array);
        OptionalDouble avg = action.getAvgValue(array);
        ArrayEntityStatistics statistics = new ArrayEntityStatistics();
        statistics.setSum(sum);
        if(min.isPresent()){
            statistics.setMin(min.getAsInt());
        }
        if(max.isPresent()){
            statistics.setMax(max.getAsInt());
        }
        if(avg.isPresent()){
            statistics.setAvg(avg.getAsDouble());
        }
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.putById(id, statistics);
    }

    @Override
    public void putNumbersInWarehouse(int... args){
        ArrayEntity array = new ArrayEntity(IdGenerator.idGenerate(), args);
        putArrayInWarehouse(array);
    }


    @Override
    public void putListInWarehouse(List<ArrayEntity> arrayEntities){
        for (ArrayEntity array: arrayEntities) {
            putArrayInWarehouse(array);
        }
    }

}
