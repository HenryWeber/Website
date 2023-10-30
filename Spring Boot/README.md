<h1 align="center">Spring Boot Project</h1>

<p align="center">
  This project uses the following...<br>
 
  <ul>
    <li>Java version 17.0.2</li>
    <li>Spring Boot version 3.1.5</li>
    <li>MySQL Workbench version 8.0</li>
    <li>Postman version 10.19.10</li>
  </ul>
</p>
`application.properties`

<h3 align="center">Setting up the SQL connection</h3>
<p align="center">
The SQL connection can be altered in the `application.properties` file located in src>main>resources directory if you want to use another database type.<br>
In the `application.properties` file on line 5 `spring.datasource.url=jdbc:mysql://localhost:3306/library` the connection's protocol, host and database can be changed.<br>
If the `application.properties` connection protocol is changed then line 2 `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver` will also need to change accordingly.<br>
</p>

