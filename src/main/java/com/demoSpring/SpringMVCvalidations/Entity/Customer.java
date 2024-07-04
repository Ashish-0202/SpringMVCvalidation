package com.demoSpring.SpringMVCvalidations.Entity;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Min(value = 0,message = "Freepasses cannot be less than 0..!")
    @Max(value = 10,message = "Freepasses Cannot be more than 10..!")
    private int freepass;
}
