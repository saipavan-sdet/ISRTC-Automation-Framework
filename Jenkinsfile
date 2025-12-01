pipeline {
    agent any

    triggers {
        // Runs every day at 11:30 AM
        cron('30 11 * * *')
    }

    tools {
        jdk 'JDK 17'      // Use exact name configured in Jenkins
        maven 'Maven3'    // Use exact name configured in Jenkins
    }

    environment {
        MVN_HOME = tool 'Maven3'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                git(
                    url: 'https://github.com/saipavan-sdet/ISRTC-Automation-Framework.git',
                    credentialsId: 'c73dc16a-41f9-4845-9af5-5924687f1354'
                )
            }
        }

        stage('Install Dependencies') {
            steps {
                bat "${MVN_HOME}\\bin\\mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                bat "${MVN_HOME}\\bin\\mvn test"
            }
        }

        stage('Archive Test Reports') {
            steps {
                // Make sure this path matches <reportsDirectory> in your pom.xml
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
