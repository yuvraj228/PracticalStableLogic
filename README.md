# PracticalStableLogic

In this project , Automate test case in below flow
1. Make a HTTP get request to https://jsonplaceholder.typicode.com/users/1 and read the content
2. Open veroxos.com in google chrome browser
3. Click on the contact page
4. Fill up the contact form with the following information
5. Full Name: name from json
6. Job Title: Junior software developer
7. Organisation: company.name from json
8. Phone: phone from json
9. Email: email from json
10. Message: Test message from the java and selenium
11. Click Send
12. Verify success message 




## How to run test

To run test case , we can run in 3 ways
1. From Maven : Right click on Project or pom.xml > click on Run As > Click on Maven test
2. From TestNG : Right click on Project or testng.xml > click on Run As > Click on TestNG Suite
3. From Test class file : Right click on class file > on Run As > Click on TestNG Test

To run test via command line,

Pre- requisite 

Jdk version 1.8 or above

Maven 

Go to project directory run the following command

```bash
  mvn test
```

