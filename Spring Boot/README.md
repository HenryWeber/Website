<h1 align="center">Spring Boot Project</h1>

<p align="center">
  This project uses the following...<br>
 
  <ul>
    <li>Java version 17.0.2</li>
    <li>Spring Boot version 3.1.5</li>
    <li>MySQL Workbench version 8.0</li>
    <li>Postman version 10.19.10 (Optional)</li>
  </ul>
</p>


<h3 align="center">Setting up the SQL connection</h3>

The SQL connection can be altered in the `application.properties` file located in `demo-6>src>main>resources` directory if you want to use another database type.<br><br>
In the `application.properties` file on line 5 `spring.datasource.url=jdbc:mysql://localhost:3306/library` the connection's protocol, host and database can be changed.<br><br>
If the `application.properties` connection protocol is changed then line 2 `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver` will also need to change accordingly.<br><br>
You may also change lines 8 and 9 `spring.datasource.username=root` and `spring.datasource.password=testingpassword` to your database connection's username and password<br><br>

<h3 align="center">Setting up the SQL connection</h3>

