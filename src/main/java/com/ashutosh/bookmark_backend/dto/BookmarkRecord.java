package com.ashutosh.bookmark_backend.dto;

import java.time.Instant;

public record BookmarkRecord(long id, String title, String url, Instant createdAt) {
}
