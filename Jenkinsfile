pipeline {
    agent any

    tools {
        jdk 'JDK 17'      // exact name in Jenkins
        maven 'Maven3'    // exact name in Jenkins
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
                // Make sure this matches <reportsDirectory> in pom.xml
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
pipeline {
    agent any

    tools {
        jdk 'JDK 17'      // exact name in Jenkins
        maven 'Maven3'    // exact name in Jenkins
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
                // Make sure this matches <reportsDirectory> in pom.xml
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
