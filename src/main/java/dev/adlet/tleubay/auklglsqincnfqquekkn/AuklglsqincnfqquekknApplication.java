package dev.adlet.tleubay.auklglsqincnfqquekkn;

import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.TelephonyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackageClasses = TelephonyRepository.class)
@EnableJpaRepositories(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = TelephonyRepository.class))
@SpringBootApplication
public class AuklglsqincnfqquekknApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuklglsqincnfqquekknApplication.class, args);
    }
}
