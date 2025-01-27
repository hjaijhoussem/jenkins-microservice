pipeline {
    agent any
    stages {
        stage('Build Backend') {
            when {
                changeset 'backend'
            }

            build job: './templates/serviceTemplate', parameters: [string(name: 'DIR', value: 'backend')]
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