# SQL: Data Reporting and Analysis

Source: Linkedin Learning course [here](https://www.linkedin.com/learning/sql-data-reporting-and-analysis-18082247)

## 1. Prepare to Code in SQL

This course uses the Sakila database on my old friend phpMyAdmin. However the online demo wouldn't login for me.

* Downloaded the database from [Dev MySQL](https://dev.mysql.com/doc/sakila/en/sakila-installation.html)
* Unzipped the source file and logged into mysql terminal

Sourced each file

    mysql> source ~/Downloads/sakila-db/sakila-schema.sql
    
Confirm the db was created `show databases`. Populate the database:

    mysql> source ~/Downloads/sakila-db/sakila-data.sql

Confirm the database was installed correctly:

    mysql> use sakila;
    mysql> show full tables;
    ...
    23 rows in set
    mysql> select count(*) from film;
    ...
    1000

    mysql> select count(*) from film_text;
    ...
    1000

I gave up on VScode/MySQL and went back to MySQL Workbench.

## 2. Use SQL to Report Data

This was very basic but noted a few things.

In MySQL there is no `proper` function to capitalize a text.

    SELECT CONCAT(UPPER(SUBSTRING(first_name, 1, 1)), LOWER(SUBSTRING(first_name, 2)))
    FROM actor;

Trim a leading substring. For example all rows start with `A ` (Upper case A and space)

    SELECT title, TRIM(LEADING 'A ' FROM description) AS description
    FROM film_text;

Find the position of a substring

    SELECT LOCATE('a substring', column_name)
    FROM table_name;

Select/order by a year

    select *
    from address
    order by year(last_update) desc;

## 3. Group your SQL Results

This doesn't work with `WHERE` and it will show `unknown column count in where clause` because it hasn't grouped the rows

    select district, count(*) as count
    from address
    where count > 5
    group by district
    order by count desc;

Use `HAVING`

    select district, count(*) as count
    from address
    group by district
    having count > 5
    order by count desc;

Group/concatenate rows

    select district, group_concat(phone order by phone asc separator ';')
    from address
    group by district;

## 4. Merge Data from Multiple Tables

Other than the usual basic commands, I wrote this to join the many normalized tables:

    SELECT 
        country.country as country,
        count(*) as number_of_customers
    FROM
        customer, store, address, city, country
    WHERE
        customer.store_id = store.store_id AND
        store.address_id = address.address_id AND
        address.city_id = city.city_id AND
        city.country_id = country.country_id
    GROUP BY country
    ORDER BY country ASC;

Use `UNION` for distinct and `UNION ALL` for ...all. Although use with caution as, either way, the columns should match. I think in Dataflow and PowerQuery there is a warning/error when the columns don't match.

## 5. More Advanced SQL

Created a view where `title` concatenates all films by that actor with syntax `Category: Title;`. This is my version of the default view `actor_info`, which I think it's rather confusing. Also my view runs in `0.044s`, while the default runs in `0.968s`:

    CREATE VIEW `actor_info_but_faster` AS
    SELECT 
        first_name,
        last_name,
        GROUP_CONCAT(title
            ORDER BY title ASC
            SEPARATOR '; ')
    FROM
        (SELECT 
            a.first_name first_name,
                a.last_name last_name,
                CONCAT(c.`name`, ': ', f.title) title
        FROM
            actor a, film f, film_actor fa, film_category fc, category c
        WHERE
            a.actor_id = fa.actor_id
                AND fa.film_id = f.film_id
                AND f.film_id = fc.film_id
                AND fc.category_id = c.category_id) subtable
    GROUP BY first_name , last_name;

Example output

    first_name  last_name   title
    'ADAM', 'GRANT', 'Action: MIDNIGHT WESTWARD; Children: IDOLS SNATCHERS; Children: SPLENDOR PATTON; Children: TWISTED PIRATES; Classics: TADPOLE PARK; Comedy: FIREBALL PHILADELPHIA; Comedy: GROUNDHOG UNCUT; Comedy: OPERATION OPERATION; Family: GLADIATOR WESTWARD; Foreign: BALLROOM MOCKINGBIRD; Foreign: HAPPINESS UNITED; Games: GLORY TRACY; Games: MARS ROMAN; Games: WANDA CHAMBER; Sci-Fi: ANNIE IDENTITY; Sports: LOSER HUSTLER; Sports: SEABISCUIT PUNK; Travel: DISCIPLE MOTHER'
    'ADAM', 'HOPPER', 'Action: CLUELESS BUCKET; Action: MOCKINGBIRD HOLLYWOOD; Children: NOON PAPI; Classics: TOWERS HURRICANE; Comedy: HEAVEN FREEDOM; Comedy: SADDLE ANTITRUST; Documentary: CLERKS ANGELS; Documentary: PRINCESS GIANT; Drama: TORQUE BOUND; Family: BLOOD ARGONAUTS; Family: GABLES METROPOLIS; Family: GREASE YOUTH; Foreign: FICTION CHRISTMAS; Horror: TRAIN BUNCH; Music: CHAMBER ITALIAN; Music: MASKED BUBBLE; Music: WORDS HUNTER; New: LOVERBOY ATTACKS; New: SLEEPY JAPANESE; Sci-Fi: BLINDNESS GUN; Sci-Fi: OPEN AFRICAN; Sci-Fi: VACATION BOONDOCK'

Use a function instead of a subquery.

Find name and email of customers that have not returned a rented item. Probably applicable to outstanding items from a library.

Find how many items haven't been returned

    select count(*) from rental where return_date is null;
    # Output: 183

Find how many items are in stock

    select
    (select count(*) from rental) -
    (select count(*) from rental where return_date is null)
    as inventory_stock;
    # Output: 15861

EDA find number of days it takes to return an item

    SELECT 
        MIN(days), MAX(days), AVG(days)
    FROM
        (SELECT 
            DATEDIFF(DATE(return_date), DATE(rental_date)) days
        FROM
            rental) return_days;

    # min(days), max(days), avg(days)
    '0', '10', '5.0252'

Quick google search of `dvd library return days` says `5 days`. Then get a list of customers that haven't returned an item after 5 days.

First, get a count of not returned items > 5 days by store

    SELECT 
        city.city city,
        country.country country,
        store.store_id store_id,
        COUNT(*) not_returned_count
    FROM
        rental,
        inventory,
        store,
        address,
        city,
        country
    WHERE
        DATEDIFF(DATE(rental.return_date),
                DATE(rental.rental_date)) > 5
            AND rental.inventory_id = inventory.inventory_id
            AND inventory.store_id = store.store_id
            AND store.address_id = address.address_id
            AND address.city_id = city.city_id
            AND city.country_id = country.country_id
    GROUP BY store_id
    ORDER BY not_returned_count DESC;

    # city, country, store_id, not_returned_count
    'Woodridge', 'Australia', '2', '3631'
    'Lethbridge', 'Canada', '1', '3530'

Assume the CRM has email automation that pulls customer name, title, number of days, from the database and sends an email reminder to the customer to return the item. My public library sends letters by mail, including the cost replacement of the item. Let's say there is a late fee of 5% from the rental cost per additional day (if rental was `$3.5` and pastdue is `5 days` then fee is `3.5 * 5d * 0.05 = $0.875`)

    SET @max_rental_days = 5;
    SET @late_fee_percent = 0.05;

    SELECT 
        CONCAT(UPPER(SUBSTR(c.first_name, 1, 1)),
                LOWER(SUBSTR(c.first_name, 2))) first_name,
        c.last_name last_name,
        LOWER(c.email) email,
        f.title title,
        DATEDIFF(DATE(r.return_date), DATE(r.rental_date)) days_overdue,
        CONCAT('$',
                ROUND((p.amount * DATEDIFF(DATE(r.return_date), DATE(r.rental_date)) * @late_fee_percent),
                        2)) late_fee
    FROM
        rental r,
        customer c,
        inventory i,
        film f,
        payment p
    WHERE
        r.inventory_id = i.inventory_id
            AND i.film_id = f.film_id
            AND r.customer_id = c.customer_id
            AND r.rental_id = p.rental_id
    HAVING days_overdue > @max_rental_days;

Created a query to see `in_stock` and `rented` by `store_id`:

    with in_stock as
        (select
            i.store_id store_id,
            count(r.rental_id) units
        from rental r, inventory i
        where r.inventory_id = i.inventory_id
        and r.return_date is not null
        group by store_id),
        rented as
        (select
            i.store_id store_id,
            count(r.rental_id) units
        from rental r, inventory i
        where r.inventory_id = i.inventory_id
        and r.return_date is null
        group by store_id)
    select i.store_id store_id, i.units in_stock, r.units rented
    from in_stock i, rented r
    where i.store_id = r.store_id;

    # store_id, in_stock, rented
    '1', '7831', '92'
    '2', '8030', '91'

Create two functions `in_stock` and `rented` that takes as parameter `store_id`

    delimiter $$

    drop function if exists store_in_stock $$
    create function store_in_stock(store_id int) returns int
        reads sql data
        
    begin
        declare units_in_stock int;
        
        select count(r.rental_id) into units_in_stock
        from rental r, inventory i
        where r.return_date is not null
        and r.inventory_id = i.inventory_id
        and i.store_id = store_id;
        
        return units_in_stock;
    end $$

    drop function if exists store_rented $$
    create function store_rented(store_id int) returns int
        reads sql data

    begin
        declare units_rented int;
        
        select count(rental_id) into units_rented
        from rental r, inventory i
        where r.return_date is null
        and r.inventory_id = i.inventory_id
        and i.store_id = store_id;
        
        return units_rented;
    end $$

    delimiter ;

Created a simple procedure to wrap these functions

    delimiter $$

    drop procedure if exists store_inventory $$
    create procedure store_inventory(in store_id int, out in_stock int, out rented int)
        reads sql data
        
    begin
        select store_in_stock(store_id) into in_stock;
        select store_rented(store_id) into rented;
    end $$

    delimiter ;

Called the procedure:

    call store_inventory(1, @in_stock, @rented);
    select @in_stock, @rented;

    # @in_stock, @rented
    '7831', '92'
