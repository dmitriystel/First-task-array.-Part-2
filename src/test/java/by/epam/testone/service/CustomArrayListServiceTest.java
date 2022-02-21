package by.epam.testone.service;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.service.CustomArrayListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListServiceTest {

    private final CustomArrayListService aes = new CustomArrayListService();
    private final int[] expectedArray = {-20, 300, 200, 40, 10};
    private static final String PATH = "src\\main\\resources\\data.txt";
    private static final Logger logger = LogManager.getLogger();

    @Test
    @DisplayName("getArrayFromFile")
    void getArrayFromFile() {
        try {
            List<ArrayEntity> readArrayEntityList = aes.getArrayFromFile(PATH);
            assertArrayEquals(expectedArray, readArrayEntityList.get(0).getNumbers());

        } catch (ReaderException e) {
            logger.error(e.getMessage());
        }
    }
}