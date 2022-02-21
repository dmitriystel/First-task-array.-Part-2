package by.epam.testone.parser;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.parser.impl.LineParserImpl;
import by.epam.taskone.reader.impl.LineReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.List;

public class LineParserImplTest {
    private final LineParserImpl lineParserImpl = new LineParserImpl();
    private static final Logger logger = LogManager.getLogger(LineParserImplTest.class);
    private static final String PATH = "src\\main\\resources\\data.txt";

    @Test
    @DisplayName("parseLine")
    void parseLine() {
        try {
            int[] expectedArray = {-20, 300, 200, 40, 10};
            LineReaderImpl lineReaderImpl = new LineReaderImpl();

            List<String> stringList = lineReaderImpl.readLineFromFile(PATH);
            List<ArrayEntity> realArrayEntityList = lineParserImpl.parseLine(stringList);

            Assertions.assertArrayEquals(expectedArray, realArrayEntityList.get(0).getNumbers());

        } catch (ReaderException e) {
            logger.error(e.getMessage());
        }
    }
}
