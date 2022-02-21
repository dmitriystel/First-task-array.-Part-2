package by.epam.taskone.main;


import by.epam.taskone.comparator.ArrayEntityNumbersComparator;
import by.epam.taskone.entity.ArrayEntity;
import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.repostitory.impl.ArrayRepositoryImpl;
import by.epam.taskone.repostitory.impl.LengthSpecification;
import by.epam.taskone.service.CustomArrayListService;
import by.epam.taskone.service.impl.CustomRepositoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final String PATH = "src\\main\\resources\\data.txt";
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        try {
            ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
            CustomArrayListService service = new CustomArrayListService();
            List<ArrayEntity> list = service.getArrayFromFile(PATH);
            CustomRepositoryServiceImpl crs = new CustomRepositoryServiceImpl();
            crs.addListInRepo(list);
            logger.info(repository.query(new LengthSpecification(1)));
            ArrayEntityNumbersComparator numbersComparator = new ArrayEntityNumbersComparator();
            logger.info(repository.sort(numbersComparator));

        } catch (ReaderException e) {
            logger.error(e.getMessage());
        }
    }
}
