package com.csj.pdr.api;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.repository.CategoryRepository;
import com.csj.pdr.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

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
//
////        aws --endpoint-url=http://localhost:4566 sns create-topic \
////    --name sns-comment-topic
//    }

}
