package com.tsimura.getshared.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "entries")
public class Entry implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;
}
