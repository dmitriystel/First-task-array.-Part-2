package by.epam.taskone.observer;

public interface ArrayObservable {

    void attach(ArrayObserver observer);

    void detach(ArrayObserver observer);

    void notifyObserver();
}
