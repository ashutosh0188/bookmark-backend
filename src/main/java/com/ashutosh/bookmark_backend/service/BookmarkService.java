package com.ashutosh.bookmark_backend.service;

import com.ashutosh.bookmark_backend.domain.BookmarkProjection;
import com.ashutosh.bookmark_backend.domain.BookmarkRepository;
import com.ashutosh.bookmark_backend.dto.BookmarkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository repository;

    public BookmarkDTO getPaginatedBookmark(int page) {
        page = page <= 0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkProjection> allBookmark = repository.findBy(pageable);
        return new BookmarkDTO(allBookmark);
    }

    public BookmarkDTO searchBookmarkByTitle(String query, int page) {
        page = page <= 0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkProjection> allBookmark = repository.findByTitleContainingIgnoreCase(query, pageable);
        return new BookmarkDTO(allBookmark);
    }
}
