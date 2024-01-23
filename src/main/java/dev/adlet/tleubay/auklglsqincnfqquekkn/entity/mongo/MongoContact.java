package dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.ContactSuperClass;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "contacts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MongoContact extends ContactSuperClass {
    @Field("name")
    private String name;
    @Field("year_of_birth")
    private Long yearOfBirth;
    @Field("phone_number")
    @Indexed(unique = true)
    private String phoneNumber;
    @Field("second_phone_number")
    @Indexed(unique = true)
    private String secondPhoneNumber;
}
