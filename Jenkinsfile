pipeline {
    agent any
    stages {
        stage('Build') {
            step {
                sh './mvnw package'
            }
        }
    }
}