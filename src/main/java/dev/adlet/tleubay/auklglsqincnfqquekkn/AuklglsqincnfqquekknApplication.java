package dev.adlet.tleubay.auklglsqincnfqquekkn;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.MongoTelephony;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.TestRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@EnableMongoRepositories(basePackageClasses = TestRepository.class)
@EnableJpaRepositories(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = TestRepository.class))
@SpringBootApplication
public class AuklglsqincnfqquekknApplication {

    @Autowired
    private TestRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AuklglsqincnfqquekknApplication.class, args);
    }

    @PostConstruct
    public void test() {
        MongoTelephony testEntity = new MongoTelephony();
        testEntity.setId(1L);
        testEntity.setName("p2");
        testEntity.setCreatedAt(LocalDate.now());
        testEntity.setPhoneNumber("p1");
        testEntity.setSecondPhoneNumber("p2");

        if (!repository.existsById(1L)) {
            System.out.println("collection created");
            repository.save(testEntity);
        }
    }
}
