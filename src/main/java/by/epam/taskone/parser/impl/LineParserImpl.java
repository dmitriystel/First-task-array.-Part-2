package by.epam.taskone.parser.impl;

import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.parser.LineParser;
import by.epam.taskone.service.IdGenerator;
import by.epam.taskone.validator.impl.NumberValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineParserImpl implements LineParser {

    private static final String ARRAY_SPLITTER = "\\s";
    private static final Logger logger = LogManager.getLogger();

    private static int[] parseToArray(List<String> list){
        if(list.size() == 1 && list.get(0).isBlank()){
            return new int[0];
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = Integer.parseInt(list.get(i).trim());
        }
        return array;
    }

    @Override
    public List<ArrayEntity> parseLine(List<String> lines) {
        NumberValidatorImpl validator = NumberValidatorImpl.getInstance();
        List<ArrayEntity> arrayEntityList = new ArrayList<>();
        for (String line : lines) {
            line = line.trim();
            if (validator.validateLine(line)){
                logger.info("[" + line + "] Valid line");
                ArrayEntity array = parseLine(line);
                arrayEntityList.add(array);
            } else {
                logger.info("[" + line + "] Invalid line");
            }
        }
        return arrayEntityList;
    }


    private ArrayEntity parseLine(String line){
        ArrayEntity arrayEntity;
        List<String> splitArray = Arrays.asList(line.split(ARRAY_SPLITTER));
        arrayEntity = new ArrayEntity(IdGenerator.idGenerate(), parseToArray(splitArray));
        logger.info("entity parsed " + arrayEntity);
        return arrayEntity;
    }
}
