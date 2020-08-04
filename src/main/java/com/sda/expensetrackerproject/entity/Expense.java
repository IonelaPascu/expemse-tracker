package com.sda.expensetrackerproject.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable=false, updatable=false)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "expenseDate")
    private Date expenseDate;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    private User userExpenses;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryExpenses;

    public Expense() {
    }

    public Category getCategoryExpenses() {
        return categoryExpenses;
    }

    public Expense(Integer id, String description, Date expenseDate){
        this.id = id;
        this.description = description;
        this.expenseDate= expenseDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + id +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
}
