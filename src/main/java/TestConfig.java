import com.google.gson.Gson;
import com.hemendra.ConfigConstants;
import com.hemendra.Util;
import com.hemendra.config.HeaderConfig;
import com.hemendra.model.User;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Hemendra
 */
public class TestConfig {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String userMappingJsonString = ConfigConstants.USER_MAPPING_JSON;

        HeaderConfig headerConfig = Util.parseStringToJSON(userMappingJsonString, HeaderConfig.class);

        System.out.println(headerConfig.getMappingRules());
        System.out.println(headerConfig.getMapToEntity());

        if (Optional.ofNullable(headerConfig.getMapToEntity()).isPresent() && Optional.ofNullable(headerConfig.getMappingRules()).isPresent()) {
            Object classFromName = Util.findClassFromName(headerConfig.getMapToEntity());
            Class<?> aClass = classFromName.getClass();

            Map<String, String> headerColumnMap = Util.generateHeaderPropertyMapping(headerConfig.getMappingRules());

            System.out.println(headerColumnMap);

            /**
             * Read CSV file
             */

            try(
                    InputStream inputStream = TestConfig.class.getResourceAsStream("test.csv");
                    CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
                    ){
                HeaderColumnNameTranslateMappingStrategy headerColumnNameMappingStrategy = new HeaderColumnNameTranslateMappingStrategy<>();
                headerColumnNameMappingStrategy.setType(aClass);
                headerColumnNameMappingStrategy.setColumnMapping(headerColumnMap);

                // Prepare bean
                CsvToBean csvToBean = new CsvToBean();
                csvToBean.setCsvReader(csvReader);
                csvToBean.setMappingStrategy(headerColumnNameMappingStrategy);
                List parse = csvToBean.parse();

                parse.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


}
