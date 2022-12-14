package com.isaacp.DBFinal.service;

import com.isaacp.DBFinal.constants.AppConstants;
import com.isaacp.DBFinal.entity.DormLeave;
import com.isaacp.DBFinal.entity.StudentAccount;
import com.isaacp.DBFinal.entity.StudentInfo;
import com.isaacp.DBFinal.exception.*;
import com.isaacp.DBFinal.repository.DormLeaveRepository;
import com.isaacp.DBFinal.repository.StudentAccountRepository;
import com.isaacp.DBFinal.repository.StudentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentInfoRepository studentInfoRepository;

    private final StudentAccountRepository studentAccountRepository;

    private final DormLeaveRepository dormLeaveRepository;

    public void addStudent(String firstName, String lastName, String email, String type) throws BadTypeException {
        if(AppConstants.studentTypes.contains(type.toLowerCase())) {
            StudentInfo student = new StudentInfo();

            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setStudentType(type);
            student.setStudentStatus("active");

            studentInfoRepository.save(student);
        } else {
            throw new BadTypeException("Invalid student type; type must be one of " + AppConstants.studentTypes);
        }
    }

    public StudentInfo getStudent(int studentId) throws InfoNotFoundException {
        return studentInfoRepository.findById(studentId)
                .orElseThrow(() -> new InfoNotFoundException(String.format("Student with id %s could not be found", studentId)));
    }

    public void addAccount(int studentId, String username, String password) throws InfoNotFoundException {
        StudentAccount account = new StudentAccount();

        //account.setStudentInfo(getStudent(studentId));
        account.setUsername(username);
        account.setPassword(password);
        account.setAccountStatus("active");

        studentAccountRepository.save(account);
    }

    public StudentAccount getAccount(int accountId) throws AccountNotFoundException {
        return studentAccountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(String.format("Student account with id %s could not be found", accountId)));
    }

    public void requestLeave(int studentId, LocalDate leaveDate, LocalDate returnDate, String leaveReason, String leaveChaperone, int chaperonePhone, String dormName) throws InfoNotFoundException, InvalidDormName {
        if(AppConstants.dormNames.contains(dormName.toLowerCase())) { //also validate if student is dorm
            DormLeave leaveRequest = new DormLeave();

            leaveRequest.setStudentInfo(getStudent(studentId));
            leaveRequest.setLeaveDate(leaveDate);
            leaveRequest.setReturnDate(returnDate);
            leaveRequest.setLeaveReason(leaveReason);
            leaveRequest.setLeaveChaperone(leaveChaperone);
            leaveRequest.setChaperonePhone(chaperonePhone);
            leaveRequest.setDormName(dormName);
            leaveRequest.setApprovalStatus("pending");

            dormLeaveRepository.save(leaveRequest);
        } else {
            throw new InvalidDormName("Dorm name invalid; must be one of " + AppConstants.dormNames);
        }
    }

    public void updateLeaveStatus(int leaveId, String approvalStatus, String statusReason) throws DormLeaveNotFoundException, InvalidStatusException {
        if(AppConstants.leaveStatuses.contains(approvalStatus.toLowerCase())) {
            DormLeave leaveRequest = getLeave(leaveId);

            leaveRequest.setApprovalStatus(approvalStatus.toLowerCase());
            leaveRequest.setStatusReason(statusReason);

            dormLeaveRepository.save(leaveRequest);
        } else {
            throw new InvalidStatusException("Invalid leave request status; status must be one of " + AppConstants.leaveStatuses);
        }
    }

    private DormLeave getLeave(int leaveId) throws DormLeaveNotFoundException {
        return dormLeaveRepository.findById(leaveId)
                .orElseThrow(() -> new DormLeaveNotFoundException(String.format("Leave request with id %s could not be found", leaveId)));
    }

    public List<DormLeave> getActiveLeaves() {
        return dormLeaveRepository.getAllActiveLeaves();
    }
}
