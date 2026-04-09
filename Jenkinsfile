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
            description: 'Конкретный тест по имени. Если заполнено — TEST_SUITE игнорируется'
        )
        string(
            name: 'BRANCH',
            defaultValue: 'master',
            description: 'Укажите ветку для запуска тестов'
        )
        booleanParam(
            name: 'RERUN_FAILED',
            defaultValue: false,
            description: 'Перезапустить только упавшие тесты из последнего билда'
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
                    if (params.RERUN_FAILED) {
                        def xmlReportPath = "build\\test-results"
                        def failedTests = []
                        def files = bat(
                            script: "dir /B /S ${xmlReportPath}\\*.xml 2>nul",
                            returnStdout: true
                        ).trim().split('\n')
                        files.each { file ->
                            if (file?.trim()) {
                                def content = readFile(file.trim())
                                def xml = new XmlSlurper().parseText(content)
                                xml.testcase.each { tc ->
                                    if (tc.failure.size() > 0 || tc.error.size() > 0) {
                                        failedTests.add("${tc.@classname}.${tc.@name}")
                                    }
                                }
                            }
                        }
                        if (failedTests.isEmpty()) {
                            bat 'gradlew.bat clean test'
                        } else {
                            def testsArg = failedTests.collect { "--tests \"${it}\"" }.join(' ')
                            bat "gradlew.bat clean test ${testsArg}"
                        }
                    } else if (params.SINGLE_TEST?.trim()) {
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

        stage('Generate Allure Report') {
            steps {
                // Генерируем HTML отчёт из результатов — он нужен для уведомления
                bat 'gradlew.bat allureReport'
            }
        }

        stage('Send Telegram Notification') {
            steps {
                bat """
                    java -DconfigFile=notifications/telegram.json ^
                    -jar notifications/allure-notifications-4.7.0.jar
                """
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