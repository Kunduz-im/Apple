pipeline {
    agent any

    tools {
        gradle 'Gradle-9.4.1'
        jdk 'JDK-21'
    }

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['smoke', 'regression', 'e2e', 'all'],
            description: 'Выберите какие тесты запустить'
        )
        string(
            name: 'BRANCH',
            defaultValue: 'main',
            description: 'Укажите ветку для запуска тестов'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: params.BRANCH,
                    url: 'https://github.com/Kunduz-im/Apple.git'
                )
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    if (params.TEST_SUITE == 'smoke') {
                        sh './gradlew clean smokeTest'
                    } else if (params.TEST_SUITE == 'regression') {
                        sh './gradlew clean regressionTest'
                    } else if (params.TEST_SUITE == 'e2e') {
                        sh './gradlew clean e2eTest'
                    } else {
                        sh './gradlew clean test'
                    }
                }
            }
        }
    }

    post {
        always {
            allure([
                results: [[path: 'build/allure-results']]
            ])
        }
    }
}