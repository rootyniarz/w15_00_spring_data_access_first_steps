package pl.zajavka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        JdbcTemplateExample example = context.getBean(JdbcTemplateExample.class);

        example.insert();
        example.update();
        example.select();
        example.delete();
        example.select();

    }
}