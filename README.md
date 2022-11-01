# ToolsQA
This project is part of the QA Engineer interview process at Ignite Tech.
In this project, I will write test automation scripts for the ToolsQA registration page (https://demoqa.com/automation-practice-form). 
I will choose the 5 most important test cases, and write automation scripts for them using Java and Selenium.

## Folder Structure
* src/pages - Page objects
* src/tests - page test case files
* src/urls - url file repositiory
* libraries/selenium - selenium library files
* libraries/webdriver - chromedriver and geckdriver library files

## Libraries Used
* Selenium - version 4.5.3
* JUnit tests - version 5.8.1
* chromedriver - version 107.0.5304.62

## Tools Used
* IDE - IntelliJ IDEA Community Edition (2021.3.2)
* Chrome browser - version 107.0.5304.87
* Oracle OpenJDK - version 18.0.2

## How to Execute the Tests
The automation test scripts were tested on Chrome browser running on Mac OS Ventura. However, it should run on any other OS.
If you prefer to run on Firefox browserm, please uncomment the lines of code indicated in TestRegistration. Don't forget to then comment out the ones intended to execute on Chrome browser (they are indicate in comments).

To run the scripts:
1. Go to TestRegistration.java file
2. Click on the green (run) arrow on the left of the method definitions to run them individually.
3. You can also right click the TestRegistration.java file inside the method you want to run and choose "Run <method name>"
4. To run all tests at once either right click the TestRegistration.java file "Run TestRegistration" or click on the green (run) arrow on the left of the class definition.

## Results
After running the test cases, the results are indicated on the pane at the bottom of the IDE.
The results will include the test cases executed, how many passed, how many failed, the ones that passed/failed, and the time it took for the tests to complete.
