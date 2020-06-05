#!/usr/bin/env groovy
pipeline {
    agent any

    environment {
        JAVA_HOME = "/java/jdk-13"
    }

    stages {
        stage('Build') {
            steps {
                sh """
                    export JAVA_HOME="${env.JAVA_HOME}"
                    mvn clean install
                """
            }
        }
        stage('Run') {
            when {
                branch 'master'
            }
            steps {
                sh """
                    "${env.JAVA_HOME}/bin/java" --enable-preview -cp target/sandbox*.jar pl.grzesk075.sandbox.java.Java13Tutorial
                """
            }
        }
    }
}