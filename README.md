# GUI_Auto
This is a GUI Automation framework using Java, Selenium, Cucumber and Serenity.

### To deploy the poject<br>
* Download the poject, import it to you IDE as a maven project and run `mvn clean install` with your IDE.<br>
* Download the project, navigate to the project root directory, run `mvn clean install` with commandline.
* Before run the test, please update browser type and browser driver path in serenity.properties file

### To run the test<br>
`mvn clean verify`

### To run a test with tag
Add annotation to a scenario, then run the scenario with command:<br>
Eg: the tag is @new_feature
`mvn clean verify -Dcucumber.options="--tags @new_feature"`

### To check test report
After run the test, open the file "${project root directory}/target/site/serenity/index.html" with your browser.

### Main dependencies in Pom
Cucumber<br>
Serenity<br>
Rest-assured<br>
Junit<br>

### please use java 8 or higher version
