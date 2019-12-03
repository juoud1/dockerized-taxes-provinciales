# This is a Dockerfile for provider microservice application

# Use an official java 8 runtime as parent image
FROM maven:3.6.1-jdk-8-alpine

VOLUME /tmp

# Set maintainer email id
MAINTAINER infosolibill@gmail.com

# Set the working directory contents into the container at /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Build and create jar using maven command
RUN mvn package -DskipTests=true -Ddir=app

# Copy the current directory contents into the container
ADD target/psolibill.jar providers-psolibill.jar

# Make port 8987 available to the world outside this container
EXPOSE 8987

# Define environment variable
ENV JAVA_OPTS=""

# Run psolibill.jar when the container launches
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar providers-psolibill.jar"]