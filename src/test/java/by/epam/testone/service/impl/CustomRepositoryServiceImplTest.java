package by.epam.testone.service.impl;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.entity.Warehouse;
import by.epam.taskone.repostitory.impl.ArrayRepositoryImpl;
import by.epam.taskone.service.IdGenerator;
import by.epam.taskone.service.impl.CustomRepositoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomRepositoryServiceImplTest {
    private final ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
    private final ArrayEntity expectedArray = new ArrayEntity(1, new int[]{2, 5, 7});
    private final CustomRepositoryServiceImpl crs = new CustomRepositoryServiceImpl();
    private static final Logger logger = LogManager.getLogger();

    @Test
    void addArrayInRepo() {
        crs.addArrayInRepo(new ArrayEntity(IdGenerator.idGenerate(), new int[]{2, 5, 7}));
        assertEquals(expectedArray, repository.get(0));
    }

    @Test
    void addNumberInRepo() {
        Warehouse warehouse = Warehouse.getInstance();
        crs.addNumberInRepo(2, 5, 7);
        assertEquals(expectedArray, repository.get(0));
    }

    @Test
    void addListInRepo() {
        ArrayEntity expectedArray2 = new ArrayEntity(IdGenerator.idGenerate(), new int[]{12, 6, 8});
        List<ArrayEntity> list = new ArrayList<>();
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{2, 5, 7}));
        list.add(new ArrayEntity(IdGenerator.idGenerate(), new int[]{12, 6, 8}));
        crs.addListInRepo(list);
        assertEquals(expectedArray, repository.get(0));
        assertEquals(expectedArray2, repository.get(1));
    }
}