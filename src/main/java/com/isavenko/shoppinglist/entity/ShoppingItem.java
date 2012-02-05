package com.isavenko.shoppinglist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ShoppingItem implements BaseEntity, Serializable {

    private static final long serialVersionUID = 02042012L;

    private Long id;

    private String name;

    @Column
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Id
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
