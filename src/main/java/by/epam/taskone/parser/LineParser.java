package by.epam.taskone.parser;

import by.epam.taskone.entity.ArrayEntity;

import java.util.List;

public interface LineParser {
    public List<ArrayEntity> parseLine(List<String> lines);
}
