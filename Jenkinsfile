pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'alias mvn14="JAVA_HOME=/java/jdk-14 && mvn"'
                sh 'mvn14 --version'
            }
        }
    }
}