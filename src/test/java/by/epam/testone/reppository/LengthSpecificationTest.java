package by.epam.testone.reppository;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.repostitory.impl.ArrayRepositoryImpl;
import by.epam.taskone.repostitory.impl.LengthSpecification;
import by.epam.taskone.service.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthSpecificationTest {
    private final LengthSpecification specification = new LengthSpecification(3);

    @Test
    void specify() {
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        ArrayEntity firstArray = new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3});
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{1,2,3}));
        repository.addArray(new ArrayEntity(IdGenerator.idGenerate(), new int[]{4,5,6,7}));
        assertEquals(firstArray, repository.query(specification).get(0));
    }
}