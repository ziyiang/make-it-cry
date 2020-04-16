// def appPort = "8000"

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
                    sh '''
                        if [ "$(lsof -t -i:8000)" ];then
                            kill -9 $(lsof -t -i:8000)
                        fi
                    '''
                    sh '''
                        mvn dependency:get \
                        -DremoteRepositories=http://47.96.237.96:8082/artifactory/libs-snapshot \
                        -DgroupId=sample \
                        -DartifactId=make-it-cry \
                        -Dversion=1.0-SNAPSHOT \
                        -Dpackaging=war \
                        -Dtransitive=false

                        mvn dependency:copy \
                        -Dartifact=sample:make-it-cry:1.0-SNAPSHOT:war \
                        -DoutputDirectory=.
                    '''
                    sh 'nohup SERVER_PORT=8000 java -jar make-it-cry-1.0-SNAPSHOT.war > log.out &'
                }
            }
        }
    }
}