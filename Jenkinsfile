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
        stage('Manual Approval') {
            steps {
                script {
                    // Manual approval step
                    input message: 'Approve deployment to production?', ok: 'Proceed'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker build -f Dockerfile -t myapp .'
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 8081:8080 --detach myapp:latest'
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                    artifacts: '**/Davidspetitions*.war'
            }
        }
    }
}
