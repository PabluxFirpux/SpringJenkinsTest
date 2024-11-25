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
                stash includes: '/target/*', name: 'application'
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