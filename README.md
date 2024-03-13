# Mudah Test Automation Evaluation - QA

This file contains basic information regarding framework structure and execution instructions

## File Structure

The project folder contains 2 primary directories and 2 essential configuration .xml files.

```bash

├── Mudah
    ├── src
    │   ├── \main          # implementations: contains page objects, methods and framework codes 
    │   ├── \test          # tescases  : contains test cases 
    │ 
    ├── pom.xml            # pom.xml   : contains project configuration and dependencies
    ├── testng.xml         # testng.xml: contains configuration for TestNG single, parallel and cross-environment execution
    
```

In the main folder, there are the following folders and files

```bash

├── ...
    ├── \main
    │   ├── \java
    │         ├── \data 
    │         │     ├── LoginData.java        # LoginData.java: contains data source and data provider for logins
    │         ├── \pages
    │         │     ├── DashboardPage.java    # LoginPage.java: contains objects and methods of dashboard page
    │         │     ├── HomePage.java         # HomePage.java: contains objects and methods of home page
    │         │     ├── LoginPage.java        # LoginPage.java: contains objects and methods of login page
    │         ├── \utilities
    │         │     ├── Utils.java            # Utils.java: contains reusable methods and helpers to be used across logic layer
    │         │
    │          
    │
    └── ...
```

In the test folder, there are 5 test cases and 1 test utility file

```bash

├── ...
    ├── \test
    │   ├── \java
    │       ├── \base
    │            ├── BaseTest.java               # BaseTest.java: contains common setup, teardown, and utility methods shared across multiple test cases
    │       ├── \login                           # \login: contains 5 login test cases 
    │            ├── InvalidEmailCharTest.java
    │            ├── InvalidPassRetryLimitTest.java
    │            ├── InvalidPasswordTest.java
    │            ├── PrivateAccLoginTest.java
    │            ├── ProNiagaLoginTest.java
    │
    └── ...
```


## Test Cases

```python
1. InvalidEmailCharTest :[Parallel Execution] Validates the error message for combinations of possible invalid characters in email input field.

2. InvalidPassRetryLimitTest : Validates the error message after 7x attempts of correct email and wrong password input 

3. InvalidPasswordTest :[Parallel Execution] Validates the error message for correct email and wrong password input.

4. PrivateAccLoginTest : Validates successful login as private account owner

5. ProNiagaLoginTest : Validates successful login as pro niaga account owner
```

## Concepts & Best Practices Implemented
- [x] <span style="color:limegreen"> Page Object Model (POM) design pattern </span>
- [x] <span style="color:limegreen"> Lazy loading design pattern </span>
- [x] <span style="color:limegreen"> Reusable methods </span>
- [x] <span style="color:limegreen"> Reusable parameterized objects </span>
- [x] <span style="color:limegreen"> Standardized object naming conventions </span>
- [x] <span style="color:limegreen"> OOP concepts (Encapsulation, Inheritance) </span>
- [x] <span style="color:limegreen"> Error handling </span>
- [x] <span style="color:limegreen"> Data driven architecture </span>
- [x] <span style="color:limegreen"> Cross-environment execution </span>
- [x] <span style="color:limegreen"> Parallel execution </span>



## Installation

Ensure the following are installed in your machines:

- [IntelliJ Idea Community Edition](https://www.jetbrains.com/idea/download/?section=mac)
- [Java JDK](https://www.oracle.com/my/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Chrome Browser](https://www.google.com/chrome/)
- [Firefox Browser](https://www.mozilla.org/en-US/firefox/new/)

## Configurations
The following configuration must be done in order:

1. Clone or download the repository. Then open the project in IntelliJ.
2. Install dependencies. You may open the **`pom.xml`** file and ensure Selenium, TestNG and Web Driver Manager dependencies are there.
3. Build the project. You can build it by selecting **`Build > Build Project`** from the menu. IntelliJ IDEA will compile the project and display the build output in the **`Run`** tool window at the bottom of the IDE.
   Any errors or warnings encountered during the build process will be displayed here.
4. In case step 3 doesn't work, you can also go the terminal option and type **`maven test`**. This will compile and execute any java class file. 
5. Verify build success. After the build process completes, verify that the project was built successfully. Look for messages indicating a successful build or any errors that may have occurred.

## Execution

1. Open test class. Open the test class that contains the test cases you want to execute.
2. Run test cases. To run individual test cases, click on the green arrow icon next to the test case method you want to execute. 
3. Alternatively, right-click on the method and select "Run" from the context menu.
4. In order to run test suite, open **`testng.xml`** file. Right-click on the xml file and select **`Run`** from the context menu.
5. You may customize the **`testng.xml`** file for single, multiple test cases execution by commenting out relevant **`<class>`** blocks. 
6. As for parallel and cross-browsing test case execution, you may pass the relevant parameters in the **`<test>`** block .

**Disclaimer** : 
1. Since we are using PRODUCTION Mudah.com for automation demonstration purposes, there will be OTP authentication sent to 2 email addresses for first time execution.
2. This part is not automated and needs manual intervention.  Details of the account will be shared privately.


## Author

[Rampraesath (Ram)](https://github.com/Rampraesath)
