pipeline {
    agent none
    stages {
        stage("build") {
        agent {
               docker {
                  image 'maven:3.9.3-eclipse-temurin-17'
                  args "-v /tmp:/tmp"
               }
            }
            steps {
                echo "Building application"
                sh "mvn install"
                sh "cp ./target/JenkinsDemo-0.0.1-SNAPSHOT.jar /tmp"
            }
        }
        stage("test") {
        agent {
               docker {
                  image 'maven:3.9.3-eclipse-temurin-17'
                  args "-v /tmp:/tmp"
               }
            }
             steps {
                 echo "Testing application"
                 sh "mvn test"
             }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "mkdir target"
                sh "dockerd &"
                sh "cp /tmp/JenkinsDemo-0.0.1-SNAPSHOT.jar ./target/"
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}