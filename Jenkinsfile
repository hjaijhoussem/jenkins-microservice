pipeline {
    agent any
    stages {
        stage('Build Backend') {
            // when {
            //     changeset './backend'
            // }
            steps {
                // build job: './templates/serviceTemplate.groovy', parameters: [string(name: 'DIR', value: 'backend')]
                serviceTemplate(DIR: 'backend')
            }
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