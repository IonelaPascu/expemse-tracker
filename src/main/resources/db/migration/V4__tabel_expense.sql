create table expense(
                         id int unsigned auto_increment
                             primary key,
                         description varchar(1000) not null,
                         expenseDate datetime,
                         submitterId int unsigned null,
                         categoryId int unsigned null,
                         constraint expense_user_userId_fk
                             foreign key (submitterId) references expensetrackerproject.user(userId),
                         constraint expense_category_categoryId_fk
                             foreign key (categoryId) references expensetrackerproject.category(id)
);

create index submitterId on expense (submitterId);
create index id on expense (id);