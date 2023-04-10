# Using Azure PowerShell

Why learn PowerShell when Azure has Linux Bash?

The main reason is that a lot of answers in the Microsoft Azure forums are in PowerShell.

On Azure, go to the top right and click on the shell icon. Select PowerShell.

## You have no storage mounted

If you get this message: `You have no storage mounted`

"Azure Cloud Shell requires an Azure file share to persist files. This will create a new storage account for you and this will incur a small monthly cost."

Click on `Create storage` and wait a few seconds

## Type help

In the prompt type `help` for a short documentation.

"PowerShell in Azure Cloud Shell comes pre-installed with tools such as Vim, Nano, Git, Python, and SQLCMD.

Full doc about PowerShell in Azure [here](https://aka.ms/cloudshell/powershell-docs)

Examples:

* `Get-CloudDrive`: List information of the Azure File storage share that is mounted as `CloudDrive`.
* `Dismount-CloudDrive`: Dismounts Azure File storage share from the current session
* `Get-AzCommand`: Gets all the context specific Azure commands when invoked from Azure PowerShell drive
* `Invoke-AzVMCommand`: Runs commands on Azure VMs

Press `q` to quit this help.

In the shell. Start typing a command and it will show a semi-transparent auto-completion.

Start typing `Get-` and it might show `Get-AzSubscription`. Click `tab` to auto-complete.

Typing `Get-AzCommand` will show a list of all available commands.

## Linux commands don't translate

I wanted to see the number of available commands. In Linux this would be something like

    Get-AzCommand | wc -l
    
However, there is no such thing as `wc` (word count) in PowerShell.

The closest command is:

    (Get-AzCommand).length
    
Which results in `5002`

## Change the timezone of an Azure VM

(This is for reference only since the command to change the timezone doesn't work)

I got confused reading the logs of a VM that I use to run PowerBI desktop. All the timestamps were in UTC. I wanted to change this to central time.

As seen in the Microsoft forum [here](https://learn.microsoft.com/en-us/answers/questions/790452/azure-vm-displaying-incorrect-time).

Go to the VM and open the cloud shell.

See the current time zone:

    Get-TimeZone

Output:

    Id                         : UTC
    HasIanaId                  : True
    DisplayName                : (UTC) Coordinated Universal Time
    StandardName               : Coordinated Universal Time
    DaylightName               : Coordinated Universal Time
    BaseUtcOffset              : 00:00:00
    SupportsDaylightSavingTime : False

Get a list of available time zones

    Get-TimeZone -ListAvailable

There are too many results. Can I grep the results similar to Linux? I thought the answer in the forum was not very user friendly. Lost me at `{$`.

    Get-TimeZone -ListAvailable | where ({$_.Id -like "India*"})

You can use other commands that use more natural language. Use wildcards to find the word within a sentence:

    Get-TimeZone -ListAvailable | Where-Object -Like "*Chicago*"

Output:

    Id                         : America/Chicago
    HasIanaId                  : True
    DisplayName                : (UTC-06:00) Central Time (Chicago)
    StandardName               : Central Standard Time
    DaylightName               : Central Daylight Time
    BaseUtcOffset              : -06:00:00
    SupportsDaylightSavingTime : True

**Changing the timezone doesn't work**

The forum said to use this syntax. However, this didn't work.

    Set-TimeZone -Id "America/Chicago"

It said "Set-TimeZone: The term 'Set-TimeZone' is not recognized as a name of a cmdlet, function, script file, or executable program. Check the spelling of the name, or if a path was included, verify that the path is correct and try again"