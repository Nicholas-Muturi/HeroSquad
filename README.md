# Hero Squad
##### By Nicholas M

## Description
Hero Squad is a project that allows users who interact with it to create heroes and squads/alliances that contain a particular number of heroes such as Marvel's Avengers or DC's Justice League. Heroes can be affiliated with only 1 squad at a single time, therefore if the hero was to switch to another group, their name should not be present in the previous squad that they were in

##### Hero & Squad Properties
During the creation of a new hero/squad, these are the traits that they should contain.

| Hero properties  | Squad properties |
| :----: |:----:|
| Name | Name |
| Age | Cause |
| Strength | Hero Member(s) |
| Weakness | |
| Affiliated Squad | |

## Prerequisites
* Java JDK
* Gradle
* Git
* Some prior knowledge of Java
* Some prior knowledge of Spark framework
* (optional) Java IDE

## Built With
* HTML + Handlebars/Moustache
* Css
* Java
* Gradle
* Spark
* Junit

## Setup Guide
+ Run `java --version` to check which version of java you have installed in your device. If you have java installed, you should see an output slightly similar to the one below...  
_**openjdk 10.0.2 2018-07-17**_  
_**OpenJDK Runtime Environment (build 10.0.2+13-Ubuntu-1ubuntu0.18.04.4)**_  
 ... then you need to install java by running this : `sudo apt install default-jre`

+ Clone the repository into a desired folder by running the following link in your terminal: `https://github.com/Nicholas-Muturi/HeroSquad.git`

###### (for users with an IDE such as IntelliJ)
+ Open the project using the IDE you have installed
+ Build and Run the project.

###### (for users without an IDE)
+ Navigate to the folder containing the project
+ Build the gradle by running: `gradle build`.
+ Compile the code by running: `gradle compileJava`
+ Navigate to the App class file located at build/classes/java/main and run: `java App`.

## Live Link
[Visit the live link](https://hero-squad-0047.herokuapp.com)

## Known Bugs
No bugs have been encountered yet.

## License
This projects has a MIT License [found here](LICENSE)