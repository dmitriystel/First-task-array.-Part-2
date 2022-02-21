package by.epam.taskone.repostitory;

import by.epam.taskone.entity.ArrayEntity;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

    void addArray(ArrayEntity arrayEntity);

    void addAllArrays(Collection<? extends ArrayEntity> arrayEntities);

    void removeArray(ArrayEntity arrayEntity);

    void removeAllArrays(Collection<?> arrayEntities);

    ArrayEntity get(int index);

    ArrayEntity set(int index, ArrayEntity arrayEntity);

    List<? super ArrayEntity> query(Specification specification );

    List sort(Comparator<? super ArrayEntity> comparator);
}
