# Microsoft Certified: Power BI Data Analyst Associate

Certification page [here](https://learn.microsoft.com/en-us/certifications/power-bi-data-analyst-associate/)

# Getting started with Microsoft data analytics

Source [here](https://learn.microsoft.com/en-us/training/paths/data-analytics-microsoft/)

## Discover data analysis

**Introduction**

* Tell stories with data
* Building data culture
* Facilitate trusted business decisions
* Understand the meaning of metrics

**Overview of data analysis**

What is data analysis?

* Identify, clean, transform, and model data
* Craft data into a story through reports
* Support decision-making process

Analytics categories:

`Descriptive`
* Answer questions based on historical data
* Develop KPIs to track success/failure
* Generate reports to view organization data

`Diagnostic`
* Answer questions to reason why events happened
* Identify anomalies in descriptive analytics data
* Collect related data and use statistical analysis to discover relationships/trends

`Predictive`
* Answer questions to what might happen in the future
* Use historical data and statistical or ML techniques

`Prescriptive`
* Answer questions about which actions to take to achieve a goal
* Use historical data and ML to find patterns

`Cognitive`
* Make inferences based on existing knowledge
* Add findings into self learning feedback loop
* Use unstructured data expressed in degrees of confidence
* Use ML and NLP to process data

**Roles in data**

`Business analyst`
* Similar to data analyst
* Focused on interpreting data from visualizations

`Data analyst`
* Visualization and reporting tools
* ETL (for visualization)
* Design/build scalable data models
* Partner with stakeholders to get requirements
* Manage PBI assets (reports, dashboards, workspaces, datasets) and set security process.
* Partner with data engineer to locate data sources
* Partner with DB admin to get access to data sources

`Data engineer`
* Provision and set up data platform on-prem and cloud
* Manage flow of structured and unstructured data
* Data platform: relational, nonrelational, data stream, file stores
* ETL (to integrate data)

`Data scientist`
* Extract value from data using statistics and ML
* Descriptive with EDA
* Predictive with experiments using ML

`Database administrator`
* Availability and performance of database solutions
* Manage access controls, backup, recovery plans

**Tasks of a data analyst**

`Prepare`
* Profile, clean, and transform data
* Turn raw data into information that is trusted and understandable
  * Data integrity
  * Correct wrong or inaccurate data
  * Identify missing data
  * Convert data from one structure to another
  * Make data more readable
* How to get/connect to data and performance implications
* Strategy for privacy and security
  * Anonymize data or protecting personally identifiable data

`Model`
* Define/create relationships between the tables
* Define metrics and custom calculations to enrich the data
* Makes reports more accurate, allows data to be explored faster
* Decreases time for report writing process
* In PBI, if report is slow to perform/refresh, revisit data preparation and model

`Visualize`
* Understand the problem domain
* Build reports and visualizations

`Analyze`
* Communicate stories to discover insights
* In PBI, use AI features to answer questions/get insights

`Manage`
* Manage PBI assets: reports, dashboards, workspaces, dataset
* Distribute and secure assets
* Use Apps for distribution

## Get started building with Power BI

**Intro**

* Parts of PBI
  * PBI Desktop
  * PBI Service (view reports online)
  * PBI native apps
* Download PBI
  * Windows Store App (auto updates)
  * Download from web (manual updates)

**Use PBI**

* Create report in PBI desktop
* Publish to PBI service and shared
* Consumers view reports on web or mobile apps

**Building blocks for PBI**

`Visualizations`
* Simple or complex representation of data
* Present data to provide context and insights

`Datasets`
* Collection of data to create visualizations
* One or many sources combined
  * For example: 3 dataset fields, one website table, an Excel table
* Filter to focus on specific data
  * Visualize data based on subset

`Reports`
* Collection of visualizations in one or more pages

`Dashboards`
* Share reports/visualization collections with (one-page canvas) dashboards
* Share with other users/groups that can interact with the dashboard

`Tiles`
* Rectangular box, holding a visual on a dashboard

**Use the PBI service**

* `Apps`: Pre-packaged visuals/presets/reports when connecting a data source
  * An app could be connecting to your Github account (or other sources)
  * Or an app pre-packaged by your organization
* Create a Github dashboard
  * Get data
  * Services/Get
  * Select Github and authenticate
  * Explore dashboard and reports
* Update data
  * Go to the dataset and update now or schedule

***

# Prepare data for analysis

Source [here](https://learn.microsoft.com/en-us/training/paths/prepare-data-power-bi/)

## Get data in Power BI

**Intro**

Workflow:
* Connect to data sources
* User Power Query to clean data
* Build reports in PBI
* Publish combined dataset to PBI service

Example `Tailwind Traders` data:
* Sales data in `SQL Server`
* HR Data in `Excel`
* Warehouse JSON data in `Cosmos DB`
* Finance projects in `Azure Analysis`
* Sales goals in `SharePoint`

**Get data from files**

Flat files:
* One data table with same structure for every row
* CSV, txt, Excel, or fixed width files

Scenario:
* HR team has an Excel file with employee data:
  * Employee name
  * Hire date
  * Position
  * Manager
* Use PBI reports to use this data and other sources

Flat file location:
* `Local`: A dataset is created in PBI with the loaded file. However not synced if the source file is changed
* `OneDrive Business`: Source is synced with PBI dataset
* `OneDrive Personal`: Source is synced if login is persistent `Keep me signed in`
* `SharePoint Team Site`: Source is synced with PBI dataset

Connect to data in a file:
* In PBI, get data, Excel
* Open `Employee Data` (excel file)
* Select the tab and Load or Transform Data

Change the source file:
* In PBI, Data source settings
* Select file, change source, OK
 
**Get data from relational data sources**

Scenario:
* Sales team has an on-prem SQL Server database

Connect to data:
* In PBI, get data, SQL Server
* Enter server name, datatabase name, connectivity mode `Import`
* Advanced options (see below for SQL query)
* Sign in
  * Windows: Azure AD
  * Database: SQL Server user
  * Microsoft Account: Used for Azure services

Select data to import:
* Select the table(s) and Load or Transform

Import data with SQL query (not recommended, for reference only)
* Recommendation is creating a View in the database and loading that view
* In `Connect with data`, in `Advanced Options`
* Enter a SQL query to load the table
* Include relationship columns

Change data source settings
* Often required to meet a 90d pwd change policy
* In PBI, Home
  * Transform data, Data source settings
  * Right click source
* In PBI, Power Query
  * Home, Data source settings
  * Or on the right side Query Settings

Create a view in the DB to load sales data > 2019.

	USE salesDB;

	CREATE VIEW sales_since_2020 AS
	SELECT
	  id
	  , name
	  , salesamount
	FROM
	  sales
	WHERE
	  order_date >= '1/1/2020';

Import data with SQL query aka Query folding (Revised)
* In PBI, Get Data, SQL Server, Enter server name, database name
* Advanced options, enter query
  * `SELECT * FROM sales_since_2020;`
* Sign in to AD or DB

**Get data from a NoSQL database**

Scenario:
* SWE team created an app for warehouse to manage shipping and tracking
* It uses the NoSQL Cosmos DB to store JSON docs

Connect to Azure Cosmos DB:
* In PBI, Get data, More, Azure, Azure Cosmos DB
* Enter DB credentials
  * Specify the endpoint URL to get the data from (In Azure find `Primary Key` and `Read-only Keys`)
  * Or enter DB and collection name

Import JSON file:
* Select the table
* Edit (since it only shows JSON objects)
* Power Query, use column expander (top right), to select columns
* Review selected data
* Close and Apply

**Get data from online services**

Scenario:
* Sales goals stored in SharePoint (list)

Connect to data:
* PBI, Get data, Online services, SharePoint Online List
* Get the base SharePoint URL before the `Lists` resource
* Enter the URL, Connect, Sign in to Microsoft account

Choose data to import:
* Select the list to load (or transform)

**Select a storage mode**

Scenario:
* Sales team doesn't allow to create a local copy of a dataset for security reasons
* Other dataset is too large and it will cause performance blocks

3 types of storage modes:
* `Import`
  * Default mode to import a local copy of the dataset
  * Use all PBI features
  * Data refresh can be scheduled
* `DirectQuery`
  * Used when a local copy is not allowed for security reasons or
  * Used when the dataset is too large
  * It creates a direct connection using PBI queries
    * Relational or multidimensional
  * Data is updated real time
  * Queries should load data for visuals in < 5s or UX will be poor
* `Dual`
  * Identify some data to Import and some for DirectQuery

Get data with DirectQuery:
* In PBI, Model view, Get Data
* Select data table
* In Properties pane, select mode `DirectQuery`

**Get data from Azure Analysis Services**

Scenario:
* Sales team uses Azure Analysis Service to store sales projections
* They want to compare this data with actual sales data in a different database.

Azure Analysis Services:
* Managed PaaS for enteprise data models
* Use advanced modeling features
* Combine data from multiple sources, define metrics, and secure data
* Tabular semantic data model
* Easier/faster way to perform data analysis with PBI

Workflow:
* Authenticate with server
* Pick the model
* Select the tables

Azure Analysis Services vs SQL Server:
* Data models have calculations created
* Query the data using MDX or DAX

Get Data:
* In PBI, Get data, Azure, Azure Analysis Services database
* Server name
* Database
* `Connect Live`
  * Keep data and DAX calculations in the server
  * Reports in PBI are updated in real time

**Fix performance issues**

Scenario:
* Imported the data from SQL server using DirectQuery
* In visuals, some tables are queried faster than others
* Some filters are taking longer to process

Recommendations:
* Optimize performance (process data) at the source
* Use native SQL queries (don't pull data from stored procedures)
* Separate date and time into distinct columns
* Use query diagnostics
* Use query folding

Using `Query Diagnostics`:
* In PBI, Power Query Editor
* When ready to transform data, click on `Start diagnostics`
* When done editing, click on `Stop diagnostics`
* Review steps performance in `Diagnose Step`

Using `Query Folding`:
* Transformations in Power Query Editor are tracked as native queries or simple `Select` SQL
* Then these native queries are placed in the data source server
* Benefits
  * Efficient data refreshes since transformation is done at source
  * Compatible with DirectQuery and Dual modes
* Power Query Editor
  * Go to a step and right-click
  * If `View Native Query` is enabled then this step uses Query Folding
    * Enabled if transformation can be translated to a `Select` SQL statement
  * Not enabled if:
    * Adding an index column
    * Merge/append columns of different tables with 2 different sources
    * Change data type of a column

**Resolve data import errors**

Many factors:
* PBI imports many data sources
* Each source can have many error messages
* Hardware, middleware and OS can cause errors
* Data doesn't comply with the schema

Common errors:
* `Query timeout expired`
  * A timeout could have been set by sysadmin on the DB server to avoid overloading
* `PBI Query error: timeout expired`
  * Pulled too much data, limit set by sysadmin
  * Pull data in batches by columns or rows, then Power Query to merge them
* `Could find any data formatted as table`
  * Usually from Excel files. Open Excel file and format as table
* `Couldn't find file`
  * Go to Power Query Editor
  * Select step where file is loaded
  * Verify file location
* `Data type errors`
  * Columns appear blank. Mismatch source with PBI data model
  * Cast columns in the query with data model data type
  * Such as `SELECT CAST(PostalCode AS varchar(10)) FROM Customer`

**Exercise: Prepare data in PBI Desktop**

This is part 1 of this lab:

1. Prepare data in PBI desktop
2. Load data in PBI desktop
3. Design a data model in PBI
4. Create DAX calculations in PBI desktop
5. Created advanced DAX calculations in PBI desktop
6. Design a report in PBI desktop
7. Enhance a report in PBI desktop
8. Perform data analysis in PBI
9. Create a PBI dashboard
10. Enforce row-level security

Summary of some of the lab:
* SQL server data (AdventureWorks sample DB)
  * Tables are dimensions and facts
* CSV file
  * Load from Power Query Editor, Home, New Query, New source
  * Icons on the left of column name is data type
* Power Query Editor
  * View/Column Quality
    * See number of Valid, Error, and Empty
  * View/Column Distribution
    * Distinct and unique values
    * If both are the same, use this as primary key
  * View/Column Profile
    * Value distribution barplot


## Clean, transform, and load data

**Intro**

Scenario:
* Data is imported from many sources but it's not prepared for analysis
* Columns contain errors, null values, incorrect data types
* Unique identifiers are duplicated
* A column contains combined data (like address, city, state, zip)

Clean data benefits:
* Measure and columns produce accurate results
* Tables are organized
* Complicated columns are split into simpler ones

Objectives:
* Correct data inconsistencies
* Apply value replacements
* Profile data
* Transform data types
* Combine queries
* Use naming conventions
* Edit M code

**Shape the initial data**

Scenario:
* One dataset was in CSV
* Another one came from an ERP
* Some data is not needed or it's in the wrong format

*I created this setup since the documentation doesn't provide one*

Setup a CSV called `sales2017.csv`

	,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec
	,,,,,,,,,,,,,
	ProductSubcategoryID,,,,,,,,,,,,,
	1,7800,7900,1200,1500,1200,1000,500,3000,1200,800,900,45000
	3,500,3000,1200,800,900,45000,7800,7900,1200,1500,1200,1000
	2,7800,7900,1200,1500,1200,1000,500,3000,1200,800,900,45000

Setup a CSV called `sales_since_2018.csv`

	year,2018,2019
	January,15000,16000
	February,15000,16000
	March,15000,16000
	April,15000,16000
	May,15000,16000
	June,15000,16000
	July,15000,16000
	August,15000,16000
	September,15000,16000
	October,15000,16000
	November,15000,16000
	December,15000,16000

Setup a Database called `pbipl300studying` in Azure
* Select `Compute+Storage` as `Basic`

In Azure Data Studio
* Connect to the server and select the DB
* Create a schema `CREATE SCHEMA PL300; GO`
* Create tables

Setup a SQL Table called `Product`:

	ID, ProductName
	1,Bikes
	2,Clothing

SQL:

	CREATE TABLE PL300.Product
		(ProductID int PRIMARY KEY IDENTITY (1,1),
		 ProductName nvarchar(25) NOT NULL);
	GO

	INSERT INTO PL300.Product (ProductName)
	VALUES
		(N'Bikes'),
		(N'Clothing');
	GO

Setup a SQL Table called `ProductSubcategory`:

	ID,ProductSubcategoryName,ProductID
	1,Mountain Bikes,1
	2,Road Bikes,1
	3,Gloves,2

SQL:

	CREATE TABLE PL300.ProductSubcategory
		(ProductSubcategoryID int PRIMARY KEY IDENTITY (1,1),
		 ProductSubcategoryName nvarchar(25) NOT NULL,
		 ProductID int NOT NULL,
		 FOREIGN KEY (ProductID) REFERENCES PL300.Product (ProductID)
		 );
	GO

	INSERT INTO PL300.ProductSubcategory (
		ProductSubcategoryName,
		ProductID
	)
	VALUES
		(N'Mountain Bikes',1),
		(N'Road Bikes',1),
		(N'Gloves',2);
	GO

*Back in the documentation, do the following*

Power Query Editor
* In PBI, Transform data
* In the `sales2017.csv` query
  * Fix the headers (Use first row as headers)
  * Rename the month names
  * Remove top blank rows
  * Unpivot columns that contain months
  * Add column with `2017` in all rows
* In the `sales_since_2018` query
  * Unpivot columns
    * Select columns `2018` and `2019`
    * Select `Transform` then `Unpivot`
  * Rename column:
    * `Year` to `Month`
    * `Attribute` to `Year`
    * `Value` to `SalesAmount`
* Select `Close & Apply`
* Go to `Model`
* Drag/drop from `ProductSubcategory` the field `ProductSubcategoryID` to `Sales2017`
  * Create a relationship
  * Cardinality: `1:Many`

Pivot column
* In the case of flat files with a lot of data
* Do a quick EDA with an aggregation (Pivot)
* In Power Query Editor/Transform/Pivot Column
* Select the Values column, for example, `Subcategory Name`
* Select Aggregate, for example, `Count(All)`
  
Apply changes:
* Select `Close & Apply`

**Simplify the data structure**

* Rename queries to user-friendly names
* Replace values
  * Select column, replace values
  * Replace null values in number columns with zero
* Remove duplicates
  * Create a copy of the table
  * Remove duplicates and rename table
* Best practices
  * Avoid long names and abbreviations

**Evaluate and change column data types**

* Wrong data types can cause errors in calculations
  * Wrong date type
  * Hierarchy date doesn' work
  * Higher chances of errors from flat files
* Verify all the columns have the correct data types
  * Type icon next to column
  * Although PBI autodetects data types by scanning the first 1000 rows
* Change column data type
  * Select column, Transform, Data Type or
  * Go to the left of a column name, click data type icon
* Close/Apply


Best practice for `Date` tables
(From experience, these details are not in this doc)

* `Hierarchy Date`
  * Autocreated on Import connections
  * Cannot access this table directly
  * The setting can be enabled/disabled in PBI globally or per PBI file
  * It creates: Year, Quarter, Month, Day
  * It cannot be customized to add for instance `Week` or `Last30Days`
* `Create a Date table` (one of these options)
  * `Date table in source`
    * Responsible: db admin
    * Complexity (from DA POV): hard
    * Best performance for report refresh
  * `Date table in Power Query using M`
    * Responsible: Data analyst
    * Complexity: medium
  * `Date table in In PBI using DAX`
    * Responsible: Data analyst
    * Complexity: easy
      * `DueDate = CALENDARAUTO()` (optional int parameter with last month of fiscal year)
        * Order values in ascending order
        * Select column and check that rows and distinct values are equal
      * It meets the requirements to mark a date table
        * A column of data type `Date`
        * Column contains complete years
        * Column does not have missing dates
    * Worst performance for report refresh
  * `Use a PBI template` that has a date table

**Combine multiple tables into a single table**

Why join tables?
* Too many tables and overcomplicated model
* Many tables have the same role
* A table has columns that fit into a different one
* Create a custom table/column from other ones

`Append queries`
* Scenario
  * Sales team wants to create a contact directory where data is in Employee, Supplier, and Customer
* The tables (ideally) must have columns with the same name
  * Common columns: companyName, personName, phone
  * Otherwise, rename the columns before joining the table
* Appending will join by rows.
  * If one table has 100 rows and the other 200. The final result will be 300 rows.
  * It will also add non-matching columns (like a SQL outer join)
* Power Query Editor
  * Home/Append Queries as New
  * Select the tables

`Merge queries`
* Scenario
  * Sales team wants to see Order and OrderDetails combined
* It requires a common column
  * Similar to SQL join (left, outer, inner)
* Power Query Editor
  * Merge Queries as New
  * Choose tables, matching column, Join kind


**Profile data in PBI**

(This is similar to EDA but with built-in features)

* Examine data structures
  * Open the model to see the structure of tables, attributes, relationships, and cardinalities
* Power Query Editor
  * View/Data Preview
    * Find anomalies, errors, initial insights
  * `Column distribution`
    * Shown below column name
    * Count of distinct and unique
    * If both counts are the same, this could be as UID
  * `Column quality`
    * Shown below column name
    * Percentage of valid, error, empty
    * Ideally valid is 100%
  * `Column profile`
    * Shown on the footer
    * `Column statistics`
      * Based on the total rows if max is <= `1000`
        * Default can be changed from `1000`
        * In status bar change to `Column profiling based on entire data set`
        * Insight: Verify total rows queried
      * Also shows:
        * Error count, empty count, min, max, distinct, unique
        * Insight: Verify min, max match business requirement
    * `Value distribution`
      * Barchart of distinct count
      * Insight: Verify data matches business requirement


**Use Advanced Editor to modify M code**

Why use M code?
* In Power Query Editor, all the steps create M code
* View/Advanced Editor to view code
* Change code to modify a step, although recommended to use the UI
* Written top/down

**Exercise: Load data in PBI Desktop**

* T1: Setup/Load data
  * Dataset is `AdventureWorksDW2020`
* T2: Configure Salesperson query
  * Rename tables prefixed with `Dim` or `Fact`
  * Go the column `SalesPersonFlag`, in the dropdown uncheck `False`
  * Uncheck columns in Home/Choose columns/Choose columns
    * Select: EmployeeKey, EmployeeNationalIDAlternateKey, FirstName, LastName, Title, EmailAddress
  * Merge `FirstName` and `LastName`
    * Select both columns, right click, merge, separator (Space), column name `Salesperson`
  * Rename `EmployeeNationalIDAlternateKey` to `EmployeeID`
  * Rename `EmailAddress` to `UPN` (User Principal Name)
* T3: Configure the SalespersonRegion query
  * Rename the query and remove the Dim columns
* T4: Configure the Product query
  * Rename the query from `DimProduct` to `Product`
  * Find `FinishedGoodsFlag` column and select only `True`
  * Select only columns: ProductKey, EnglishProductName, StandardCost, Color, DimProductSubcategory
  * Expand `DimProductSubcategory` (since it has `Values` links)
    * Keep only `EnglishProductSubcategoryName` and `DimProductCategory`
    * Uncheck `Use Original Column Name as Prefix` or it will prefix:
      * `DimProductSubcategoryEnglishProductSubcategoryName`
      * Since there are no repeated columns, uncheck this option
  * Expand `DimProductCategory`
    * Keep only `EnglishProductCategoryName`
  * Rename columns
    * EnglishProductName to Product
    * StandardCost to Standard Cost (include a space)
    * EnglishProductSubcategoryName to Subcategory
    * EnglishProductCategoryName to Category
* T5: Configure the Reseller query
  * Rename query, columns, correct values in `Business Type`
* Other tasks highlights
  * Added M code to verify if a column has null values
  * Unpivot columns
    * When there are too many columns
    * Select the columns (not to unpivot)
    * Right click and `Unpivot other columns`
  * Create a date column from two columns with Year and MonthNumber
    * Add Column/Column From Example
    * Year has `2017` and `MonthNumber `7`
    * In the first cell of the new column enter `7/1/2017`
  * Multiply a column by 1,000
    * Select column
    * Transform/Standard/Multiply
    * Enter `1000`
  * Merge two tables
    * Go to one table
    * Home/Merge Queries
    * Top table, select column to match
    * Select bottom table and column to match
    * Select privacy as `Organizational`
  * Disable loading a query/table
    * Select query
    * In Query settings/All properties
    * Uncheck `Enable load to report`

Check your knowledge:
* What is a risk of having null values in a numeric column
  * Incorrect: That function `SUM` of data will be incorrect
    * `SUM` will ignore `NULL` values and calculate correctly
  * Correct: That function `AVERAGE` of data will be incorrect
    * `AVERAGE` takes the total and divides by the number of non-null values. Since `NULL` is equivalent to zero, the average will be different from the accurate average
* If you have two queries with different data but same column headers and you want to combine them use:
  * Append
* Which is not a best practice for naming convention?
  * Abbreviate column names


***

# Model data in Power BI

Sources:
* [Model Power BI](https://learn.microsoft.com/en-us/training/paths/model-power-bi/)
* [Model Data Power BI](https://learn.microsoft.com/en-us/training/paths/model-data-power-bi/)

## Describe PBI Desktop models
[Source](https://learn.microsoft.com/en-us/training/modules/dax-power-bi-models/)

**Intro**

Tasks in developing models:
* Connect to data
* Transform and prepare data
* Use DAX to define business logic (tables, columns, measures)
* Use roles to set data permissions with row-level security
* Publish the model to PBI


**Star schema design**

* `Fact tables`
  * Events about a business activity (sales, stock balance)
  * Many rows
  * It can be summarized (total sales)
  * Columns with dimension keys and numeric measure columns
* `Dimension tables`
  * Business entities (customer, supplier, date, product)
  * Fewer rows (compared to fact tables)
  * Used for grouping/filtering.
  * UID column and descriptive columns
* `Relationship`
  * 1 to many (dimension to fact)

See star schema model example in the AdventureWorks PBIX file [here](https://github.com/MicrosoftDocs/mslearn-dax-power-bi/raw/main/activities/Adventure%20Works%20DW%202020%20M01.pbix)

**Review the AdventureWorks model**

(This is not in the docs).

* Hide the PK in the dim tables and the fact table (FK) so they aren't shown in Fields
* Some Keys might be incorrectly configured to be summarized
* I initially thought that `Sales Order` should be decoupled to `Sales Order` and `Line Item`, since the design patterns of object oriented programming show the two objects in different classes.
  * However, from a data modeling perspective, aren't `Sales Order` and `Line Item`, business events? Therefore fact tables? You can't connect two fact tables in a star schema.
  * According to [this](https://www.sqlbi.com/articles/header-detail-vs-star-schema-models-in-tabular-and-power-bi/) post, the recommendation is to join `Sales Order` and `Line Item` into a table called `Sales`
  * Then the data model in AdventureWorks is incorrect since it shows a dimension table `Sales Order` and fact table `Sales`. Also, in the star model the relationship from Dim to Fact is 1 to *. In this data model it shows a 1 to 1 relationship.
  * Also, according to [this](https://learn.microsoft.com/en-us/power-bi/guidance/star-schema) doc on Microsoft about star schema, tables have to be normalized.
    * Sales table has to be normalized to show only keys from other tables
      * In AdventurWorks Sales table not sure why it has columns `Product Standard Cost`, `Unit Price`, and `Unit Price Discount Pct`, where these should be in the `Product` table

**Analytic queries**

Analytic query:
* Query that produces a result
* PBI visuals query the model using DAX

Analytic query phases:
1. Filter
   1. Slice/target specific data
   2. Done on entire report, page, or visual
   3. Also on RLS
2. Group
   1. Divide query into groups
3. Summarize
   1. Produce a single value with sum, count, others

**Configure report visuals**

Configure a visual during design:
1. Select visual
2. Map dataset fields to the visual
3. Configure mapped fields (rename, summarize or not)
4. Apply format options, labels, etc.

Workflow: Filter > Group > Summarize:
* Using AdventureWorks
* Add a stacked column visual
* Filter by Date/Fiscal Year/FY2020
* Group by adding Date/Month to X
* Summarize by adding Sales/Sales Amount to Y

`Fields` has three resources:
* Columns
  * Filter, group, summarize
* Hierarchy levels
  * Filter, group
* Measures
  * filter, summarize
    * Filter only when a parent Column filter is used
    * For ex:
      * Column `Month`
      * Measure `Sales Amount`
      * Filter with `is greater than`

## Choose a PBI model framework
[Source](https://learn.microsoft.com/en-us/training/modules/choose-power-bi-model-framework/)

**Intro**

* Frameworks for building data model
* Based on Azure Analysis Services (AAS) and SQL Server Analysis Services (SSAS)

**Describe PBI model fundamentals**

*Data model*
* Semantic representation of a schema
* In PBI it is the representation of all data sources into one model
* The model can be queried using analytic languages DAX or MDX
  * PBI uses DAX
  * Paginated reports and "Analyze in Excel" uses MDX

*PBI dataset*
* Develop a model in PBI, when published to a workspace, it is a dataset
* A dataset can also be a data source or a model in AAS or SSAS

*Analytic query*
* PBI sends an analytic query to the model when visualizing data
* The query has three phases: Filter, group, summarize
* Filter
  * Slicing
  * Applied to report, page, visual using a dim table column
  * It can apply RLS
  * Values not visible in result
* Group
  * Dicing results into groups
  * Values visible in result
* Summarize
  * Produces a single result with an aggregation like sum, min, max, etc
  * Created using DAX or from a data source fact table
* Example
  * Filter by year
  * Group by quarter
  * Summarize by total sales

*Tabular model*
* Consists of one or more tables of columns, relationships, hierarchies, calculations

*Star schema design*
* Classify model tables as dimensions or facts
* Dimensions
  * Dimensions have 1 to * relationship to the fact
  * Entities like products, people, companies
* Facts
  * Fact tables have FK columns (to the dimension tables) and numeric columns

*Table storage mode*
* Import (data is stored or cached in the model)
* DirectQuery (query to the data source, data not stored locally)
* Dual (PBI determines most efficient path)

*Model framework*
* Import model: Import storage
* DirectQuery: DirectQuery storage and belong to same source group
* Composite: More than one source group

**Determine when to develop an import model**

Benefits:
* Many data sources that can be integrated
* Query using DAX and M
* Model is cached in memory, fast performance
* Supports dim/fact tables

Limitations:
* 1GB compressed model in shared capacity
* 10GB+ compressed model in dedicated capacity
* Manual or scheduled refresh
  * Shared: 8 times per day
  * Dedicated: 48 times per day
* Large models can take a long time to refresh
  * Default is delete/insert all data
  * Alternatively use incremental partition refresh

Optimize data reductions:
* Remove unnecessary columns, rows
* Use numeric data types
* Use custom columns instead of calculated columns
* Group/summarize to narrow down the must have data
* Disable PQ query load and auto date/time
* Alternatively use DirectQuery

**Determine when to develop a DirectQuery model**

Benefits:
* Used for tables with DirectQuery storage and belong to same source group (Import or DirectQuery)
* Model large or fast-changing data sources
* Enforce source RLS (inherited from source with single sign-on)
* Use when data cannot be cached/exported for policy restrictions
* Create specialized datasets
  * Connect to dataset and convert to local model (original dataset is remote model)
  * Extend local model (dim, fact, modify/add columns)
  * Extensions become a composite model

Limitations:
* Not all data sources supported
* All PowerQuery M transformations not supported (pivot/unpivot)
  * Queries must translate to native queries at source
* Performance can be slower if source is not optimized (indexes, materialized views)
* Can impact source performance. Partner with DBO to review query process.

Optimize:
* Optimize data source
* DirectQuery user-defined aggregation tables
  * Sort of materialized views but in local or remote model
  * They can query a materialized view at source

**Determine when to develop a composite model**

Benefits:
* Design flexibility for import and DirectQuery
* Increase performance of DirectQuery with cached data
* In a remote model, extend with calculated columns/tables

Limitations:
* Import data source needs refresh and can get out of sync with DirectQuery
* Impact on performance when query uses both source groups
* Modifications to local model (downstream) can impact remote model (upstream)
* Relationships between Import and DQ are "limited relationships".
  * PBI might be unable to determine one side of the limited relationship

Optimize:
* User-defined or automatic Import aggregation tables (automatic is a premium feature)
* Set dual storage mode for tables
* In import model, set incremental refresh, get latest data using DirectQuery

**Choose a model framework**

Import:
* Most options, design flexibility, fast performance
* Apply data reductions to increase performance
* Cannot switch to DirectQuery
* Create hybrid dual storage tables for performance (PBI adds a partition for incremental refresh)

DirectQuery:
* Data source is too large and/or updates constantly
* Report is required in real time
* Use import aggregation tables in dual storage to improve performance
* Can switch to Import
* Create specialized models, extend remote model with local model (like OOP inheritance)

Composite:
* Increase performance of DirectQuery
* Fast query from Import
* Extend a dataset or AAS model

## Design a data model in Power BI
[Source](https://learn.microsoft.com/en-us/training/modules/design-model-power-bi/)

**Intro**

*Good data models:*

* Faster data exploration, simpler to build accurate reports
* Tables with PK, FK, relationships with different data sources

*Star schema:*

* Fact tables, dimension tables
  * Fact tables are larger
  * Dim tables have fewer unique values


**Work with tables**

* Fewer tables with simpler and user-friendly structure
* After PQ, in Model tab, `Ctrl+Click` any item to see its properties
* Change properties to simplify the model. It updates values in dataset
* Manage relationships with only one active per table

**Create a date table**

*Benefits:*

* Dim table with custom hierarchy than default
* Decouple date from fact and/or dim tables

*Three ways of making a date table:*

* `Source data`
  * Import date table from source if available
* `DAX`
  * Create a table with `Dates = CALENDAR(DATE(min-date), DATE(max-date))`
    * With explicity min/max date range
  * Create a table with `Dates = CALENDARAUTO()`
    * Auto generate range based on min/max dates from model
  * Add manual hierarchy or custom date-columns
    * `Year = YEAR(Dates[Date])`
    * `Month = MONTH(Dates[Date])`
    * `WeekNumber = WEEKNUM(Dates[Date])`
    * `DayOfWeek = FORMAT(Dates[Date], "DDDD")`
  * Create relationships between this and other tables
    * Go to Model
    * Manage Relationships
    * From Dates to Fact table
    * 1 to many
    * Select Date columns
* `PowerQuery`
  * Go to Transform data
  * Create a new blank query
  * `= List.Dates(#date(year,month,day), 365*10, #duration(1,0,0,0))`
    * `year,month,day` the min range like `2010,10,1`
    * `365*10` generates the max range with `365` days and `10` years
    * `#duration(1,0,0,0)` each value is `1` day, `0` hours, `0` minutes, `0` seconds
  * Or use `= List.Dates(Date.FromText("2010-10-1"), 365*10, Duration.FromText("1.0:0:0"))`
    * `Date.FromText("2010-10-1")` outputs to `#date(2010,10,1)`
    * `Duration.FromText("1.0:0:0")` outputs to `#duration(1,0,0,0)`
    * Whatever way is easier to remember
  * Go to transform/Conver to Table
  * Change type to Date
  * Add columns for year, month, day name
* Mark Date table
  * Go to Visual
  * Fields, right click Date table
  * Mark as date table
  * Choose Date column
* Create a Measure
  * For example in a `Sales` table, with either a total line or a qty * sales
  * `#Total Sales = SUM(Sales['Amount'])`
* Create a table visual
  * From Date table (Year, Month). From Order table (OrderQty)
  * From Measures (#Total Sales)

**Work with dimensions**

*Hierarchy dimensions*

* `Date`
  * Use the date hierarchy to filter by year, month, day, or other custom date format
* `Category/Subcategory`
  * For example a Product belongs to a category and subcategory
  * Or a person has a skill and subskill
  * In visual/fields
    * Right click a column to build a hierarchy
    * For example table Product, column Category
    * Right click Category
    * Click `New hierarchy`
    * Drag/drop Subcategory under this hierarchy
    * Add hierarchy to axis field and total sales in values
* `Parent-child Org Chart`
  * For example an org chart where a manager has managers and each has employees
  * In this example, there are 3 levels of management
  * Given that a person has an employeeID (both manager and employee)
  * Create a DAX `PATH` column of levels
    * This function only works on `Import` storage
      * Convert from `DirectQuery` to `Import`
      * Go to Model, click on the table, go to properties, advanced
      * If it recommends to change to `Dual`, it also won't work there
      * Change to `Import`
    * The column has the format `Level1-ManagerID | Level2 - ManagerID | Level3 - EmployeeID`
    * `Path = PATH(ID_ColumnName, Parent_ColumnName)`
    * Such as `Path = PATH(Employee[EmployeeID], Employee[ManagerID])`
  * Then flatten the levels with `PATHITEM` columns
    * `OrgLevel1 = PATHITEM(Employee[Path], 1)`
    * `OrgLevel2 = PATHITEM(Employee[Path], 2)`
    * `OrgLevel3 = PATHITEM(Employee[Path], 3)`
  * Then in Visual/Field create a hierarchy for Employee table
    * Create under column `OrgLevel1`
* `Parent-child Product Category`
  * (This is not in the docs)
  * With the default sample DB in Azure SQL Database (adventureworks)
  * There is a table `SalesLT ProductCategory`
    * There are three columns: `ProductCategoryID`, `ParentProductCategoryID`, `Name`
      * Example rows
        * `1, , Bikes`, `2, , Components`, `3, , Clothing`, `4, , Accessories`
        * `5,1, Mountain Bikes`, `6,1,Road Bikes`
    * Create a column to map the integer `ParentProductCategoryID` to a string value in `Name`
      * `ColumnName = LOOKUPVALUE(TableName[ColumnTarget], TableName[ColumnSource], [SearchValue])`
        * To shorten the names for documentation purpose only
          * Table `SalesLT ProductCategory` is `PC`
          * `CatID`, `ParentCatID`, `Name`
      * `ParentName = LOOKUPVALUE(PC[Name], PC[CatID], [ParentCatID])`
  * Then use `PATH` (DAX)
    * `Path = PATH(Child, Parent)` like:
      * `Path = PATH(PC[Name], PC[ParentName])`
      * Example output:
        * `Bikes`, `Components`, `Clothing`, `Accessories`, `Bikes | Mountain Bikes`, `Bikes | Road Bikes`
  * Then unpivot `Path` column into `Category` and `SubCategory`
    * `Category = PATHITEM(PC[Path],  1)`
    * `SubCategory = PATHITEM(PC[Path], 2)`
  * Go to `Report/Fields`
    * Under table `SalesLT ProductCategory`
    * Right click `Category`
    * Enter new hierarchy
    * On the `SubCategory` column, three dots, move to this hierarchy
    * It shows:
      * ParentCategory Hierarchy
        * Category
        * SubCategory
    * Create `Stacked bar chart`
      * Move to Y axis the whole hierarchy
      * Move to X axis a `Line Total` from a `Sales` table
      * It shows `Category vs Total`
      * On the visual use the double arrow down to go to the next hierarchy level
      * It shows `SubCategory vs Total`

*Role-playing dimensions*

* A dim table can have active relationships with more than 1 fact table
* A date dim table can be related to factSales and factOrder

**Define data granularity**

* Partner with stakeholders to define granularity of reports
* For example
  * A company has 1000 refrigerated trucks that report their temperature
  * How often to capture the data, hourly, daily average, or min/max limits
  * Granularity affects speed of reporting

*Change data granularity to build a relationship between two tables*
* Given a dataset with tables `Budget`, `Sales`, and `Date`
  * `Budget` has: `Amount`, `Month`, `Value`, `Year`
    * No date column
    * No relationship with `Date` table
  * `Sales` has: `OrderDate`, `Sales`
  * `Date` is a generated date table: `Date`, `Month`, `Quarter`, `Year`
* Create a table report by `Year`, `Quarter`, `Month`, `TotalSales`, `BudgetAmount`
  * In `Budget` create a date column using `Month` and `Year`
    * `Month` and `Year` must be formatted as text
    * In PowerQuery `Date = Date.FromText([Month]&"-"&[Year])`
    * Format the `Date` column as data type Date
  * Connect this date with the `Date` table
  * Create a measure `TotalSales = SUM(TableName[SubTotal])`
  * Create table report

**Work with relationships and cardinality**

* Ideal relationships are 1 to many. Unidirectional From Dim to Fact
* A 1 to 1 relationship might be simplified to 1 table
  * Such as Table `ProductID` and Table `Product` with a 1-1
* Avoid Many to Many as it might cause ambiguity
  * When creating a many-many relationship
  * PBI shows a warning, make sure that each column doesn't have unique values
  
*Cross-filter direction*

* Unidirectional from Dim to Fact
* With bidirectional filtering can be done from each side, however, lower performance

*Cardinality and cross-filter*

* For 1-1, only option is bi-directional, filtering to one distinct value
* For Many-Many, choose uni or bi-directional
  * With bi-directional it will create multiple paths among the tables
  * The result of might be different by filtering from each side

**Resolve modeling challenges**

* Circular dependencies can exist among tables
* A calculated column depends on other columns
  * Table `Sales`
  * Column `TotalSales = Qty * Price`
* A column in a table might depend on columns in other tables
  * A table `dSalesPerson` 1-* with `fSales` *-1 with `dCustomer`
  * Changing a Customer results in a change in Sales and then a change in SalesPerson

**Exercise: Model data in PBI, Part 1**

*Lab Story*

1. Prepare Data in Power BI Desktop
2. Load Data in Power BI Desktop
*3. Design a Data Model in Power BI*
4. Create DAX Calculations in Power BI Desktop
5. Create Advanced DAX Calculations in Power BI Desktop
6. Design a Report in Power BI Desktop
7. Enhance a Report in Power BI Desktop
8. Perform Data Analysis in Power BI
9. Create a Power BI Dashboard
10. Enforce Row-Level Security

*Ex1: Create Model Relationships*

* Active relationships propagate filters
* Inactive relationships can exist when there are many relatioship paths

*Ex2: Configure Tables*

* When creating hierarchies in the Model view
  * Click on a column that belongs to the hierarchy (outside the grouping)
  * Use `Data category`
    * It provides hints to the report designer
* In Model view, select column, Properties
  * Use `Description` which is revealed in a tooltip when hovering over the field
  * Use the `Advanced/Summarize by` to `Average`
    * By default, numeric columns summarize by `Sum`
    * If the column represents a rate use `Average`
* Hide columns
  * If they are used only for relationships
  * Or used in row-level security
  * Or calculation logic

*Ex3: Review the model interface*

* Disable auto date if the FY is different than the default
  * By default the FY is set to Jan 1
  * To disable this behavior go to `File/Options and Settings/Options/Current File/Data Load`
  * Then uncheck `Auto date/time`
  * The default Date hierarchies are removed.

*Ex4: Create quick measures*

* Right-click a table, then `New quick measure`
* Use the measure tools to modify the format
* When a table has more than one path to the Fact table
  * It will filter by the path with the fewer tables
  * If using a different path
  * Select the default path (relationship) and set to inactive
  * Change the direction of the path if it doesn't flow towards the Fact table


## Intro to creating measures using DAX
[Source](https://learn.microsoft.com/en-us/training/modules/create-measures-dax-power-bi/)

**Intro to DAX**
**Understand context**
**Use the Calculate function**
**Use relationships effectively**
**Create semi-additive measures**
**Exercise: Intro to DAX**
**Work with time intelligence**
**Exercise: Time intelligence and measures in DAX**

## Add measures to PBI desktop models
[Source](https://learn.microsoft.com/en-us/training/modules/dax-power-bi-add-measures/)

## Add calculated tables and columns to PBI desktop models
[Source](https://learn.microsoft.com/en-us/training/modules/dax-power-bi-add-calculated-tables/)

## Optimize a model for performance
[Source](https://learn.microsoft.com/en-us/training/modules/optimize-model-power-bi/)

***

# Visualize data in Power BI

Source [here](https://learn.microsoft.com/en-us/training/paths/visualize-data-power-bi/)

## Work with PBI visuals
## Create a data driven story with PBI reports
## Create dashboards
## Create paginated reports

***

# Data analysis in Power BI

Source [here](https://learn.microsoft.com/en-us/training/paths/perform-analytics-power-bi/)

## Perform analytics
## Work with AI visuals

***

# Manage workspaces and datasets in Power BI

Source [here](https://learn.microsoft.com/en-us/training/paths/manage-workspaces-datasets-power-bi/)

## Create and manage workspaces
## Manage datasets
## Implement row-level security
