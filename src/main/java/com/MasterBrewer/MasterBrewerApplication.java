package com.MasterBrewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MasterBrewer.Repository.ProjectsRepository;
import com.MasterBrewer.Repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.MasterBrewer.Repository")
@EntityScan(basePackages = "com.MasterBrewer.Entities")
@ComponentScan


public class MasterBrewerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MasterBrewerApplication.class, args);
	}

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectsRepository projectsRepository;

    @Override
    public void run(String... args) throws Exception {
     
    }
}
