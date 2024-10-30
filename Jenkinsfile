pipeline {
    agent none
    stages {
        stage("Build and test application") {
        agent {
               docker {
                  image 'maven:3.9.3-eclipse-temurin-17'
                  args "-v /tmp:/tmp"
               }
            }
            steps {
                echo "Building and testing application"
                sh "mvn install"
                sh "cp ./target/JenkinsDemo-0.0.1-SNAPSHOT.jar /tmp"
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "dockerd &"
                sh "cp /tmp/JenkinsDemo-0.0.1-SNAPSHOT.jar ./target/"
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}