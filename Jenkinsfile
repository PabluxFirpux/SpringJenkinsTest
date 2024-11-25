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
                sh "cd target"
                stash includes: 'JenkinsDemo-0.0.1-SNAPSHOT.jar', name: 'application', allowEmpty: true
                echo "Copied artifact"
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "dockerd &"
                unstash 'application'
                sh 'ls -l'
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}