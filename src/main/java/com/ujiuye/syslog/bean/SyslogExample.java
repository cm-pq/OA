package com.ujiuye.syslog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyslogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyslogExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSysusernameIsNull() {
            addCriterion("sysusername is null");
            return (Criteria) this;
        }

        public Criteria andSysusernameIsNotNull() {
            addCriterion("sysusername is not null");
            return (Criteria) this;
        }

        public Criteria andSysusernameEqualTo(String value) {
            addCriterion("sysusername =", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameNotEqualTo(String value) {
            addCriterion("sysusername <>", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameGreaterThan(String value) {
            addCriterion("sysusername >", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameGreaterThanOrEqualTo(String value) {
            addCriterion("sysusername >=", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameLessThan(String value) {
            addCriterion("sysusername <", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameLessThanOrEqualTo(String value) {
            addCriterion("sysusername <=", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameLike(String value) {
            addCriterion("sysusername like", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameNotLike(String value) {
            addCriterion("sysusername not like", value, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameIn(List<String> values) {
            addCriterion("sysusername in", values, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameNotIn(List<String> values) {
            addCriterion("sysusername not in", values, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameBetween(String value1, String value2) {
            addCriterion("sysusername between", value1, value2, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSysusernameNotBetween(String value1, String value2) {
            addCriterion("sysusername not between", value1, value2, "sysusername");
            return (Criteria) this;
        }

        public Criteria andSystimeIsNull() {
            addCriterion("systime is null");
            return (Criteria) this;
        }

        public Criteria andSystimeIsNotNull() {
            addCriterion("systime is not null");
            return (Criteria) this;
        }

        public Criteria andSystimeEqualTo(Date value) {
            addCriterion("systime =", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotEqualTo(Date value) {
            addCriterion("systime <>", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeGreaterThan(Date value) {
            addCriterion("systime >", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeGreaterThanOrEqualTo(Date value) {
            addCriterion("systime >=", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeLessThan(Date value) {
            addCriterion("systime <", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeLessThanOrEqualTo(Date value) {
            addCriterion("systime <=", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeIn(List<Date> values) {
            addCriterion("systime in", values, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotIn(List<Date> values) {
            addCriterion("systime not in", values, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeBetween(Date value1, Date value2) {
            addCriterion("systime between", value1, value2, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotBetween(Date value1, Date value2) {
            addCriterion("systime not between", value1, value2, "systime");
            return (Criteria) this;
        }

        public Criteria andSysurlIsNull() {
            addCriterion("sysurl is null");
            return (Criteria) this;
        }

        public Criteria andSysurlIsNotNull() {
            addCriterion("sysurl is not null");
            return (Criteria) this;
        }

        public Criteria andSysurlEqualTo(String value) {
            addCriterion("sysurl =", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlNotEqualTo(String value) {
            addCriterion("sysurl <>", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlGreaterThan(String value) {
            addCriterion("sysurl >", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlGreaterThanOrEqualTo(String value) {
            addCriterion("sysurl >=", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlLessThan(String value) {
            addCriterion("sysurl <", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlLessThanOrEqualTo(String value) {
            addCriterion("sysurl <=", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlLike(String value) {
            addCriterion("sysurl like", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlNotLike(String value) {
            addCriterion("sysurl not like", value, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlIn(List<String> values) {
            addCriterion("sysurl in", values, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlNotIn(List<String> values) {
            addCriterion("sysurl not in", values, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlBetween(String value1, String value2) {
            addCriterion("sysurl between", value1, value2, "sysurl");
            return (Criteria) this;
        }

        public Criteria andSysurlNotBetween(String value1, String value2) {
            addCriterion("sysurl not between", value1, value2, "sysurl");
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