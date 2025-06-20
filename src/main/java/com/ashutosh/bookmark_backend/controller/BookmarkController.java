package com.ashutosh.bookmark_backend.controller;

import com.ashutosh.bookmark_backend.dto.BookmarkDTO;
import com.ashutosh.bookmark_backend.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
