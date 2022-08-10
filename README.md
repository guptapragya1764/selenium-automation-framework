### Features Supported by Framework

<li>Parallel execution Of Test Case.
<li>Logging on both console and file level.
<li>Data driven tests with Excel using testng dataprovider(also supports the parallel execution of same test case with various data).
<li>Generation of the test data is dynamic from excel file.
<li>Supports the test cases to run on multiple browsers (configurable from properties file).
<li>Support of Listeners and groups.
<li>Automatic re-execution of failed Test Cases (configurable from properties file).
<li>Extent reporting(includes Screenshot of passed/failed/skipped step) and generation of screenshot is configurable from the properties file.
<li>Support of custom annotation to feed the data into test cases.<br><br>

### How to use this framework?<br>

<li>Download the project and unzip it then import it in IDE.
<li>Directly run any testng xml file as per your wish.(There are 4 testng xml file available in the framework).<br>
Or<br>
<li>To run from maven, go to project path and run 'mvn clean test'(testng.xml is set bydefault in surefire plugin currently<br>
and if want to run any  other testng file then set it in surefire plugin then run 'mvn clean test').
<li> After execution, generated logs would be in console and file(/logs/current/timestamp), while screenshot and report would be generated inside test-results/current-test-results/timestamp and Extent Report would automatically open inside browser after execution.
<li> Currently, config property for taking screenshot for failed/passed/skipped test step is marked as yes. So screenshot for every step would be generated.





