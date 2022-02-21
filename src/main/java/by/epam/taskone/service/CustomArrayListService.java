package by.epam.taskone.service;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.parser.impl.LineParserImpl;
import by.epam.taskone.reader.impl.LineReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CustomArrayListService {
    private static final Logger logger = LogManager.getLogger();

    public List<ArrayEntity> getArrayFromFile(String path) throws ReaderException {
        LineReaderImpl lineReaderImpl = new LineReaderImpl();
        LineParserImpl lineParserImpl = new LineParserImpl();
        List<String> stringList = lineReaderImpl.readLineFromFile(path);
        return lineParserImpl.parseLine(stringList);
    }
}