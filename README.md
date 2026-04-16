# Experiment 6: JPA & Hibernate with MySQL

##  Objective

To configure JPA and Hibernate with MySQL to model entity relationships and execute queries including filtering and data retrieval.

---

##  Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* MySQL Database
* Maven

---

##  Project Structure

```
src/
 └── main/
      ├── java/com/exp6/jpademo/
      │    ├── controller/
      │    │     └── MainController.java
      │    ├── entity/
      │    │     └── Product.java
      │    ├── repository/
      │    │     └── ProductRepository.java
      │    └── JpaDemoApplication.java
      └── resources/
           └── application.properties
```

---

##  Configuration

### application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/exp6_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

---

##  Database Setup

```sql
CREATE DATABASE exp6_db;
USE exp6_db;

INSERT INTO product(name, price)
VALUES ('Phone', 20000),
       ('Laptop', 50000);
```

---

##  Entity Class

```java
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
}
```

---

##  Repository (Custom Query)

```java
@Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
List<Product> findByPriceRange(@Param("min") double min,
                              @Param("max") double max);
```

---

##  API Endpoints

###  Get All Products

```
GET /api/products
```

###  Filter Products by Price

```
GET /api/products/filter?min=10000&max=30000
```

---

##  Sample Output

```json
[
  {
    "id": 1,
    "name": "Phone",
    "price": 20000.0
  }
]
```

---

##  How to Run

```bash
git clone https://github.com/YOUR_USERNAME/jpa-demo-exp6.git
cd jpa-demo-exp6
mvnw.cmd spring-boot:run
```

Then open:

```
http://localhost:8080/api/products
```

---

##  Features Implemented

* Database connectivity using MySQL
* JPA entity mapping
* Repository using Spring Data JPA
* Custom JPQL query
* REST API for data retrieval
* Filtering using query parameters

---

##  Conclusion

This experiment demonstrates how to integrate Spring Boot with JPA and Hibernate to perform database operations efficiently and implement custom queries for filtering and data analysis.

---


