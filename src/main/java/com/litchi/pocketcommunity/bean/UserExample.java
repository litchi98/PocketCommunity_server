package com.litchi.pocketcommunity.bean;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNull() {
            addCriterion("tel_Number is null");
            return (Criteria) this;
        }

        public Criteria andTelNumberIsNotNull() {
            addCriterion("tel_Number is not null");
            return (Criteria) this;
        }

        public Criteria andTelNumberEqualTo(String value) {
            addCriterion("tel_Number =", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotEqualTo(String value) {
            addCriterion("tel_Number <>", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThan(String value) {
            addCriterion("tel_Number >", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tel_Number >=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThan(String value) {
            addCriterion("tel_Number <", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLessThanOrEqualTo(String value) {
            addCriterion("tel_Number <=", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberLike(String value) {
            addCriterion("tel_Number like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotLike(String value) {
            addCriterion("tel_Number not like", value, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberIn(List<String> values) {
            addCriterion("tel_Number in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotIn(List<String> values) {
            addCriterion("tel_Number not in", values, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberBetween(String value1, String value2) {
            addCriterion("tel_Number between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andTelNumberNotBetween(String value1, String value2) {
            addCriterion("tel_Number not between", value1, value2, "telNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdIsNull() {
            addCriterion("identification_Id is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdIsNotNull() {
            addCriterion("identification_Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdEqualTo(String value) {
            addCriterion("identification_Id =", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdNotEqualTo(String value) {
            addCriterion("identification_Id <>", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdGreaterThan(String value) {
            addCriterion("identification_Id >", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdGreaterThanOrEqualTo(String value) {
            addCriterion("identification_Id >=", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdLessThan(String value) {
            addCriterion("identification_Id <", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdLessThanOrEqualTo(String value) {
            addCriterion("identification_Id <=", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdLike(String value) {
            addCriterion("identification_Id like", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdNotLike(String value) {
            addCriterion("identification_Id not like", value, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdIn(List<String> values) {
            addCriterion("identification_Id in", values, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdNotIn(List<String> values) {
            addCriterion("identification_Id not in", values, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdBetween(String value1, String value2) {
            addCriterion("identification_Id between", value1, value2, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIdNotBetween(String value1, String value2) {
            addCriterion("identification_Id not between", value1, value2, "identificationId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdIsNull() {
            addCriterion("identification_Image_Id is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdIsNotNull() {
            addCriterion("identification_Image_Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdEqualTo(Integer value) {
            addCriterion("identification_Image_Id =", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdNotEqualTo(Integer value) {
            addCriterion("identification_Image_Id <>", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdGreaterThan(Integer value) {
            addCriterion("identification_Image_Id >", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("identification_Image_Id >=", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdLessThan(Integer value) {
            addCriterion("identification_Image_Id <", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("identification_Image_Id <=", value, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdIn(List<Integer> values) {
            addCriterion("identification_Image_Id in", values, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdNotIn(List<Integer> values) {
            addCriterion("identification_Image_Id not in", values, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdBetween(Integer value1, Integer value2) {
            addCriterion("identification_Image_Id between", value1, value2, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andIdentificationImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("identification_Image_Id not between", value1, value2, "identificationImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdIsNull() {
            addCriterion("contract_Image_Id is null");
            return (Criteria) this;
        }

        public Criteria andContractImageIdIsNotNull() {
            addCriterion("contract_Image_Id is not null");
            return (Criteria) this;
        }

        public Criteria andContractImageIdEqualTo(Integer value) {
            addCriterion("contract_Image_Id =", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdNotEqualTo(Integer value) {
            addCriterion("contract_Image_Id <>", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdGreaterThan(Integer value) {
            addCriterion("contract_Image_Id >", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_Image_Id >=", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdLessThan(Integer value) {
            addCriterion("contract_Image_Id <", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_Image_Id <=", value, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdIn(List<Integer> values) {
            addCriterion("contract_Image_Id in", values, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdNotIn(List<Integer> values) {
            addCriterion("contract_Image_Id not in", values, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_Image_Id between", value1, value2, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andContractImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_Image_Id not between", value1, value2, "contractImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdIsNull() {
            addCriterion("avatar_Image_Id is null");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdIsNotNull() {
            addCriterion("avatar_Image_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdEqualTo(Integer value) {
            addCriterion("avatar_Image_Id =", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdNotEqualTo(Integer value) {
            addCriterion("avatar_Image_Id <>", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdGreaterThan(Integer value) {
            addCriterion("avatar_Image_Id >", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("avatar_Image_Id >=", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdLessThan(Integer value) {
            addCriterion("avatar_Image_Id <", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("avatar_Image_Id <=", value, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdIn(List<Integer> values) {
            addCriterion("avatar_Image_Id in", values, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdNotIn(List<Integer> values) {
            addCriterion("avatar_Image_Id not in", values, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdBetween(Integer value1, Integer value2) {
            addCriterion("avatar_Image_Id between", value1, value2, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andAvatarImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("avatar_Image_Id not between", value1, value2, "avatarImageId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_Id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_Id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_Id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_Id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_Id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_Id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_Id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_Id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_Id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_Id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_Id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_Id not between", value1, value2, "roleId");
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