package com.ashutosh.bookmark_backend.controller;

import com.ashutosh.bookmark_backend.dto.BookmarkDTO;
import com.ashutosh.bookmark_backend.dto.BookmarkRecord;
import com.ashutosh.bookmark_backend.dto.CreateBookmarkRequest;
import com.ashutosh.bookmark_backend.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService service;

    @GetMapping("/api/bookmarks")
    public BookmarkDTO getBookmark(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "query", required = false) String query) {
        if (query == null || query.trim().isEmpty()) {
            return service.getPaginatedBookmark(page);
        }
        return service.searchBookmarkByTitle(query, page);
    }

    @PostMapping("/api/bookmarks")
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkRecord createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return service.createBookmark(request);
    }
}
