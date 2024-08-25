
# **Automation Test Project**

## **Setup Instructions**

### **1. Install Java**
- Ensure that Java 8 or a later version is installed on your system.
- You can download the latest version of Java from the [official website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
- To verify the installation, open a terminal/command prompt and run:
  ```sh
  java -version
  ```
  This should display the installed Java version.

### **2. Download and Set Up WebDriver**
- **For Chrome:**
  - Download the latest version of ChromeDriver from the [official ChromeDriver site](https://sites.google.com/chromium.org/driver/).
  - Extract the downloaded file and add the directory containing `chromedriver.exe` to your system's PATH environment variable.
  - To verify the setup, open a terminal/command prompt and run:
    ```sh
    chromedriver --version
    ```
    This should display the installed ChromeDriver version.

- **For Other Browsers:**
  - If you're using a different browser, download the corresponding WebDriver (e.g., GeckoDriver for Firefox) and set it up similarly.

### **3. Configure the Application URL**
- Open the `LoginTest.java` file located in the `src/test/java/com/tests/` directory.
- Update the URL in the `navigateToURL()` method to point to the login page of the application you are testing:
  ```java
  public void navigateToURL() throws Exception {
      browserActions.openBrowser();
      browserActions.hitURL("https://your-application-url.com/login");
  }
  ```

## **Running the Tests**

### **Using TestNG**
- Ensure TestNG is installed and configured in your IDE (e.g., Eclipse or IntelliJ IDEA).
- Right-click on the `testng.xml` file in the project directory and select `Run As` > `TestNG Suite`.
- Alternatively, you can run the tests from the command line using Maven:
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```

### **Viewing Test Results**
- After the tests run, the results will be available in the `test-output` directory.
- Open the `index.html` file in this directory to view the detailed test report.

## **Additional Notes**
- The project includes retry logic to automatically rerun failed tests, reducing the impact of transient issues.
- Screenshots of failed test cases are saved in the `Screenshot` directory within the project root.
