package by.epam.testone.action;

import by.epam.taskone.action.impl.ArrayActionImpl;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.exception.ArrayException;
import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.service.CustomArrayListService;
import by.epam.taskone.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayActionImplTest {
    private final ArrayActionImpl action = ArrayActionImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(ArraySortingImplTest.class);
    private ArrayEntity arrayEntity = new ArrayEntity();


    @BeforeEach
    @DisplayName("arrayServiceMethod")
    public void arrayServiceMethod() throws ArrayException, ReaderException {
        CustomArrayListService aes = new CustomArrayListService();
        String path = "src\\main\\resources\\data.txt";
        List<ArrayEntity> arrayEntityList = aes.getArrayFromFile(path);
        arrayEntity = arrayEntityList.get(0);
    }

    @Test
    @DisplayName("convertToIntStream")
    void convertToIntStreamTest() {
        IntStream intStream = action.convertToIntStream(arrayEntity);
        assertArrayEquals(intStream.toArray(), arrayEntity.getNumbers());
    }

    @Test
    @DisplayName("arrayMin")
    void getMinValue() {
        assertEquals(OptionalInt.of(-20), action.getMinValue(arrayEntity));
    }

    @Test
    @DisplayName("arrayMax")
    void getMaxValue() {
        assertEquals( OptionalInt.of(300), action.getMaxValue(arrayEntity));
    }

    @Test
    @DisplayName("arrayAvg")
    void getAvgValue() {
        assertEquals(OptionalDouble.of(106), action.getAvgValue(arrayEntity));
    }

    @Test
    @DisplayName("arraySum")
    void getSummary() {
        assertEquals(530, action.getSummary(arrayEntity));
    }

    @Test
    @DisplayName("plusElements")
    void getNumberOfPlusElements() {
        assertEquals(4, action.getNumberOfPlusElements(arrayEntity));
    }

    @Test
    @DisplayName("minusElements")
    void getNumberOfMinusElements() {
        assertEquals(1, action.getNumberOfMinusElements(arrayEntity));
    }

    @Test
    @DisplayName("replaceElements")
    void replaceElement() {
        ArrayEntity expectedArrayEntity = new ArrayEntity(IdGenerator.idGenerate(), new int[]{-20, 300, 200, 40, 100});
        assertArrayEquals(expectedArrayEntity.getNumbers(), action.replaceElement(arrayEntity, 10, 100).getNumbers());
    }
}