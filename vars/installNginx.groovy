def call() {
    pipeline {
        agent { label 'Worker1' }
        
        stages {
            stage('Install Nginx') {
                steps {
                    sh 'sudo apt-get update -y'
                    sh 'sudo apt-get install nginx -y'
                }
            }
            stage('Starting Server') {
                steps {
                    sh "sudo systemctl start nginx"
                }
            }
            stage('Test Nginx') {
                steps {
                    sh 'curl localhost'
                }
            }
        }
    }
}
