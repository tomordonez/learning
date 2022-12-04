# Learning

This repo contains a summary of courses and code I am learning outside Gatech.

**In Progress**

* LIL: Java Essential Training (took it in 2021, reviewing in 2022)

**Backlog**

*Java*
* LIL: Java data structures and algorithms
* LIL: Java and Docker
* LIL: Java Objects and APIs
* LIL: JUnit
* LIL: Spring Boot
* LIL: Java design patterns
* LIL: React and Spring

*Data Engineering*
* LIL: Python with PyCharm
* LIL: Data engineering foundations
* LIL: Apache Spark Essential Training
* LIL: Introduction to Spark SQL and DataFrames
* LIL: Apache PySpark by Example
* LIL: Big data analytics with Hadoop and Apache Spark
* LIL: Architecting big data applications: Batch mode application engineering
* LIL: Architecting big data applications: Real time application engineering
* LIL: Stream processing design patterns with spark
* LIL: Cloud Hadoop: Scaling Apache Spark
* LIL: Advanced Snowflake
* LIL: Learning Terraform

*AWS*
* Y: AWS Certified Cloud Practitioner
* LIL: Learning AWS for Developers
* LIL: Amazon Web Services: Data Analytics
* LIL: Amazon Web Services: Data Services

*DevOps*
* LIL: Learning Kubernetes

*Analytics*
* LIL: Statistics Foundations
* LIL: Looker Studio for Beginners
* LIL: Tableau Essential Training
* LIL: Master SQL for Data Science

*JS*
* LIL: JavaScript Essential Training
* LIL: Learning the JavaScript Language
* LIL: ReactJS Essential Training
* LIL: ReactJS Building an Interface
* LIL: Creating and Hosting a Full Stack Site
* LIL: React Hooks
* LIL: Building Modern Projects with React
* LIL: React Design Patterns
* LIL: React Software Architecture
* LIL: React Authentication

**Done**
* LIL: IntelliJ Refresher

## Legend

* LIL: Linkedin Learning
* ACG: A Cloud Guru
* Y: Youtube
* W: Web Tutorial

## Documenting

I didn't want to create a repo for each course. Instead, documenting all my learning in one big repo following this directory structure:

    Learning
        Course 1
            Code
            Readme
        Course 2
            Code
            Readme

**Branch name: A course has sections that don't build upon each other**

I took Java Essential Training in 2021 and I was reviewing it again in 2022. The course has sections, each sections has videos, and each of these videos don't build upon each other, but are self-contained mini-tutorials.

This is the directory structure of the course:

    ...
    5. Manage Program Flow
        Evaluate conditions with if-else
        Evaluate conditions with switch-case
    
    6. Debugging and Exception Handling
        ...

I found it complicated to follow a branch convention like `dev`, since the examples don't build on each other. I was using the branch `Java-ET` and creating a commit per section. However, reviewing the merged commits, it was confusing seeing all the deletions and additions, which basically was deleting all the previous code and adding the new one. 

I also found some videos a bit too trivial, since I was reviewing the course again, sometimes a bit outdated, without data structures, OOP, or tests. For some mini tutorial videos I added my own research. This turned to creating a branch naming convention using a git directory structure like this:

    course-name/section-number/[video | research]/section-subtopic

Where `video` follows the exact tutorial and `research` adds my own implementation of that tutorial. 

Then branch names could be:

    Java-ET/5/video/if-else
    Java-ET/5/video/switch
    Java-ET/5/research/load-csv

This would obviously create a lot of branches. If the course has 5 sections with 5 videos each. That's 25 branches. Each branch (with smaller commits) would need to be pushed and merged.

**Branch name: A course has sections that build upon each other**

If the sections build upon each other, it could be as simple as a `dev` branch. Or follow a similar convention that doesn't require `section-subtopic`.

    course-name/section-number/video
    course-name/section-number/research/short-description

This would create fewer branches where a commit is a video in each section. Only use `short-description` for a branch that deviates from the videos.

**CLI**

    (main)$ git checkout -b branch-name 
    (react-BMP)$ git add .
    (react-BMP)$ git commit -m "a message..."
    (react-BMP)$ git push -u origin branch-name
    (react-BMP)$ git checkout main
    (main)$ git pull

**IntelliJ**

* Bottom right, click on `main`, click New Branch
* Make changes
* Left margin, click on tab `commit`
* Select files under Changes and Unversioned files
* `Ctrl+K` or right click select Commit
* Enter a message
* Top menu Git/Push
