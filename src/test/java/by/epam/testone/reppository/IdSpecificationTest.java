package by.epam.testone.reppository;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.impl.ArrayRepositoryImpl;
import by.epam.taskone.repostitory.impl.IdSpecification;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {
    private final IdSpecification specification = new IdSpecification(1);

    @Test
    void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity array = new ArrayEntity(1, new int[]{1,2,3});
        repository.addArray(array);
        assertEquals(array, repository.query(specification).get(0));
    }
}