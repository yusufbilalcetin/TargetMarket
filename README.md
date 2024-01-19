# TargetMarket

# Running Automated Tests for TargetMarket Application
To ensure consistent code style and proper execution of tests, follow these
steps:
1. Clean and Build the Project:
- Run the command: `mvn clean install`
- This command will clean the target directory and build the project.
2. Apply Code Formatting:
- Run the command: `mvn spring-javaformat:apply`
- This step is essential if you are using Spring and ensures that the
code follows the standard Spring format.
3. Execute Tests:
- Run the command: `mvn test`
- This will execute the automated test suite configured in your project.

  Please make sure to run these commands in the root directory of the project
where the `pom.xml` file is located.
