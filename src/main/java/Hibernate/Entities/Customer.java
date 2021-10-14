package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
public class Customer {
    public Customer() {
    }

    public Customer(Integer id, String customerName, String customerSurname, Integer phoneNumber, String eMail,
                    String login, String password, Integer cardNumber, String adress) {
        this.id = id;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
        this.cardNumber = cardNumber;
        this.adress = adress;
    }

    @Id
    @Column(name = "id_customer", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "customer_surname", nullable = false, length = 100)
    private String customerSurname;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "e_mail", length = 45)
    private String eMail;

    @Column(name = "login", nullable = false, length = 45)
    private String login;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "card_number", nullable = false)
    private Integer cardNumber;

    @Column(name = "adress", length = 45)
    private String adress;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", customerName='" + customerName + '\'' +
               ", customerSurname='" + customerSurname + '\'' +
               ", phoneNumber=" + phoneNumber +
               ", eMail='" + eMail + '\'' +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", cardNumber=" + cardNumber +
               ", adress='" + adress + '\'' +
               '}';
    }
}