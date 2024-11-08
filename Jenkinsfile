pipeline {
    agent any
    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/DaithiMull/Davidspetitions.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Exec') {
            steps {
                script {
                    sh 'mvn exec:java -Dexec.mainClass=com.example.Davidspetitions.DavidspetitionsApplication'
                }
            }
        }
    }
    post {
        success {
            archiveArtifacts allowEmptyArchive: true,
                artifacts:'**/Davidspetitions*.war'
        }
    }
}