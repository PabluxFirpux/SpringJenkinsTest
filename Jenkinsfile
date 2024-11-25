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
                stash includes: "./target/JenkinsDemo-0.0.1-SNAPSHOT.jar", name: "artifact"
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "mkdir target"
                sh "dockerd &"
                sh "cd target"
                unstash "artifact"
                sh "cd .."
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}