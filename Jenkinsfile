pipeline {
    agent any

    // tools блок удаляем полностью!

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
                        bat 'gradlew.bat clean smokeTest'
                    } else if (params.TEST_SUITE == 'regression') {
                        bat 'gradlew.bat clean regressionTest'
                    } else if (params.TEST_SUITE == 'e2e') {
                        bat 'gradlew.bat clean e2eTest'
                    } else {
                        bat 'gradlew.bat clean test'
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