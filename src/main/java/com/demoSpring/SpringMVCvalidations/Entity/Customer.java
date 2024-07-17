package com.demoSpring.SpringMVCvalidations.Entity;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String firstname;

    @NotNull(message = "Last name must not be null..!")
    @Size(min = 1,message = "Last name is required..!")
    private String lastname;

    //If we want to mark an int value to be not null then we need to use Wrapper classes
    @NotNull(message = "Without Free passes you are not allowed...!")
    @Min(value = 0,message = "Freepasses cannot be less than 0..!")
    @Max(value = 10,message = "Freepasses Cannot be more than 10..!")
    private Integer freepass;

    @Pattern(regexp = "[a-zA-Z0-9]{6}",message = "Postal code must be only 6 letters.!")
    private String postalcode;
}
