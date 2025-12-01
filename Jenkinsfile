pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven3', type: 'maven' // adjust to your Maven tool name
        JAVA_HOME = tool name: 'JDK17', type: 'jdk'       // adjust to your JDK
        PATH = "${env.MAVEN_HOME}/bin:${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/saipavan-sdet/ISRTC-Automation-Framework.git'
            }
        }

        stage('Clean & Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Test Reports') {
            steps {
                // Jenkins reads JUnit-style XML reports
                junit 'target/surefire-reports/*.xml'
                
                // Archive HTML reports for browsing
                archiveArtifacts artifacts: 'target/surefire-reports/*.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }
    }
}
