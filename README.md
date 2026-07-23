# Maven Spring Boot Template

Multi-module Maven project including the **Maven 3.9.9** wrapper, configured for **Java 21**, with a simple example using **Spring Boot**.

## Modules

**root**: Root **pom.xml**: lists the modules, configures **SonarQube** and **JaCoCo**.

**maven-spring-boot-template-dependencies**: **BOM** (Bill of Materials) centralizing dependency and plugin versions.

**maven-spring-boot-template-parent**: Parent configuring the **Java** version and encoding, inheriting from **maven-spring-boot-template-dependencies**.

**maven-spring-boot-template-internal-parent**: Utility parent inheriting from **maven-spring-boot-template-parent**, configuring **flatten-maven-plugin** in **OSSRH** mode.

**maven-spring-boot-template-common** and **maven-spring-boot-template-cli**: Application modules, both inheriting from **maven-spring-boot-template-internal-parent**.

**maven-spring-boot-template-tests**: Module for aggregating test and coverage results.

## Useful Commands (Maven)

- `./mvnw clean` : removes generated files
- `./mvnw compile` : compiles the project
- `./mvnw test` : runs unit tests
- `./mvnw verify` : runs tests and generates a coverage report in **maven-spring-boot-template-tests/target/site/jacoco-aggregate**
- `./mvnw install` : installs the project in the local **Maven** repository
- `./mvnw spring-boot:run -pl maven-spring-boot-template-cli` : runs the command-line application
- `./mvnw versions:display-dependency-updates` : lists available dependency updates
- `./mvnw versions:display-plugin-updates` : lists available plugin updates

## Adding a Module

To add a new module to the project:

1. Add the module in the root **pom.xml**.
2. Declare its dependency in the **dependencyManagement** block of the **maven-spring-boot-template-dependencies** **pom.xml**.
3. Create the module with **maven-spring-boot-template-internal-parent** as its parent.
4. Reference the module in the **maven-spring-boot-template-tests** **pom.xml** so its coverage is aggregated.

## Adding a Dependency

Edit the **dependencyManagement** section of the **maven-spring-boot-template-dependencies** **pom.xml** to declare the new dependency, then
reference it in the modules that need it.

## Adding a Plugin

Same approach as for a dependency: declare the plugin in the **pluginManagement** section of the **maven-spring-boot-template-dependencies** **pom.xml**, then reference it in the relevant modules.

## SonarQube Configuration

1. Set the **SONAR_TOKEN** environment variable with your authentication token.
2. Update the **sonar.projectKey** property with your **SonarQube** project identifier.
3. Run the analysis with the following command (replacing `<<url_server>>` with your server URL):

```
./mvnw clean verify sonar:sonar -Dsonar.host.url=<<url_server>>
```
