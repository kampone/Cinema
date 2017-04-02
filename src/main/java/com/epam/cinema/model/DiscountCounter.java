package com.epam.cinema.model;


public class DiscountCounter {
    private Long userId;
    private Long birthdayStrategyCount;
    private Long tenTicketsStrategyCount;

    public DiscountCounter() {
    }

    public DiscountCounter(Long userId, Long birthdayStrategyCount, Long tenTicketsStrategyCount) {
        this.userId = userId;
        this.birthdayStrategyCount = birthdayStrategyCount;
        this.tenTicketsStrategyCount = tenTicketsStrategyCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBirthdayStrategyCount() {
        return birthdayStrategyCount;
    }

    public void setBirthdayStrategyCount(Long birthdayStrategyCount) {
        this.birthdayStrategyCount = birthdayStrategyCount;
    }

    public Long getTenTicketsStrategyCount() {
        return tenTicketsStrategyCount;
    }

    public void setTenTicketsStrategyCount(Long tenTicketsStrategyCount) {
        this.tenTicketsStrategyCount = tenTicketsStrategyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountCounter that = (DiscountCounter) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (birthdayStrategyCount != null ? !birthdayStrategyCount.equals(that.birthdayStrategyCount) : that.birthdayStrategyCount != null)
            return false;
        return tenTicketsStrategyCount != null ? tenTicketsStrategyCount.equals(that.tenTicketsStrategyCount) : that.tenTicketsStrategyCount == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (birthdayStrategyCount != null ? birthdayStrategyCount.hashCode() : 0);
        result = 31 * result + (tenTicketsStrategyCount != null ? tenTicketsStrategyCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DiscountCounterRepository{" +
                "userId=" + userId +
                ", birthdayStrategyCount=" + birthdayStrategyCount +
                ", tenTicketsStrategyCount=" + tenTicketsStrategyCount +
                '}';
    }
}
