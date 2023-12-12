FROM openjdk:11
EXPOSE 8090
ADD target/Asius-Back-0.0.1-SNAPSHOT.jar stilreniun.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/stilreniun.jar"]