package com.cognizant.utils;

public class LendingObject {
    private Long userId;
    private Long bookId;

    public Long getUserId() {
        return this.userId;
    }

    public void setCustomerId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
