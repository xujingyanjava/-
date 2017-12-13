package com.yanblog.model.domain;

public class SnsArticleCategory {
    private Long snsArticleCategoryId;

    private Long snsArticleId;

    private Long snsCategoryId;

    public Long getSnsArticleCategoryId() {
        return snsArticleCategoryId;
    }

    public void setSnsArticleCategoryId(Long snsArticleCategoryId) {
        this.snsArticleCategoryId = snsArticleCategoryId;
    }

    public Long getSnsArticleId() {
        return snsArticleId;
    }

    public void setSnsArticleId(Long snsArticleId) {
        this.snsArticleId = snsArticleId;
    }

    public Long getSnsCategoryId() {
        return snsCategoryId;
    }

    public void setSnsCategoryId(Long snsCategoryId) {
        this.snsCategoryId = snsCategoryId;
    }
}