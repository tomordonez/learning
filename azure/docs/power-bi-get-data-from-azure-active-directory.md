# Power BI Get Data From Azure Active Directory

## If PBI was already registered as an application in AAD

* Go to AAD / Manage / App Registrations
* Go to the application
* Get the Client ID
* Go to Manage / Certificates & Secrets
* Get the Secret value

## If you need to create the PBI application in AAD

Similar to [this](https://learn.microsoft.com/en-us/purview/create-service-principal-azure) Microsoft doc. Creating an application also creates a service principal.

* Go to AAD / Manage / App Registrations / New registration
* Enter a name for your Power BI application, e.g. `PowerBI`
* Select `Accounts in this org directory only`
* Click `Register`
* The application is listed in the "App registrations" section.
* Get the "Application (client) ID".

Get the Secret value

* Go to Manage / Certificates & Secrets
* Under "Client secrets," click on "New client secret"
* Enter a description, e.g. `Secret for service principal`, select the expiration period, and click "Add"
* The generated client secret will be displayed.

## Grant permissions to the application

* Go to AAD / Manage / App Registrations
* Selected the registered Power BI application
* Click API permissions / Add a permission
* Choose Microsoft Graph
* Select the permissions. For example "User.Read.All"
* Click "Add permissions"

## Connect to Azure AD from PBI

In PBI desktop, replace `{your_tenant_id}` with your Azure AD tenant ID (or your tenant's name `yourorg.onmicrosoft.com`)

* Get data
* Web
* From web `https://login.microsoftonline.com/{your_tenant_id}/oauth2/token`
* Auth method `OAuth2`
* Client ID: Enter application client ID of registered application
* Client Secret: Enter Client Secret from service principal
* Resource URL: `https://graph.microsoft.com`
* Grant type: `Password` or `Web`
* User: Your Azure AD username
* Pwd: Your Azure AD pwd
* OK to connect and fetch the access token using the service principal to authenticate with MS Graph API

## Get list of users from Azure AD

    let
        Source = Json.Document(Web.Contents("https://graph.microsoft.com/v1.0/users")),
        users = Source[users],
        emails = Table.SelectColumns(users, {"displayName", "mail"})
    in
        emails