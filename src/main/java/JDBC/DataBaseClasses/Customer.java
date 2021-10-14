package JDBC.DataBaseClasses;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private int phoneNumber;
    private String eMail;
    private String login;
    private String password;
    private int cartNumber;
    private String adress;

    public Customer() {
    }

    public Customer(int id, String name, String surname, int phoneNumber, String eMail, String login, String password, int cartNumber, String adress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
        this.cartNumber = cartNumber;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", eMail='" + eMail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", cartNumber=" + cartNumber +
                ", adress='" + adress + '\'' +
                '}'+ "\n";
    }
}
