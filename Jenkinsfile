pipeline {
    agent none
    stages {
        stage("Build and test application") {
            agent {
                kubernetes {
                    inheritFrom 'maven'
                }
            }
            steps {
                echo "Building and testing application"
                sh "mvn test"
                sh "mvn install"
                stash includes: '**/target/*.jar', name: 'application', allowEmpty: true
                echo "Copied artifact"
            }
        }
        stage("Dockerize") {
            agent any
            steps {
                unstash 'application'
                echo "Dockericeing the application"
                sh "dockerd &"
                sh "docker login -u pabluxfirpux -p p4bl02004"
                unstash 'application'
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
                sh "docker tag jenkinsapispring pabluxfirpux/jenkinsapispring:latest"
                sh "docker image push pabluxfirpux/jenkinsapispring:latest"
            }
        }
    }
}