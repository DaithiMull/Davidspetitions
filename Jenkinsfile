pipeline {
    agent any
    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/DaithiMull/Davidspetitions.git'
            }
        }
        stage('Build') { // Capitalized 'Build' for clarity
            steps {
                sh 'mvn clean install' // Use clean install instead of separate steps
            }
        }

        stage('Package') {
                    steps {
                        sh 'mvn package'
                    }
                }

        stage('Exec') { // Capitalized 'Exec' for clarity
            steps {
                script { // Use script block for better control
                    sh 'mvn exec:java -Dexec.mainClass=com.example.Davidspetitions.DavidspetitionsApplication'
                }
            }
        }
    }
}