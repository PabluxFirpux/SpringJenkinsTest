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
                sh "mkdir target"
                sh "dockerd &"
                dir("target") {
                    unstash 'application'
                    sh "pwd"
                    sh "ls"
                }
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}