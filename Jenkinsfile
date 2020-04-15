pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw package'
            }
        }
        stage('Publish') {
            steps {
                sh './mvnw deploy'
            }
        }
        stage('Deploy DEV') {
            steps {
                sh 'curl -O '
            }
        }
    }
}