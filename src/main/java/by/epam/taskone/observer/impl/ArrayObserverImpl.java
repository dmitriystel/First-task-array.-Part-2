package by.epam.taskone.observer.impl;

import by.epam.taskone.action.impl.ArrayActionImpl;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.entity.ArrayEntityStatistics;
import by.epam.taskone.entity.Warehouse;
import by.epam.taskone.exception.ArrayException;
import by.epam.taskone.observer.ArrayEvent;
import by.epam.taskone.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();


    public void replaceStatistic(ArrayEvent event){
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.clearValue(sourceId);
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }


    @Override
    public void updateMinValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayEntityStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = ArrayActionImpl.getInstance();
            OptionalInt min = action.getMinValue(source);
            if (min.isPresent()){
                statistics.setMin(min.getAsInt());
            }
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateMaxValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayEntityStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            OptionalInt max = action.getMaxValue(source);
            if (max.isPresent()){
                statistics.setMax(max.getAsInt());
            }
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateAvgValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayEntityStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            OptionalDouble avg = action.getAvgValue(source);
            if (avg.isPresent()){
                statistics.setAvg(avg.getAsDouble());
            }
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateSumValue(ArrayEvent event) {
        try {
            ArrayEntity source = event.getSource();
            long sourceId = source.getId();
            Warehouse warehouse = Warehouse.getInstance();
            ArrayEntityStatistics statistics = warehouse.getById(sourceId);
            ArrayActionImpl action = new ArrayActionImpl();
            statistics.setSum(action.getSummary(source));
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }
}
