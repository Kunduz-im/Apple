pipeline {
    agent any

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['smoke', 'regression', 'e2e', 'all'],
            description: 'Выберите набор тестов'
        )
        string(
            name: 'SINGLE_TEST',
            defaultValue: '',
            description: 'Запустить конкретный тест по имени (например: TC 001). Если заполнено — TEST_SUITE игнорируется'
        )
        string(
            name: 'BRANCH',
            defaultValue: 'master',
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
                    if (params.SINGLE_TEST?.trim()) {
                        // Если указан конкретный тест — запускаем только его
                        bat "gradlew.bat clean test --tests \"${params.SINGLE_TEST}\""
                    } else if (params.TEST_SUITE == 'smoke') {
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