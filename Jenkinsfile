pipeline {
    agent {
       docker {
          image 'maven:3.9.3-eclipse-temurin-17'
          args "-v /tmp:/tmp"
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
            agent {
                docker {
                    image "docker/dockerfile"
                    args "-v /tmp:/tmp"
                }
            }
            steps {
                echo "dockericeing the application"
                sh "mkdir target"
                sh "cp /tmp/JenkinsDemo-0.0.1-SNAPSHOT.jar ./target/"
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}