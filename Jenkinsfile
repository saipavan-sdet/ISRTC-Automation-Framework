pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/saipavan-sdet/ISRTC-Automation-Framework.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test"
            }
        }

        stage('Archive Reports') {
            steps {
                junit '**/test-output/testng-results.xml'
                archiveArtifacts artifacts: '**/target/**/*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Pipeline finished. Cleaning workspace."
            cleanWs()
        }
    }
}
