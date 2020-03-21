### Spring Restful API with Angular 9 demo 

How to Run the BookStore App:
1)Please find the executable in demo/target/demo-0.0.1-SNAPSHOT.jar and can be run using 'java -jar demo-0.0.1-SNAPSHOT.jar' OR 'mvn spring-boot:run' from the /demo folder
2)After successful start of the application, please enter 'http://localhost:8080/' in browser where you can see the login page.
3)Please enter 'test1@check24.de' as email and 123 as password. The Routing works only through the app. I.e if we enter the routes manually in the brwoser then the app does not find the required paths. It needs some more configuration for it to work but I leave it for further improvements

To Run the Backend and Frontend Separately:
The backend is a Spring Boot Application and uses the h2database. Following are the api endpoints available
1)http://localhost:8080/book/b1  - to fetch particular book along with the relevant other books
2)http://localhost:8080/book/  - to fetch all books

The frontent is developed using Agular 9 and can be run separately on node server on http://localhost:4200 after all dependencies are installed.
1)Please use 'npm install' from the /frontend/book-store folder to install all dependencies
2)And to start the app use 'ng serve'