package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CaTaLiS
 */
@Entity
@Table(name = "wybiegi")
public class Run implements Serializable {

    private static final long serialVersionUID = -8580921650124988418L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_start")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_stop")
    private Date stopDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    @PrePersist
    void preInsert() {
        startDate = new Date();
    }
}
