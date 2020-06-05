#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh """
                    export JAVA_HOME=/java/jdk-14
                    mvn --version
                    "${JAVA_HOME}/bin/java" -version
                """
            }
        }
    }
}