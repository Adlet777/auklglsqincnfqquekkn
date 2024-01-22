package dev.adlet.tleubay.auklglsqincnfqquekkn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "telephony")
public class PostgresTelephony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
