**TutorISAWEB - A system containing an application for managing programming school trainers, and a REST application that
collects user session data**

STACK:
Java
Spring
SpringBoot
Hibernate
Bootstrap
Thymeleaf


Run container:

docker run --name tutorisaweb_db \
-e MYSQL_ROOT_PASSWORD=rootPassword \
-e MYSQL_DATABASE=tutorisaweb_db \
-e MYSQL_USER=tutorisa_user \
-e MYSQL_PASSWORD=password \
-p 3307:3306 \
-d mysql:8