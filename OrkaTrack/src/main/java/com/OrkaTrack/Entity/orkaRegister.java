package com.OrkaTrack.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Date;
@EntityScan
@Entity
@Data
public class orkaRegister {

    //@NotNull(message = "Employee ID cannot be null")
    private Integer empId;

    //@NotNull(message = "First Name cannot be null")
    //@Size(min = 1, message = "First Name must not be empty")
    private String empFname;

    //@NotNull(message = "Last Name cannot be null")
    //@Size(min = 1, message = "Last Name must not be empty")
    private String empLname;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //@Past(message = "Date of Birth must be a past date")
    //@NotNull(message = "emp_DateOfBirth cannot be null")
    private Date empDateOfBirth;

    //@NotNull(message = "Phone number cannot be null")
    private Integer phoneNumber;

    //@Email(message = "Email should be valid")
    //@NotNull(message = "Email cannot be null")
    @Column(name = "empEmail")
    private String empEmail;

    ///@NotNull(message = "Password cannot be null")
    //@Size(min = 8, message = "Password must be at least 8 characters long")
    public String password;

    private Integer otp;
    private LocalDateTime otpExpiryTime;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;



}
