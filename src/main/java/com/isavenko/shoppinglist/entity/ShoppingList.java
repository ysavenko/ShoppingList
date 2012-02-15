package com.isavenko.shoppinglist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class ShoppingList implements BaseEntity, Serializable {

    private static final long serialVersionUID = 02072012L;

    private Long id;

    private User user;

    private Date date;

    private List<ShoppingItem> shoppingItems;

    @OneToOne(optional = false)
    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<ShoppingItem> getShoppingItems() {
	return shoppingItems;
    }

    public void setShoppingItems(List<ShoppingItem> shoppingItems) {
	this.shoppingItems = shoppingItems;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Column
    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

}
