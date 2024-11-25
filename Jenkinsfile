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
                stash includes: "./target/*", name: "artifact"
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "mkdir target"
                sh "dockerd &"
                dir("target") {
                    unstash "artifact"
                    sh "pwd"
                    sh "ls"
                }
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}