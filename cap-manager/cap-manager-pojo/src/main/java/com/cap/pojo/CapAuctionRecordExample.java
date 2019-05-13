package com.cap.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CapAuctionRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CapAuctionRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeIsNull() {
            addCriterion("auctionTime is null");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeIsNotNull() {
            addCriterion("auctionTime is not null");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeEqualTo(Date value) {
            addCriterion("auctionTime =", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeNotEqualTo(Date value) {
            addCriterion("auctionTime <>", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeGreaterThan(Date value) {
            addCriterion("auctionTime >", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auctionTime >=", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeLessThan(Date value) {
            addCriterion("auctionTime <", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeLessThanOrEqualTo(Date value) {
            addCriterion("auctionTime <=", value, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeIn(List<Date> values) {
            addCriterion("auctionTime in", values, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeNotIn(List<Date> values) {
            addCriterion("auctionTime not in", values, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeBetween(Date value1, Date value2) {
            addCriterion("auctionTime between", value1, value2, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctiontimeNotBetween(Date value1, Date value2) {
            addCriterion("auctionTime not between", value1, value2, "auctiontime");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceIsNull() {
            addCriterion("auctionPrice is null");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceIsNotNull() {
            addCriterion("auctionPrice is not null");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceEqualTo(Long value) {
            addCriterion("auctionPrice =", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceNotEqualTo(Long value) {
            addCriterion("auctionPrice <>", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceGreaterThan(Long value) {
            addCriterion("auctionPrice >", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("auctionPrice >=", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceLessThan(Long value) {
            addCriterion("auctionPrice <", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceLessThanOrEqualTo(Long value) {
            addCriterion("auctionPrice <=", value, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceIn(List<Long> values) {
            addCriterion("auctionPrice in", values, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceNotIn(List<Long> values) {
            addCriterion("auctionPrice not in", values, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceBetween(Long value1, Long value2) {
            addCriterion("auctionPrice between", value1, value2, "auctionprice");
            return (Criteria) this;
        }

        public Criteria andAuctionpriceNotBetween(Long value1, Long value2) {
            addCriterion("auctionPrice not between", value1, value2, "auctionprice");
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