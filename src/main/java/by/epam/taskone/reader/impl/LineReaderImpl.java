package by.epam.taskone.reader.impl;

import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.reader.LineReader;
import by.epam.taskone.validator.impl.NumberValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LineReaderImpl implements LineReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLineFromFile(String path) throws ReaderException {

        NumberValidatorImpl validator = NumberValidatorImpl.getInstance();
        List<String> list;
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = reader.lines().filter(validator::validateLine).collect(Collectors.toList());
            return list;
        } catch (FileNotFoundException ex) {
            logger.error("File " + path + " is not found", ex.getMessage());
            throw new ReaderException(ex);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new ReaderException(e.getMessage());
        }
    }
}
