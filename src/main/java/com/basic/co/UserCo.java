package com.basic.co;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class UserCo {

    @NotBlank(message="user name is required")
    private String userName;

    @NotBlank(message = "User city cannot be blank")
    private String userCity;

    @Digits(integer = 10, fraction = 0, message = "Marks must be a number")
    @NotNull(message = "User marks cannot be null")
    @PositiveOrZero(message = "Marks cannot be negative")
    private Float userMarks;

}
