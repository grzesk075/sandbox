#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh """
                    JAVA_HOME=/java/jdk-14
                    export JAVA_HOME
                    mvn --version
                    echo $JAVA_HOME
                    "${JAVA_HOME}/bin/java" -version
                """
            }
        }
    }
}