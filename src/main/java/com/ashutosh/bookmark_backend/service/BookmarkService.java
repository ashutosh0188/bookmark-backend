package com.ashutosh.bookmark_backend.service;

import com.ashutosh.bookmark_backend.domain.BookmarkEntity;
import com.ashutosh.bookmark_backend.domain.BookmarkProjection;
import com.ashutosh.bookmark_backend.domain.BookmarkRepository;
import com.ashutosh.bookmark_backend.dto.BookmarkDTO;
import com.ashutosh.bookmark_backend.dto.BookmarkRecord;
import com.ashutosh.bookmark_backend.dto.CreateBookmarkRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

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

    @Transactional
    public BookmarkRecord createBookmark(@Valid CreateBookmarkRequest request) {
        BookmarkEntity entity = new BookmarkEntity();
        entity.setTitle(request.getTitle());
        entity.setUrl(request.getUrl());
        entity.setCreatedAt(Instant.now());
        BookmarkEntity save = repository.save(entity);
        return new BookmarkRecord(save.getId(), save.getTitle(), save.getUrl(), save.getCreatedAt());
    }
}
