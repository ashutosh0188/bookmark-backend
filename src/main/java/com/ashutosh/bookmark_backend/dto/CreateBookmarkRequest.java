package com.ashutosh.bookmark_backend.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateBookmarkRequest {
    @NotEmpty(message = "title should not be empty.")
    private String title;

    @NotEmpty(message = "url should not be empty.")
    private String url;
}
