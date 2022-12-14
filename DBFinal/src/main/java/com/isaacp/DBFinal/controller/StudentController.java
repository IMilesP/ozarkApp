package com.isaacp.DBFinal.controller;

import com.isaacp.DBFinal.entity.DormLeave;
import com.isaacp.DBFinal.entity.StudentAccount;
import com.isaacp.DBFinal.entity.StudentInfo;
import com.isaacp.DBFinal.exception.*;
import com.isaacp.DBFinal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String email,
                                             @RequestParam String studentType) throws BadTypeException {
        studentService.addStudent(firstName, lastName, email, studentType);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfo> getStudent(@PathVariable int studentId) throws InfoNotFoundException {
        return ResponseEntity.ok(studentService.getStudent(studentId));
    }

    @PostMapping("/account/add")
    public ResponseEntity<Object> addStudentAccount(@RequestParam int studentId,
                                                @RequestParam String username,
                                                @RequestParam String password) throws InfoNotFoundException {
        studentService.addAccount(studentId, username, password);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<StudentAccount> getStudentAccount(@PathVariable int accountId) throws AccountNotFoundException {
        return ResponseEntity.ok(studentService.getAccount(accountId));
    }

    @PostMapping("/dorm-leave")
    public ResponseEntity<Object> requestDormLeave(@RequestParam int studentId,
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate leaveDate,
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
                                                   @RequestParam String leaveReason,
                                                   @RequestParam String leaveChaperone,
                                                   @RequestParam int chaperonePhone, //recognizing as string needs fix
                                                   @RequestParam String dormName) throws InfoNotFoundException, InvalidDormName {
        studentService.requestLeave(studentId, leaveDate, returnDate, leaveReason, leaveChaperone, chaperonePhone, dormName);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/dorm-leave/update-status/{leaveId}")
    public ResponseEntity<Object> updateDormLeaveStatus(@PathVariable int leaveId,
                                                         @RequestParam String approvalStatus,
                                                         @RequestParam String statusReason) throws DormLeaveNotFoundException, InvalidStatusException {
        studentService.updateLeaveStatus(leaveId, approvalStatus, statusReason);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/dorm-leave/list-active")
    public ResponseEntity<List<DormLeave>> listActiveDormLeaves() {
        return ResponseEntity.ok(studentService.getActiveLeaves());
    }

    //create endpoint to return history of leaves for student
}
