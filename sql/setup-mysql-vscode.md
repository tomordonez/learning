# Setup MySQL in Visual Studio Code

How to setup MySQL in VScode.

* Install `MySQL` in your OS
* Install a `MySQL` extension in VScode.

## Install MySQL in Linux

Install MySQL in Ubuntu:

    sudo apt install mysql-server

Check that the service was started:

    sudo service mysql status

Output:

    mysql.service - MySQL Community Server
        Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
        Active: active (running) since Sun 2023-02-12 16:43:13 CST; 19s ago
        Process: 842806 ExecStartPre=/usr/share/mysql/mysql-systemd-start pre (code=exited, status=0/SUCCESS)
    Main PID: 842814 (mysqld)
        Status: "Server is operational"
        Tasks: 39 (limit: 18901)
        Memory: 365.5M
            CPU: 952ms
        CGroup: /system.slice/mysql.service
                └─842814 /usr/sbin/mysqld

    Feb 12 16:43:12 mother systemd[1]: Starting MySQL Community Server...
    Feb 12 16:43:13 mother systemd[1]: Started MySQL Community Server.

Check the network status:

    sudo ss -tap | grep mysql

More details in the Ubuntu page [here](https://ubuntu.com/server/docs/databases-mysql)

    LISTEN  0   70   127.0.0.1:33060    0.0.0.0:*   users:(("mysqld",pid=842814,fd=21))      
    LISTEN  0   151  127.0.0.1:mysql    0.0.0.0:*   users:(("mysqld",pid=842814,fd=23))

## Install a MySQL extension in VScode

In VScode look for the `MySQL` extension (developed by Jun Han).

After installing, go to Explorer (icon), and a new tab shows `MySQL`

* Browse to this tab and it will show a `plus +` icon
* Click on `+` and enter the host `localhost`
* Enter the (default) username `root`
* The default root password is empty. Just press `Enter`
* Leave the default port `3306`
* Press `Enter` again if there is an optional field
* A new connection `localhost` shows up under the `MySQL` tab

**ER_NOT_SUPPORTED_AUTH_MODE**

Open the `localhost` dropdown. If it shows the error `ER_NOT_SUPPORTED_AUTH_MODE`. Follow [this](https://www.youtube.com/watch?v=bnW1forz4Sw) solution from Youtube.

Go to the terminal and create a new user.

    $ sudo mysql -u root -p
    [sudo] password: (Enter your sudo pwd)
    Enter password: (Press Enter for default mysql roor pwd)

It connects and the prompt changes to `mysql>`

Create a user with the authentication method `mysql_native_password`. Replace `youruser` and `password` with your preferred credentials:

    mysql> CREATE USER 'youruser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';

Grant privileges to this user:

    mysql> GRANT ALL PRIVILEGES ON *.* TO 'youruser'@'localhost';

Validate the privileges:

    mysql> FLUSH PRIVILEGES;

Exit to close the connection:

    mysql> exit

**Connect localhost in VScode**

Go back to VScode, to the `MySQL` tab.

Delete the `localhost` connection previously created.

Create a new connection again:

* host: `localhost`
* user: `youruser`
* Password: The one you created
* Port number (default): `3306`
* Optional SSL certificate: Press Enter
* Expand the `localhost` connection

## Create a new database

**Naming convention**

* For databases and tables, use lowercase and underscore
* For SQL statements, use all upper case (although not required)


Right click on `localhost`:

* Select `New query`
* Enter the query `CREATE DATABASE your_database_name;`
* Right click on that window and `Run MySQL Query`
* Right click on `localhost` and `Refresh`

**Create a table**

Delete the previous query from the editor window.

Use the typical SQL syntax to create a table and populate it with some data.

    CREATE TABLE IF NOT EXISTS your_database_name.your_table (
        your-schema...
    );

    INSERT INTO your_database_name.your_table (your_columns) VALUES (your_data)

Right click anywhere on this window and `Run MySQL Query`. Then refresh the connection.

**Create a table from CSV**

It is easier to create a MySQL table from CSV using the command line.

Install the program [csvkit](https://csvkit.readthedocs.io/en/latest/index.html).

In Ubuntu:

    sudo apt install python3-dev default-libmysqlclient-dev build-essential csvkit
    pip3 install mysqlclient

Connect to MySQL and create a table using the CSV:

    csvsql --db mysql://youruser:yourpwd@localhost:3306/your_db --tables your_table --insert file.csv

In VScode, refresh `localhost` and the table should appear in `your_db`.

In the query editor:

    USE your_db;

Always select the database before entering other statements or you will get a `No database selected`.

    USE your_db;
    SHOW TABLES;

