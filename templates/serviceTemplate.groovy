pipeline {
    agent any
    parameters {
        string(name: 'DIR', defaultValue: '.', description: 'Directory to execute the build')
    }
    tools {
        maven '3.9.5'
    }
    environment {
        NEXUS_CREDENTIAL_ID = "nexus"
        NEXUS_URL = 'localhost:6666'
        NEXUS_REPO = 'dockerhosted-repo'
        DOCKER_IMAGE_NAME = "car-pooling-be:${BUILD_ID}"
        SERVICE_DIR = "${DIR}"
    }
    stages{
        stage('Build Artifact'){
            steps{
                dir("${SERVICE_DIR}") {
                    sh 'echo "Building artifact from child pipeline"'
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        // stage ('dev'){
        //     steps {
        //         dir("${SERVICE_DIR}") {
        //             echo "works only for main branch"
        //         }
        //     }
        // }

        // stage('Quality Analysis'){
        //     steps{
        //         dir("${SERVICE_DIR}") {
        //             withSonarQubeEnv('mysonar'){
        //                sh """
        //                 mvn sonar:sonar \
        //                     -Dsonar.projectKey=car-pooling \
        //                     -Dsonar.projectName=car-pooling \
        //                     -Dsonar.sources=src/main/java \
        //                     -Dsonar.java.binaries=target/classes
        //                 """
        //             }
        //         }
        //     }
        // }

        // stage('Quality Gate'){
        //     steps{
        //         dir("${SERVICE_DIR}") {
        //             waitForQualityGate abortPipeline: true
        //         }
        //     }
        // }

        // stage('Login to Nexus') {
        //     steps {
        //         dir("${SERVICE_DIR}") {
        //             script {
        //                 withCredentials([usernamePassword(credentialsId: 'nexus', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
        //                     sh "docker login http://${NEXUS_URL} -u ${NEXUS_USERNAME} -p ${NEXUS_PASSWORD}"
        //                 } 
        //             }
        //         }
        //     }
        // }

        // stage('Build Docker Image') {
        //     steps {
        //         dir("${SERVICE_DIR}") {
        //             script {
        //                 sh "docker build -t ${DOCKER_IMAGE_NAME} ."
        //             }
        //         }
        //     }
        // }

        // stage('Push Docker Image') {
        //     steps {
        //         dir("${SERVICE_DIR}") {
        //             script {
        //                 sh "docker tag ${DOCKER_IMAGE_NAME} ${NEXUS_URL}/repository/${NEXUS_REPO}/${DOCKER_IMAGE_NAME}"
        //                 sh "docker push ${NEXUS_URL}/repository/${NEXUS_REPO}/${DOCKER_IMAGE_NAME}"
        //             }
        //         }
        //     }
        // }

        // stage('Deploy') {
        //     environment {
        //         BACKEND_IMAGE = "${DOCKER_IMAGE_NAME}"
        //     }
        //     steps {
        //         dir("${SERVICE_DIR}") {
        //             input message: 'Approve Deployment',
        //               parameters: [
        //                   choice(
        //                       name: 'Proceed with deployment?',
        //                       choices: ['Yes', 'No'],
        //                       description: 'Do you want to deploy the new image?'
        //                   )
        //               ]
        //             sh 'docker compose up -d'
        //         }
        //     }
        // }
    }
    post {
        success {
            echo "Build successful"
        }
        failure {
            echo "Build failed"
        }
        always {
            cleanWs()
        }
    }
}
