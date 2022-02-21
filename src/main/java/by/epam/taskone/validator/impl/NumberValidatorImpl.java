package by.epam.taskone.validator.impl;

import by.epam.taskone.validator.NumberValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidatorImpl implements NumberValidator {

    private static final String REGEX_FOR_ARRAY ="^(-?\\d+(\\s+)?;?(\\s+)?)*$";
    private static final Logger logger = LogManager.getLogger();
    private static NumberValidatorImpl instance;

    public NumberValidatorImpl() {
    }

    public static NumberValidatorImpl getInstance() {
        if (instance == null){
            instance = new NumberValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean validateLine(String str) {
        Pattern pattern = Pattern.compile(REGEX_FOR_ARRAY);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
