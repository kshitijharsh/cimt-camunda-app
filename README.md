# Spring Boot with Camunda

## Description
Texfreigabe-Project is a Spring Boot application designed to manage a text approval workflow using Camunda 7. 
This project involves a series of tasks to check a given text for bad words, display these words to a user, and provide options to either send the text forward or stop the process.

## Prerequisites

- Java JDK 17
- Maven
- Spring Boot (project with camunda archetype)
- Camunda Modeler (for modeling BPMN workflows)

## Installation
- Clone this repository
- mvn clean install
- run this command inside the project directory : mvn spring-boot:run

## Project Structure

The project is structured as follows:

- **src/main/java**: Contains the Java source files.
  - **com.cimt.workflow**: The base package for the project.
    - **Java delegate**: used to implement the logic for the service task.


- **src/main/resources**: Contains the resources for the project.
  - **static**: Contains static files (forms).
  - **application.yaml**: Configuration file for the Spring Boot application.
  - **.bpmn**: Contains the BPMN model created using Camunda Modeler.


## Author

Kshitij Harsh