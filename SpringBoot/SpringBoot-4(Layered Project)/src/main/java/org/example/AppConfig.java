package org.example;

import org.example.Db.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    //this is due to-->init and cleanup method call
    @Bean(initMethod = "init",destroyMethod = "cleanup")
    public DatabaseConnection dbConnection(){
        return new DatabaseConnection();
    }

}
