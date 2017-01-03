package com.tsimura.getshared.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Override
    public String toString() {
        return "Entry{" + id + ", title='" + title + '\'' + '}';
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
