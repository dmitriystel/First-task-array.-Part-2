package by.epam.taskone.entity;

import by.epam.taskone.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Long, ArrayEntityStatistics> mapStatistics;

    public Warehouse() {
        this.mapStatistics = new HashMap<>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayEntityStatistics getById(long arrayId) throws ArrayException {
        if (mapStatistics.containsKey(arrayId)) {
            ArrayEntityStatistics statistics = mapStatistics.get(arrayId);
            return statistics;
        } else {
            logger.error("element with id(" + arrayId + ") not found");
            throw new ArrayException("element with id(" + arrayId + ") not found");
        }
    }

    public ArrayEntityStatistics putById(Long arrayId, ArrayEntityStatistics statistics) {
        return mapStatistics.put(arrayId, statistics);
    }

    public ArrayEntityStatistics removeById(long arrayId) throws ArrayException {
        if (mapStatistics.containsKey(arrayId)) {
            return mapStatistics.remove(arrayId);
        } else {
            logger.error("element with id(" + arrayId + ") not found");
            throw new ArrayException("element with id(" + arrayId + ") not found");
        }
    }

    public ArrayEntityStatistics clearValue(long arrayId) throws ArrayException {
        if(mapStatistics.containsKey(arrayId)){
            return mapStatistics.replace(arrayId, new ArrayEntityStatistics());
        } else {
            logger.error("element with id(" + arrayId + ") not found");
            throw new ArrayException("element with id(" + arrayId + ") not found");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("mapStatistics=").append(mapStatistics);
        sb.append('}');
        return sb.toString();
    }
}