pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Perform deployment steps if needed
            }
        }
    }
    
    post {
        always {
            // Clean up steps if needed
        }
        
        success {
            echo 'Pipeline succeeded! Deploy your application.'
        }
        
        failure {
            echo 'Pipeline failed! Check logs for details.'
        }
    }
}
