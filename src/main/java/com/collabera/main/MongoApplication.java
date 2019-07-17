package com.collabera.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.collabera")
@EnableMongoRepositories(basePackages= {"com.collabera.repositories"})
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	public static void main(String[] args) {
		<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>js-cookie</artifactId>
		    <version>2.1.4</version>
		</dependency>
		<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>webjars-locator</artifactId>
		    <version>0.36</version>
		</dependency>
		<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>sockjs-client</artifactId>
		    <version>1.1.2</version>
		</dependency>
		<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>stomp-websocket</artifactId>
		    <version>2.3.3</version>
		</dependency>
		<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>jquery</artifactId>
		    <version>3.2.1</version>
		</dependency>
	}

}
