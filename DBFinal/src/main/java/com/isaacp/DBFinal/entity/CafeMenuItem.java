package com.isaacp.DBFinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "CafeMenuItem", schema = "dbfinal")
@Getter
@Setter
public class CafeMenuItem implements Serializable {
    @Serial
    private static final long serialVersionUID = -8192678802885507641L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID", nullable = false)
    private Integer itemId;

    @Column(name = "ItemName", nullable = false)
    @Size(max = 50, message = "Length")
    @NotNull(message = "Mandatory")
    private String itemName;

    @Column(name = "ItemDescription", nullable = false)
    @Size(max = 100, message = "Length")
    @NotNull(message = "Mandatory")
    private String itemDescription;
} //add new entity for weekly menu