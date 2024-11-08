pipeline {
    agent any

    stages {
        // Get project source code from GitHub
        stage('GetProject') {
            steps {
                git 'https://github.com/DaithiMull/Davidspetitions.git'
            }
        }

        // Build the project using Maven
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        // Package the project as WAR file using Maven
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        // Execute the application using Maven
        stage('Exec') {
            steps {
                script {
                    sh 'mvn exec:java -Dexec.mainClass=com.example.Davidspetitions.DavidspetitionsApplication'
                }
            }
        }
    }

    // Archive artifacts on successful builds
    stage {
        success {
            archiveArtifacts allowEmptyArchive: true,
                artifacts: '**/Davidspetitions*.war'
        }
    }
}