package net.javaguides.springmvc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Phone")
@Table(name="PHONES")
public class Phone implements Serializable {

    public Phone() {}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int phoneId;

    @ManyToOne
    @JoinColumn(name= "id")
    private User user;

    private String phone;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Phone [Phone_id = " + phoneId + ", phone=" + phone + "]";
    }

}
