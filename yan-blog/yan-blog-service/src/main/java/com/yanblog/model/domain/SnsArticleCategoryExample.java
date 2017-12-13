package com.yanblog.model.domain;

import java.util.ArrayList;
import java.util.List;

public class SnsArticleCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SnsArticleCategoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSnsArticleCategoryIdIsNull() {
            addCriterion("sns_article_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdIsNotNull() {
            addCriterion("sns_article_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdEqualTo(Long value) {
            addCriterion("sns_article_category_id =", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdNotEqualTo(Long value) {
            addCriterion("sns_article_category_id <>", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdGreaterThan(Long value) {
            addCriterion("sns_article_category_id >", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sns_article_category_id >=", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdLessThan(Long value) {
            addCriterion("sns_article_category_id <", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("sns_article_category_id <=", value, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdIn(List<Long> values) {
            addCriterion("sns_article_category_id in", values, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdNotIn(List<Long> values) {
            addCriterion("sns_article_category_id not in", values, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdBetween(Long value1, Long value2) {
            addCriterion("sns_article_category_id between", value1, value2, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("sns_article_category_id not between", value1, value2, "snsArticleCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdIsNull() {
            addCriterion("sns_article_id is null");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdIsNotNull() {
            addCriterion("sns_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdEqualTo(Long value) {
            addCriterion("sns_article_id =", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdNotEqualTo(Long value) {
            addCriterion("sns_article_id <>", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdGreaterThan(Long value) {
            addCriterion("sns_article_id >", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sns_article_id >=", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdLessThan(Long value) {
            addCriterion("sns_article_id <", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("sns_article_id <=", value, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdIn(List<Long> values) {
            addCriterion("sns_article_id in", values, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdNotIn(List<Long> values) {
            addCriterion("sns_article_id not in", values, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdBetween(Long value1, Long value2) {
            addCriterion("sns_article_id between", value1, value2, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("sns_article_id not between", value1, value2, "snsArticleId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdIsNull() {
            addCriterion("sns_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdIsNotNull() {
            addCriterion("sns_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdEqualTo(Long value) {
            addCriterion("sns_category_id =", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdNotEqualTo(Long value) {
            addCriterion("sns_category_id <>", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdGreaterThan(Long value) {
            addCriterion("sns_category_id >", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sns_category_id >=", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdLessThan(Long value) {
            addCriterion("sns_category_id <", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("sns_category_id <=", value, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdIn(List<Long> values) {
            addCriterion("sns_category_id in", values, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdNotIn(List<Long> values) {
            addCriterion("sns_category_id not in", values, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdBetween(Long value1, Long value2) {
            addCriterion("sns_category_id between", value1, value2, "snsCategoryId");
            return (Criteria) this;
        }

        public Criteria andSnsCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("sns_category_id not between", value1, value2, "snsCategoryId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}