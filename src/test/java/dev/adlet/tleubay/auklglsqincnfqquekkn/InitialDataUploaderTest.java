package dev.adlet.tleubay.auklglsqincnfqquekkn;

import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.MongoContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.util.InitialDataUploader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.testng.Assert.assertEquals;

@SpringBootTest
public class InitialDataUploaderTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private InitialDataUploader dataUploader;

    @Autowired
    private MongoContactRepository mongoRepository;

    @Autowired
    private PostgresContactRepository postgresRepository;

    @Test
    public void testInsertMongoData() {
        dataUploader.insertMongoData();
        assertEquals(mongoRepository.findAll().size(), dataUploader.entries);
    }

    @Test
    public void testInsertPostgresData() {
        dataUploader.insertPostgresData();
        assertEquals(postgresRepository.findAll().size(), dataUploader.entries);
    }
}
