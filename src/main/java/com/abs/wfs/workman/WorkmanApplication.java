package com.abs.wfs.workman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages ={"com.abs.wfs.workman.query.tool.mapper"})
public class WorkmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkmanApplication.class, args);
    }

}
