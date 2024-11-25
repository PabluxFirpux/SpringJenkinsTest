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
                sh "mvn install"
                stash includes: '**/target/*.jar', name: 'application', allowEmpty: true
                echo "Copied artifact"
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "dockerd &"
                unstash 'application'
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
                sh "docker tag jenkinsapispring pabluxfirpux/jenkinsapispring:latest"
            }
        }
    }
}