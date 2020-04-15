pipeline {
    agent any
    options { disableConcurrentBuilds() }
    stages {
        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Publish') {
            steps {
                sh 'mvn deploy'
            }
        }
        stage('Deploy DEV') {
            steps {
                sh 'mkdir -p wangshuai'
                dir('wangshuai') {
//                     sh 'kill -9 $(lsof -t -i:8000)'
                    sh '''
                        if [ "$(lsof -t -i:8000)" ];then
                            kill -9 $(lsof -t -i:8000)
                        fi
                    '''
                    sh 'curl -O http://47.96.237.96:8082/artifactory/libs-snapshot-local/sample/make-it-cry/1.0-SNAPSHOT/make-it-cry-1.0-20200415.192751-11.war'
//                     sh 'curl -O http://47.96.237.96:8082/artifactory/libs-release/sample/make-it-cry/1.0/make-it-cry-1.0.war'
                    sh 'SERVER_PORT=8000 java -jar make-it-cry.war'
                }
            }
        }
    }
}