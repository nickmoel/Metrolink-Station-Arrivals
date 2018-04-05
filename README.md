
# Mario/ STL METROLINK STATION NEXT ARRIVAL TIME CHECKER v0.7.5

![Alt Text](https://i.imgur.com/8FgOAd5.gif)

Launch Code Self guided Java Exercises PSET7 v0.7.5. Transitioning from JDBC to HIBERNATE.This final Problem uses my solution for PSET6 as a base.

Run the program, pick the METROLINK STATION that you want the next arrival time for and that's it!

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Installing

![My image](https://i.imgur.com/cZ1E7M8.jpg)Download the .ZIP file containing the Project. Unzip where you prefer. Using IntelliJ, open a new project and find the pom.xml in the main metrolink folder and open as a new project. 

![My image](https://i.imgur.com/UIFmtYx.jpg)


## Running the tests
![Alt Text](https://i.imgur.com/lOo1WVX.gif)
![Alt Text](https://i.imgur.com/cYlTgF1.gif)
### Breaking down the tests
What is mocking?
Mocking is creating objects that mimic the behavior of real objects.

By using Mockito, you feed the tested methods with your own substituted mock doubles. Making the test dependent of the database. With the first set of tests, I made a mock double station with the info i wanted it to have.

The second test just uses assertThat() to check that the user input validation method is working correctly.


## Built With

* Maven for Dependency Management
* Spring Framework for Dependency Injection
* Hibernate for mapping to the database
* SQLite for database management
* JUnit for intial unit testing
* Mockito for using mocking to make the unit tests quick

## Versioning

For the versions available, see the [tags on this repository](https://github.com/nickmoel/mario/tags). 

## Authors

* **Nicholas Moeller** 


