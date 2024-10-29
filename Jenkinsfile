pipeline {
    agent {
       dockerContainer {
          image 'maven:3.9.3-eclipse-temurin-17'
       }
    }
    stages {
        stage("build") {
            steps {
            echo "Building application"
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
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}