package com.sda.expensetrackerproject.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryExpenses")
    private Set<Expense> expenseCategorySet;


    public Category() {
    }

    public Category(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpenseCategorySet(Set<Expense> expenseCategorySet) {
        this.expenseCategorySet = expenseCategorySet;
    }
}
