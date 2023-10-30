<h1 align="center">Spring Boot Project</h1>

<p align="center">
  This project uses the following...<br>
 
  <ul>
    <li>Java version 17.0.2</li>
    <li>Spring Boot version 3.1.5</li>
    <li>Spring Tool Suite 4 version 4.20.0</li>li
    <li>MySQL Workbench version 8.0</li>
    <li>Postman version 10.19.10</li>
  </ul>
</p>


<h3 align="center">Setting up the SQL connection</h3>

The SQL connection can be altered in the `application.properties` file located in the `Spring Boot>demo-6>src>main>resources` directory if you want to use another database type.<br><br>
In the `application.properties` file on line 5 `spring.datasource.url=jdbc:mysql://localhost:3306/library` the connection's protocol, host and database can be changed.<br><br>
If the `application.properties` connection protocol is changed then line 2 `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver` will also need to change accordingly.<br><br>
You may also change lines 8 and 9 `spring.datasource.username=root` and `spring.datasource.password=testingpassword` to your database connection's username and password<br><br>

<h3 align="center">Setting up Postman for testing the API</h3>

The Postman json file located in the `Spring Boot>` directory is named `New Collection.postman_collection.json`<br><br>
This file can be imported into the Postman application by entering a *Workspace* and selecting *Import*<br><br>

<h3 align="center">Running the Java Application</h3>
The project can be imported into the Spring Tool Suite IDE by selecting *File* > *Import...* > *Maven* > *Existing Maven Projects* and selecting the project
The application can be run in the Spring Tool Suite IDE by right clicking on the project and selecting *Run as* > *Java Application*




