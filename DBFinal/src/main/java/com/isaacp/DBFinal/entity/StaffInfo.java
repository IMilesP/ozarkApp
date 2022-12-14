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
@Table(name = "StaffInfo", schema = "dbfinal")
@Getter
@Setter
public class StaffInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 5149419052664682050L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StaffID", nullable = false)
    @NotNull(message = "Mandatory")
    private Integer staffId;

    @JsonIgnore
    @OneToOne(mappedBy = "staffInfo")
    private StaffAccount staffAccount;

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

    @Column(name = "StaffStatus", nullable = false)
    @Size(max = 10, message = "Length")
    @NotNull(message = "Mandatory")
    private String staffStatus;
}