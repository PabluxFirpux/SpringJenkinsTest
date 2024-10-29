pipeline {
    agent {
        docker {
           image 'maven:3.9.3-eclipse-temurin-17'
           label 'docker-agent'
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
        stage("deploy") {
            steps {
                echo "Deploying application"
                sh "mvn spring-boot:run"
            }
        }
    }
}