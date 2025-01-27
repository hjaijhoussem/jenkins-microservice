pipeline {
    agent any
    stages {
        stage('Build Backend') {
            when {
                changeset 'Car-pooling-backend'
            }

            build job: './templates/serviceTemplate', parameters: [string(name: 'dir', value: 'hippo-rest')]
        }
    }
    post {
        success {
            echo "Parent Build successful"
        }
        failure {
            echo "Parent Build failed"
        }
        always {
            cleanWs()
        }
    }
}