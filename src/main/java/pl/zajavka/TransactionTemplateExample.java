package pl.zajavka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionTemplateExample {
    private static final String SQL="INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";
    private SimpleDriverDataSource simpleDriverDataSource;
    private TransactionTemplate transactionTemplate;

    public void example1(){

    }

    public void example2(){

    }



}
