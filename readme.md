Spring Boot REST API For Betslip

This application is integrated with spring boot in memory database h2. So once application is restarted all data saved will be lost.
The resource folder contains the data.sql which creates the required scheme for the application.
It creates 2 tabled CUSTOMER and BETSLIP
And also loads some default customer.

The application swagger-ui can be accessed on the below url once the application is started.
http://localhost:8080/demo/swagger-ui.html#/

And the h2 console in the below url.
http://localhost:8080/demo/h2-console/

Also application is integrated with spring boot actuator.

Application Class BetslipApplication.java