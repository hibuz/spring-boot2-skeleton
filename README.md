# 🌱 Spring Boot 2.0 Skeleton Project

## Step 1. Create Initial Project
![spring-initializr](.github/spring.svg)
> [Project URL](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=17&groupId=com.hibuz&artifactId=account&name=spring-boot-skeleton&description=Demo%20project%20for%20Spring%20Boot&packageName=com.hibuz.account&dependencies=native,lombok,devtools,web,security,data-jpa,h2,validation,restdocs)

Downgrade spring boot to version 2, add maven wrapper

## Building for production

### Packaging as jar

To build the final jar and optimize the example application for production, run:

```
./mvnw clean package
```

To ensure everything worked, run:

```
java -jar target/*.jar
```

Then navigate to followings below in your browser.
- http://localhost:8080/account/swagger-ui.html


## References
- [GitCommitEmoji.md](https://gist.github.com/parmentf/035de27d6ed1dce0b36a)