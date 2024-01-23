package dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.TelephonySuperClass;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telephony")
public class Telephony extends TelephonySuperClass {
}
