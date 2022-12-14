package com.isaacp.DBFinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "StudentInfo", schema = "dbfinal")
@Getter
@Setter
public class StudentInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -5636787144208480528L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StudentID", nullable = false)
    @NotNull(message = "Mandatory")
    private Integer studentId;

    @JsonIgnore
    @OneToOne(mappedBy = "studentInfo")
    private StudentAccount studentAccount;

    @Column(name = "FirstName", nullable = false)
    @Size(max = 30, message = "Length")
    @NotNull(message = "Mandatory")
    private String firstName;

    @Column(name = "LastName", nullable = false)
    @Size(max = 30, message = "Length")
    @NotNull(message = "Mandatory")
    private String lastName;

    @Column(name = "Email", nullable = false)
    @Size(max = 50, message = "Length")
    @NotNull(message = "Mandatory")
    private String email;

    @Column(name = "StudentType", nullable = false)
    @Size(max = 7, message = "Length")
    @NotNull(message = "Mandatory")
    private String studentType;

    @Column(name = "StudentStatus", nullable = false)
    @Size(max = 11, message = "Length")
    @NotNull(message = "Mandatory")
    private String studentStatus;
}