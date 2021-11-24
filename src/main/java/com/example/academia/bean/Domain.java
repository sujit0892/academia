package com.example.academia.bean;

import javax.persistence.*;

@Entity
@Table(name = "Domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domain_id;

    @Column(nullable = false)
    private String batch;
    @Column(nullable = false)
    private String program;
    @Column(nullable = false)
    private String capacity;

    private String qualification;

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
