# EmployeeMicroservice

employee-microservice  
 └── src  
     └── main  
         ├── java  
         │     └── com.example.employee  
         │           ├── Employee.java  
         │           ├── EmployeeController.java  
         │           ├── EmployeeService.java  
         │           ├── EmployeeRepository.java  
         │           └── EmployeeMicroserviceApplication.java  
         │  
         └── resources  
               ├── application.properties  
 └── pom.xml  

Employee:
Long id,
String name,
String department,
double salary

Repository:
using JpaRepository

Service:
getAllEmployees
getEmployeeById
addEmployee
updateEmployee
deleteEmployee

Controller:
APIs:
"/all"
"/get/{id}"
"/add"
"/update/{id}"
"/delete/{id}"

Application:
Run application
Run command line to add dummy data


Before running code 
clean install on maven and use spring-boot:run
on post man use http://localhost:8080/employees/ then the respective api
