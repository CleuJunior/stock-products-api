package com.csj.pdr.api;

import com.amazonaws.services.sns.AmazonSNS;
import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

import static com.csj.pdr.api.domain.Type.SPECIAL;

@SpringBootApplication
@Slf4j
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(AmazonSNS sns) {
//        return args -> {
//            var result = sns.publish(
//                    "arn:aws:sns:us-east-1:796042116852:my-topic-sns",
//                    new Pessoa("Cledosnaldo", 33).toString()
//            );
//
//            System.out.println();
//        };
//    }
}
