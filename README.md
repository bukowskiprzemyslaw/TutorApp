# TutorApp

TutorApp - A system containing an application for managing programming school trainers (MainApp), and a REST application (TrackingApp) that collects user session data, previously develop in TutorISA Project.

STACK: Java Spring SpringBoot Hibernate Bootstrap Thymeleaf

Run container:

docker run --name tutorisaweb_db
-e MYSQL_ROOT_PASSWORD=rootPassword
-e MYSQL_DATABASE=tutorisaweb_db
-e MYSQL_USER=tutorisa_user
-e MYSQL_PASSWORD=password
-p 3307:3306
-d mysql:8

To run the system you need to:
1. run container
2. connect to MySQL database in your IDE using credentials mentioned in docker configuration
3. run MainApp and TrackingApp in your IDE
