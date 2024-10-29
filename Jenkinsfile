pipeline {
    agent {
        docker {
            cloud "docker-cloud"
        }
    }
    stages {
        stage("build") {
            steps {
            echo "Building application"
            }
        }
        stage("test") {
             steps {
                 echo "Testing application"
                 sh "mvn test"
             }
        }
        stage("deploy") {
            steps {
                echo "Deploying application"
                sh "mvn spring-boot:run"
            }
        }
    }
}