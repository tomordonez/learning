# PowerBI with Azure SQL Database

Connect PowerBI to Azure SQL Database. Optionally, peform exploratory data analysis with Azure Data Studio to query the Azure SQL Database. Then use PowerBI to query and create the reports.

## Create the sample database

Create the sample database `AdventureWorksLT` as seen in the Microsoft docs [here](https://learn.microsoft.com/en-us/sql/samples/adventureworks-install-configure?view=sql-server-ver16&tabs=ssms)

1. Go to the Azure portal
2. Create a resource
3. Under `SQL Database` select `Create`

**Basics**

Project details

* Select `Subscription`
* Select `Resource Group` or create one

Database details

* Enter a `Database name`
* Select a `Server`
  * If creating a new one:
    * Enter a `Server name`
    * Select a `Location` closest to you.
    * Select `Authentication Method`
      * If you are in an `AD`
        * Select `Use only Azure Active Directory (AD)`
          * Set `Azure AD admin`
          * Find your name in the `Azure Active Directory`
      * Else, select `Use SQL Authentication`
* In `Want to use SQL elastic pool`, leave default `No`
* In `Computer + Storage`
  * Default selected was `Standard S0` (10 DTUs database transaction units, 250GB Storage, $14.72/mo)
  * Select `Configure`
    * Change `Service Tier` to `Basic` (5 DTUs, 2GB storage, $4.90/mo)

Backup storage redundancy

* Select `Locally-redundant backup storage`

**Networking**

Leave the default:

* Connectivity method: `No access`
* Connection policy `Default`
* Minimum TLS version `TLS 1.2`

**Security**

Leave the default:

* Enable Microsoft Defender for SQL ($15/server/mo): Select `Not now`
* Leave other defaults

**Additional Settings**

In `Use existing data`, choose `Sample`.

An overlay says:

    AdventureWorksLT
    Selecting this sample will modify the Compute+Storage settings configured in Basics, for backup compatibility. Visits the Basics tab again to review.

Click `OK` to continue.

Went back to the `Basics` tab, but there were no changes to `Compute+Storage`.

**Review + Create**

Review all details and click `Create`. Then wait a few seconds (or minutes) for deployment.

## Create a Private Link to the Azure SQL Server

**Pending troubleshoot/complete this setup**

As seen in the docs, a Private Link lets you connect to Azure using a private endpoint.

* Go to Azure portal
* Go the SQL server
* Under `Security` go to `Private endpoint connections`

## PowerBI Get Data Azure SQL Database

Go to PowerBI, get data, select Azure, then Azure SQL Database.

* Enter the server name
* Enter the database name
* Data connectivity, select DirectQuery
  
Sign in

* Select `Microsoft Account` and signin to your AD account

**Error**

Pending troubleshoot