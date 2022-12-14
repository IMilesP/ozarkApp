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
@Table(name = "StaffAccount", schema = "dbfinal")
@Getter
@Setter
public class StaffAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = -1820873827283518319L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AccountID", nullable = false)
    @NotNull(message = "Mandatory")
    private Integer accountId;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "StaffID", referencedColumnName = "StaffID"/*, nullable = false*/)
    //@NotNull(message = "Mandatory")
    private StaffInfo staffInfo;

    @Column(name = "Username", nullable = false)
    @Size(max = 20, message = "Length")
    @NotNull(message = "Mandatory")
    private String username;

    @Column(name = "Password", nullable = false)
    @Size(max = 30, message = "Length")
    @NotNull(message = "Mandatory")
    private String password;

    @Column(name = "AccountStatus", nullable = false)
    @Size(max = 8, message = "Length")
    @NotNull(message = "Mandatory")
    private String accountStatus;
}