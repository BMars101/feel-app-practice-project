# feel-app-practice-project
# The Feel App
## Assignment Description
This project is based off of a group project that was created in LaunchCode's LiftOff program. The idea came from 
a group brainstorming session. After the program completed, I wanted to take the opportunity to implement different features such as utilizing 
the LocalDate object in Java to track entries.
[Project Outline Assignment](https://education.launchcode.org/liftoff/modules/assignments/project-outline)

### Overview
We are building a tool in which through small, easy to follow steps, we encourage people to take a little time for themselves. 
To take care of their body and mind with a space to lay out their thoughts and make sure they are staying hydrated. 
It is from these two humble steps that we hope to enable people to take further steps toward a healthier, happier life.

### Features
Users will be able to:
 * Register/Login
 * Create/Edit
 * Calculate their water intake needs
 * Track their daily water intake
 * Track their mood
 * View their past logs in a calendar format
### Technologies
 * Java
 * Spring Boot
 * Thymeleaf
 * MySQL
 * Hibernate
### What I'll Have to Learn
How to manage authentication and authorization for an app that has features before signing in a after signing in. How to use the LocalDate Java object. 
### Improvement
* Send user notifications when not loggin water consumption regularly
* Implement Spring Security
* Add more content to home page layout
* Implement a chart or calendar to have a visual of water intake over time
# To Test The Project
### Requirements
* JDK Version 11
* IntelliJ IDEA CE
*  MySQL Workbench
### Instructions
* Ensure MySQL is running
* Create a new schema and corresponding administrator in MySQL
* Open IntelliJ - If a project is open, select File and Close Project
* Select Get From VCS and copy this repository's URL, past in URL field in IntelliJ and select Clone
* The project should open and run build
* Add MySQL admin password to application.properties file 
* Select Gradle on the left
* Open Tasks > application > bootRun
* Navigate to localhost:8080 in browser
