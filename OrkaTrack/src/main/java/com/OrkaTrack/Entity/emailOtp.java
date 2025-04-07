package com.OrkaTrack.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_otp")
@Data
public class emailOtp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "empEmail")
    private String email;

    @Column(nullable = false)
    private Integer otp;

    @Column(name = "otp_expiry_time", nullable = false)
    private LocalDateTime otpExpiryTime;


}
