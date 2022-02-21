package by.epam.taskone.observer;

public interface ArrayObserver {

    void replaceStatistic(ArrayEvent event);

    void updateMinValue(ArrayEvent event);

    void updateMaxValue(ArrayEvent event);

    void updateAvgValue(ArrayEvent event);

    void updateSumValue(ArrayEvent event);

}
