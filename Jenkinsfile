pipeline {
    agent any

    tools {
        // Make sure the JDK name matches your Jenkins Global Tool Configuration
        jdk 'JDK17'
        maven 'Maven3'
    }

    environment {
        // Optional: set Maven home if needed
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
                // Make sure this matches your maven-surefire-plugin <reportsDirectory>
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            node {
                echo 'Cleaning workspace...'
                cleanWs()
            }
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
