package sdacademy.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "driver_detail")
public class DriverDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * T-tram, B-bus, A-all
     */
    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "phone_number")
    private String phoneNumber;

    public DriverDetail() {
    }

    public DriverDetail(String transportType, String phoneNumber) {
        this.transportType = transportType;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "DriverDetail{" +
                "id=" + id +
                ", transportType='" + transportType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
