## Golf Club Service (GCS)

Golf Club Service is a spring boot based microservice, which helps a golf club to manage club membership.
 
GCS serves basic CRUD operations and convenient query methods build on Spring Data JPA’s JpaRepository.

GCS data is stored in `in-memory H2 Database`, can easily extend to any SQL DB, e.g. Postgres, MySql, etc...

Data Sample: https://www.pgatour.com/stats/stat.186.html

### Technologies based on

- Java 11+
- Maven 3.8.x+
- Spring Boot 2.6.6+
- lombok 1.18.22+ 
- H2 Database 2.1.214+

### MVC Structure
All Classes are autowired by Spring 2.5+ annotations-driven Dependency Injection

- `Member` data model class corresponds to entity and table `MEMBERS`.
- `MemberRepository` is an interface that extends JpaRepository for CRUD operation. 
- `MemberService` is an interface that provide controllers with logically services.
- `MemberController` exposes Rest APIs which has request mapping methods.
- `Configuration` for Spring Datasource, JPA & Hibernate in `application.yml`.

### Run locally 
```
mvn spring-boot:run
```

### Remote Debugging
```
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```

### Test By curl
```
- curl -X GET http://localhost:8080/v1/members - returns all club members.
- curl -X GET http://localhost:8080/v1/members/id/tigerwoods - returns a single member by ID.
- curl -X GET http://localhost:8080/v1/members/country/usa - returns all members from a country
- curl -X POST http://localhost:8080/v1/members -d '{member data}'
- curl -X PUT http://localhost:8080/v1/members -d '{member data}'
```
