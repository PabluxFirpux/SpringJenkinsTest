pipeline {
    agent {
        kubernetes {
            inheritFrom 'maven'
        }
    }
    stages {
        stage("Build and test application") {


                    steps {
                                                    echo "Building and testing application"
                                                    sh "mvn install"
                                                    sh "cp ./target/JenkinsDemo-0.0.1-SNAPSHOT.jar /tmp"
                                                }


        }
    }
}