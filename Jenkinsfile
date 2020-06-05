#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh """
                    export JAVA_HOME=/java/jdk-13
                    mvn clean install
                """
            }
        }
    }
}