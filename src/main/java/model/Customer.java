package model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name="total_orders")
    private  Integer totalOrders;

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;





    public String getFirstName( ) {
        return firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public String getEmail( ) {
        return email;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }
    public  List<Order> getOrders(){
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void  setOrders(Order order) {
        this.orders.add(order);
    }

    public void  setTotalOrders() {
       this.totalOrders+=1;
    }


}
