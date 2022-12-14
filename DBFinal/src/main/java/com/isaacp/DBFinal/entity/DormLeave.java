package com.isaacp.DBFinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "DormLeave", schema = "dbfinal")
@Getter
@Setter
public class DormLeave implements Serializable {
    @Serial
    private static final long serialVersionUID = 6246944635861348328L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LeaveID", nullable = false)
    @NotNull(message = "Mandatory")
    private Integer leaveId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", nullable = false)
    @NotNull(message = "Mandatory")
    private StudentInfo studentInfo;

    @Column(name = "LeaveDate", nullable = false)
    @NotNull(message = "Mandatory")
    private LocalDate leaveDate;

    @Column(name = "ReturnDate", nullable = false)
    @NotNull(message = "Mandatory")
    private LocalDate returnDate;

    @Column(name = "LeaveReason")
    @Size(max = 500, message = "Length")
    private String leaveReason;

    @Column(name = "LeaveChaperone", nullable = false)
    @Size(max = 50, message = "Length")
    @NotNull(message = "Mandatory")
    private String leaveChaperone;

    @Column(name = "ChaperonePhone", nullable = false)
    @Size(max = 11, message = "Length")
    @NotNull(message = "Mandatory")
    private Integer chaperonePhone;

    @Column(name = "DormName", nullable = false)
    @Size(max = 6, message = "Length")
    @NotNull(message = "Mandatory")
    private String dormName;

    @Column(name = "ApprovalStatus")
    @Size(max = 8, message = "Length")
    private String approvalStatus;

    @Column(name = "StatusReason")
    @Size(max = 500, message = "Length")
    private String statusReason;
}