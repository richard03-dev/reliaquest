package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;
import java.util.ArrayList;

public class EmployeeCreator implements Employee {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    public EmployeeCreator() {

    }

    public EmployeeCreator(String firstName, String lastName, Integer salary, 
                        Integer age, String jobTitle, String email, Instant contractHireDate, 
                        Instant contractTerminationDate) {
        this.uuid = UUID.randomUUID();;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.salary = salary;
        this.age = age;
        this.jobTitle = jobTitle;
        this.email = email;
        this.contractHireDate = contractHireDate;
        this.contractTerminationDate = contractTerminationDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getContractHireDate() {
        return contractHireDate;
    }

    public void setContractHireDate(Instant date) {
        this.contractHireDate = date;
    }

    public Instant getContractTerminationDate() {
        return contractTerminationDate;
    }

    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date;
    }
}