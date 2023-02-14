package com.company.userms;

import com.company.userms.customannotation.MyService;
import io.swagger.v3.oas.annotations.OpenAPI30;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPI30
@RestController
public class UserMsApplication {

    @Autowired
    MyService service;
    private static final Logger LOG = LoggerFactory.getLogger(UserMsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserMsApplication.class, args);
    }

    @RequestMapping("insert")
    public void insert() {
        // TODO Auto-generated method stub
        //invoking first annotated method
        service.insertStudents();
        service.getAll().forEach(s -> {
            LOG.info(s.toString());
        });
        //invoking second annotated method that has sql exception.
        service.insertStudentsExcp();
        //no changes will be reflected in db. will return same value as above
        service.getAll().forEach(s -> {
            LOG.info(s.toString());
        });
    }

}
