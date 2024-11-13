pipeline {
    agent none
    stages {
        stage("Build and test application") {
            node('maven') {
                stage("mec") {
                    steps {
                                                    echo "Building and testing application"
                                                    sh "mvn install"
                                                    sh "cp ./target/JenkinsDemo-0.0.1-SNAPSHOT.jar /tmp"
                                                }
                }
            }
        }
        stage("dockerize") {
            agent any
            steps {
                echo "dockericeing the application"
                sh "dockerd &"
                sh "cp /tmp/JenkinsDemo-0.0.1-SNAPSHOT.jar ./target/"
                sh "docker build -t jenkinsapispring:latest ."
                sh "docker images"
            }
        }
    }
}