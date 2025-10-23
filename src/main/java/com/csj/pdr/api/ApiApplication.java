package com.csj.pdr.api;

import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


    @Bean
    CommandLineRunner runner(ICategoryService service) {
        return args -> {
            var request = new CategoryRequest(null, null, Type.NORMAL);
            var rep = service.getById("1b7df775-677a-49c7-9ce3-bac68dabff7b");

            log.info("ANTES DE MUDAR ===> {}", rep);


            var response = service.updateCategory("1b7df775-677a-49c7-9ce3-bac68dabff7b", request);


            log.info("BUSCADO ===> {}", response);

        };
    }

}
