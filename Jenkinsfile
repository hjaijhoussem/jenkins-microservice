// library identifier: 'jenkins-shared-library@main',
//         retriever: modernSCM([
//             $class: 'GitSCMSource',
//             remote: 'git@github.com:YOUR_USERNAME/jenkins-shared-library.git',
//             credentialsId: 'YOUR_CREDENTIALS_ID'
//         ])

pipeline {
    agent any
    stages {
        stage('Build Backend') {
            // when {
            //     changeset './backend'
            // }
            steps {
                // build job: './templates/serviceTemplate.groovy', parameters: [string(name: 'DIR', value: 'backend')]
                //serviceTemplate(DIR)
                build job: 'backend/Jenkinsfile'
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