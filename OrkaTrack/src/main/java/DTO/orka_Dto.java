package DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Data
public class orka_Dto {

    @NotNull(message = "Employee ID cannot be null")
    private Integer emp_Id;

    @NotNull(message = "First Name cannot be null")
    @Size(min = 1, message = "First Name must not be empty")
    private String emp_Fname;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 1, message = "Last Name must not be empty")
    private String emp_Lname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "Date of Birth must be a past date")
    @NotNull(message = "Date of Birth cannot be null")
    private Date emp_DateOfBirth;

    @NotNull(message = "Phone number cannot be null")
    private Integer phoneNumber;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String emp_Email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String emp_Password;

}
