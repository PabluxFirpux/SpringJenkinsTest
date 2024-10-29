pipeline {
    agent {
       dockerContainer {
          image '-v /tmp:/tmp maven:3.9.3-eclipse-temurin-17'
       }
    }
    stages {
        stage("build") {
            steps {
                echo "Building application"
                sh "mvn install"
                sh "cp ./target/JenkinsDemo-0.0.1-SNAPSHOT.jar /tmp"
            }
        }
        stage("test") {
             steps {
                 echo "Testing application"
                 sh "mvn test"
             }
        }
        stage("dockerize") {
        agent any
            steps {
                echo "dockericeing the application"
                sh "cp /tmp/JenkinsDemo-0.0.1-SNAPSHOT.jar ./target/"
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}