From openjdk:8
EXPOSE 8073
ADD target/Vaccination_center-0.0.1-SNAPSHOT.jar  Vaccination_center-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/Vaccination_center-0.0.1-SNAPSHOT.jar" ]
