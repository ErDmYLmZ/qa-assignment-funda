# Funda Automated Smoke Test Suite
---
This repository contains an automated smoke test suite for the Funda.nl. These tests are designed to provide rapid feedback on the health of Funda's core functionalities, ensuring that critical user journeys are operational. They are *not* intended to be exhaustive functional tests, but rather high-level checks to confirm that the most essential parts of the application are working.

## Test Scope and Coverage
This smoke test suite covers the following key areas of the Funda.nl:
* **Searching for Buying Properties:** Verifies that users can search for properties available for purchase.
* **Searching for Renting Properties:** Confirms the functionality of searching for rental properties.
* **User Login:** Checks the accessibility and basic functionality of the user login process.
* **Displaying the Map:** Ensures that the map display feature is working.
* **Searching for a Real Estate Agent:** Verifies the availability of the real estate agent search functionality.
---
## Test Cases

The test cases are written in Gherkin syntax and are located in the `src/test/resources/features` directory. Each feature file focuses on a specific area of functionality.

* `src/test/resources/features/buy_rent_search.feature`: Contains tests for searching for properties to buy and rent.
* `src/test/resources/features/user_login.feature`: Contains tests for user login functionality.
* `src/test/resources/features/map_loads.feature`: Contains tests for the map display feature.
* `src/test/resources/features/agent_search.feature`: Contains tests for searching for real estate agents.
---
## Project Stack

This project uses the following technologies:

* **Programming Language:** Java
* **Build Tool:** Maven
* **Test Framework:** JUnit 5
* **Browser Automation:** Playwright
* **Methodology:** BDD
---
## Rationale for Test Selection

The selected smoke tests prioritize critical user journeys and functionalities essential to the Funda experience. They focus on verifying that core elements are reachable and responsive, rather than delving into detailed data validation or complex workflows. This allows for quick identification of major issues that might prevent users from performing basic tasks. 
The "Search for Buying" and "Search for Renting" features are crucial as they represent the primary purpose of the Funda website. The "User Login" feature, while potentially leading to more complex functional tests later, is included in the smoke test suite to verify the accessibility of the login functionality itself.  The "Displaying Map" feature is essential for users visually exploring properties, and "Searching for a Real Estate Agent" is a key component for users seeking professional assistance.
---
## User Login Test Approach

The "User Login" test verifies the basic login workflow. While it does include entering credentials and checking for a success message, it's important to note that this is a *high-level, superficial check*. The primary goal is to ensure that the login functionality is accessible and responds to user input. More comprehensive login testing, including handling invalid credentials, password resets, account management,etc. would be covered in a separate suite of functional tests. Including a basic login attempt in the smoke test allows for a quick check of the authentication system's basic operation.

---

## Specific Element Verification

In some tests, instead of generic phrases like "search options are available," specific elements are checked. For instance, the "Agent Search" test verifies the presence of the "Zoek een NVM-makelaar" button, ensuring that this key element for agent search is available.  Similarly, the login test checks for the "Inloggen" button. This approach provides a more concrete and reliable check that the relevant UI elements are loaded and accessible.

---
## Scalability Considerations

This smoke test suite is designed with `scalability` in mind. Features,Pages,stepdefinitions are seperated into individual files and `POM` is used for pages. `External data source (CSV)` is used along with `Scenario Outlines` to make it easy to add more tests and data in the future. The use of csv data files for features facilitates the addition of more test data when needed.

---
## Setup Instructions
Clone this repository:
```
 git clone https://github.com/ErDmYLmZ/qa-assignment-funda.git
```
### To Run the tests via Terminal/Command Prompt
1. Navigate to the project directory:
* ```
    cd qa-assignment-funda
  ```
2. Run the required command from the following commands
* Run all tests:
    * `mvn test`
* Run UI smokes tests (with a defined browser):
    * `mvn test -Dtest=com.funda.tests.runners.SmokeTestsRunner -Dbrowser=<browser_name>`
      _Replace <browser_name> with webkit, firefox, or chromium (default)._
* Run CrossBrowser tests:
    * `mvn test -Dtest=CrossBrowserRunner`
      _This will execute UI smoke tests sequentially across multiple browsers._
* Run Failed tests :
    * `mvn test -Dtest=com.funda.tests.runners.FailedTestCaseRunner`
      _Failed tests are logged in target/failed-tests.txt and can be re-run using this command._

### To Run the tests via IDE _(recommended IDE: intellij)_
1. To run the tests via Runner class,
    * Ui smoke tests: go to `src/test/java/runners/SmokeTestsRunner.java` and click on the `Run` button.
    * Cross browser tests: go to `src/test/java/runners/CrossBrowserRunner.java` and click on the `Run` button.
    * Failed tests: go to `src/test/java/runners/FailedTestsRunner.java` and click on the `Run` button.

2. To run all the tests via Maven tab, click on Maven tab then double-click on "test", "verify" or "install.

---
## Test Reports
Test reports are automatically generated and stored in the `target/test-reports` directory. Reports include:
* Cucumber Reports: Detailed BDD execution reports.
* JSON Reports: Machine-readable test result logs.
* PDF Reports: Comprehensive, printable summaries.
* Screenshots: Captured on UI smoke test failures.
* Spark Reports: Interactive HTML reports.
* XML Reports: Standardized test result logs for integration.

---
## Dependencies

The framework uses the following dependencies (defined in pom.xml):
* Cucumber: For BDD support.
* Playwright (Java): For UI automation.
* Dependencies are automatically managed via Maven.
---

### Decision-Making Process

1. Framework Design:

* Modular Architecture: The framework separates UI smoke tests into distinct components, allowing independent maintenance and execution.

* Reusability: Common utilities, configurations, Page object modeling, and test data are centralized, minimizing duplication and maximizing code reusability.

* Ease of Use: A parameterized design allows running tests with flexible input data, catering to various test scenarios.

2. Technology Choices:

* JUnit 5: Chosen for its modern features like annotations, parameterized tests, and dynamic tests. JUnit 5 integrates seamlessly with Maven and Cucumber.

* Cucumber: Used to enable BDD, making test cases readable and understandable for both technical and non-technical stakeholders.

* Playwright (Java): A modern, fast, and reliable UI automation tool.

* Maven: Used for dependency management, build automation, and seamless integration with CI/CD tools. Maven ensures consistency across environments.

3. Testing Strategy:

* UI SmokeTesting: Simulates real-user behavior for the core functionalities and verifies UI integrity.

* Cross-Browser Testing: Ensures compatibility across major browsers (Chrome, Firefox, Webkit).

* Failure Recovery: Implements re-run capabilities for failed tests, reducing the need for manual intervention.

4. Reporting and Debugging:

* A comprehensive reporting mechanism includes HTML, JSON, PDF, and screenshots for detailed insights into test execution.

* Failed tests are logged for easy identification and re-execution.

### Key Strengths of the Approach

* Scalability: The modular architecture allows easy addition of new tests and functionalities.

* Readability: Use of BDD with Cucumber ensures that test cases are accessible and understandable by all stakeholders.

* Efficiency: Playwright and Java make complex user interface testing tasks easy.

---
## Key Features

* Modular design supporting the UI smoke tests.
* External data source usage for flexible test scenarios.
* Cross-browser testing capabilities.
* Re-run mechanism for failed tests.

---

## Future Enhancements

This smoke test suite provides a solid foundation for ensuring the quality of the Funda website.  Future enhancements could include:

* Expanding the test suite to cover more functionalities.
* Adding more detailed verifications to the existing tests (transitioning some to functional tests).
* Integrating the tests into a Continuous Integration/Continuous Deployment (CI/CD) pipeline.
---
## Disclaimer

These smoke tests are intended for basic health checks and do not guarantee the absence of all defects.  Comprehensive functional and integration testing is still necessary for thorough quality assurance.

---
## Contact
For support or questions, please contact:
* _e.yilmaz.qa@gmail.com_

