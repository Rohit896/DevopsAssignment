FROM openjdk:8-jre-slim
MAINTAINER Rohit Sharma
RUN mkdir /usr/src/myapp
ADD target/Calculator-1.0-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java","-cp","Calculator-1.0-SNAPSHOT.jar","com/calculator/Calculator"]