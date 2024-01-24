package dev.adlet.tleubay.auklglsqincnfqquekkn.util;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.FilterDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom realisation of limit and offset functionality
 */
public class ContactsCustomPaginator {
    public static List<ContactDTO> paginateContactsByFilter(List<ContactDTO> contacts, FilterDTO filter) {
        int totalContacts = contacts.size();

        int offset = 0;
        if (filter.getOffset() != null) {
            if (filter.getOffset() > totalContacts) {
                return new ArrayList<>();
            }
            offset = filter.getOffset();
        }


        int limit = totalContacts;
        if (filter.getLimit() != null && filter.getLimit() < totalContacts) {
            limit = offset + filter.getLimit();
        }

        return contacts.subList(offset, limit);
    }
}
