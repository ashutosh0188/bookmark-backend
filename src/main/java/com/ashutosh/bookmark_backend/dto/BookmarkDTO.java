package com.ashutosh.bookmark_backend.dto;

import com.ashutosh.bookmark_backend.domain.BookmarkProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class BookmarkDTO {
    private long totalElements;
    private int totalPage;
    private int currentPage;
    private long currentPageSize;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;
    private List<BookmarkProjection> data;

    public BookmarkDTO(Page<BookmarkProjection> projections) {
        this.totalElements = projections.getTotalElements();
        this.totalPage = projections.getTotalPages();
        this.currentPage = projections.getNumber() + 1;
        this.currentPageSize = projections.getNumberOfElements();
        this.isFirst = projections.isFirst();
        this.isLast = projections.isLast();
        this.hasNext = projections.hasNext();
        this.hasPrevious = projections.hasPrevious();
        this.data = projections.getContent();
    }
}
