package by.epam.taskone.reader;

import by.epam.taskone.exception.ReaderException;

import java.util.List;

public interface LineReader {
    List<String> readLineFromFile (String path) throws ReaderException;
}
