package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "usersMyShop")
public class Users implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8625794132451612855L;


    @Id
    @Column(name = "idU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password", unique = false, updatable = true)
    private String password;

    @Column(name = "age", unique = false, updatable = true)
    private  int age;

    @Column(name = "adress", unique = false, updatable = true)
    private String adress;


    public Users(long id, String name, String password, int age, String adress) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setAge(age);
        this.setAdress(adress);
    }
    public Users() {
    }

    public Users(String name, String password, int age, String adress) {
        this.setId(-1);
        this.setName(name);
        this.setPassword(password);
        this.setAge(age);
        this.setAdress(adress);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {this.age = age; }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() { return age; }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress+ '\'' +
                "}";
    }
}