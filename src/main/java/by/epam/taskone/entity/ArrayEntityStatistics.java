package by.epam.taskone.entity;

import java.util.Objects;
import java.util.Optional;

public class ArrayEntityStatistics {
    private Integer min;
    private Integer max;
    private Double avg;
    private int sum;

    public ArrayEntityStatistics() {
    }

    public ArrayEntityStatistics(int max, int min, double avg, int sum) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.sum = sum;
    }

    public Optional<Integer> getMin() {
        return Optional.ofNullable(min);
    }

    public Optional<Integer> getMax() {
        return Optional.ofNullable(max);
    }

    public Optional<Double> getAvg() {
        return Optional.ofNullable(avg);
    }

    public int getSum() {
        return sum;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntityStatistics that = (ArrayEntityStatistics) o;
        return sum == that.sum && Objects.equals(max, that.max) && Objects.equals(min, that.min) && Objects.equals(avg, that.avg);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatistics{");
        sb.append(", min=").append(min);
        sb.append("max=").append(max);
        sb.append(", avg=").append(avg);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}

