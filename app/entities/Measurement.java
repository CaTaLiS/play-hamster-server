package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CaTaLiS
 */
@Entity
@Table(name = "pomiary")
public class Measurement implements Serializable {

    private static final long serialVersionUID = 8705927995833564989L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "impulsy_sensor_alfa")
    private Integer sensorAlphaCount;

    @Column(name = "impulsy_sensor_beta")
    private Integer sensorBetaCount;

    @Column(name = "impulsy_sensor_pir")
    private Integer sensorPirCount;

    @Column(name = "temperatura")
    private Double temperature;

    @Column(name = "wilgotnosc")
    private Double humidity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pomiaru")
    private Date dateIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSensorAlphaCount() {
        return sensorAlphaCount;
    }

    public void setSensorAlphaCount(Integer sensorAlphaCount) {
        this.sensorAlphaCount = sensorAlphaCount;
    }

    public Integer getSensorBetaCount() {
        return sensorBetaCount;
    }

    public void setSensorBetaCount(Integer sensorBetaCount) {
        this.sensorBetaCount = sensorBetaCount;
    }

    public Integer getSensorPirCount() {
        return sensorPirCount;
    }

    public void setSensorPirCount(Integer sensorPirCount) {
        this.sensorPirCount = sensorPirCount;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @PrePersist
    void preInsert() {
        dateIn = new Date();
    }
}
