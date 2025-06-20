package com.ashutosh.bookmark_backend.exception;

import java.util.List;

public record ValidationFailureResponse(String message, List<ValidationFailureField> fields) {
}
