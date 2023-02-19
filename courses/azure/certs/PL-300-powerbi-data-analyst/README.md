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
  * Cardinality: `1:1`

Pivot column
* In the case of flat files with a lot of data
* Do a quick EDA with an aggregation (Pivot)
* In Power Query Editor/Transform/Pivot Column
* Select the Values column, for example, `Subcategory Name`
* Select Aggregate, for example, `Count(All)`
  
Apply changes:
* Select `Close & Apply`

**Simplify the data structure**
**Evaluate and change column data types**
**Combine multiple tables into a single table**
**Profile data in PBI**
**Use Advanced Editor to modify M code**
**Exercise: Load data in PBI Desktop**

***

# Model data in Power BI

Source [here](https://learn.microsoft.com/en-us/training/paths/model-power-bi/)

## Design a data model in Power BI
## Intro to creating measures using DAX
## Optimize a model for performance

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
