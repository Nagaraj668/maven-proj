pipeline {
    agent any

    stages {
        stage('compile stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean'
                }
            }
        }

        stage('testing stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn test'
                }
            }
        }

        stage('deploy stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn deploy'
                }
            }
        }
    }

}