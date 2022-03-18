package Fuvar;

import java.time.LocalDateTime;

public class Entity {

    private Integer id;
    private LocalDateTime start;
    private Integer time;
    private Double distance;
    private Double travelFee;
    private Double tip;
    private String paymentMethod;

    public Entity(Integer id, LocalDateTime start, Integer time, Double distance, Double travelFee, Double tip, String paymentMethod) {
        this.id = id;
        this.start = start;
        this.time = time;
        this.distance = distance;
        this.travelFee = travelFee;
        this.tip = tip;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public Integer getTime() {
        return time;
    }

    public Double getDistance() {
        return distance;
    }

    public Double getTravelFee() {
        return travelFee;
    }

    public Double getTip() {
        return tip;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
