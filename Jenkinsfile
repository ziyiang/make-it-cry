devops_host = '40.83.100.63'
web_host = '40.83.100.63'
user_id = 'user6'

stage('build'){
    node {
        git url: 'https://github.com/junnno/make-it-cry.git', branch: 'master'
        withMaven(maven: 'mvn', mavenLocalRepo: '.repository') {
            sh "mvn clean compile"
        }
    }
}