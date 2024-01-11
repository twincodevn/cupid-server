package com.cupidconnect.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Title is required")
    @Size(min = 3,max=200,message="Title must be between 3 and 200 characters!")
    private String name;
    @Min(value = 0,message = "Price must be large than 0")
    @Max(value=10000000,message="Price muse be less than 10,000,000")
    private Float price;
    private String thumbnail;
    private String description;
    @NotNull(message = "Category ID is required")
    @JsonProperty("category_id") // in database : name field : category_id
    private String categoryId;


}
