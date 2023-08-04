# Intermediate SQL: Data Reporting and Analysis

Source: Linkedin Learning course [here](https://www.linkedin.com/learning/intermediate-sql-data-reporting-and-analysis)

## 1. Prepare to Code in SQL

Skipped

## 2. Reporting Data with SQL

Analyze average payments grouped by `year_month` and see the counts for each group to see if the averages are fairly distributed for the month.

    select
        concat_ws('_', year(payment_date), month(payment_date)) `year_month`,
        avg(amount),
        count(*)
    from payment
    group by `year_month`;

Query if there is a difference in average rental cost by staff member for 2006

    SELECT 
        CONCAT_WS(' ', s.first_name, s.last_name) staff_member,
        AVG(p.amount) cost_average
    FROM
        payment p,
        staff s
    WHERE
        p.staff_id = s.staff_id
            AND YEAR(p.payment_date) = 2006
    GROUP BY staff_member;

## 3. Editing Data

Query to swap values in rows

    update film f
    join language l on f.language_id = l.language_id
    set f.language_id =
    case
        when l.name = 'Italian' then (select language_id from language where `name` = 'Spanish')
        when l.name = 'Spanish' then (select language_id from language where `name` = 'Italian')
        else f.language_id
    end;

## 4. Inserting Data

One way of merging two tables without `merge` keyword, inserting but not updating values

    insert unmerged1(ProductId, ProductName, Price)
    select ProductId, ProductName, Price
    from unmerged2 u2
    where not exists (select u1.ProductId from unmerged1 u1 where u1.ProductId = u2.ProductId);

Another way of merging two tables using `merge` keyword

    merge into unmerged3 target_table
    using unmerged2 source_table
    on source_table.ProductId = target_table.ProductId
    when matched and source_table.Price <> target_table.Price
        then update set target_table.Price = source_table.Price
    when not matched by target
        then insert values(ProductId, ProductName, Price);

## 5. Deleting Data

Mostly basic things.