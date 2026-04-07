plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allure {
    version.set("2.33.0")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.codeborne:selenide:7.14.0")

    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")

    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.aeonbits.owner:owner:1.0.12")
    implementation("io.rest-assured:rest-assured:6.0.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.2")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("commons-dbutils:commons-dbutils:1.8.1")

    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("io.qameta.allure:allure-junit5:2.33.0")

    // Source: https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation("io.github.bonigarcia:webdrivermanager:6.3.4")


    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2") // ← добавить!
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")        // ← добавить!
    implementation("com.opencsv:opencsv:5.9")

    // Source: https://mvnrepository.com/artifact/io.qameta.allure/allure-selenide
    implementation("io.qameta.allure:allure-selenide:2.33.0")

    // Source: https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.2")

    // Source: https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils
    implementation("commons-dbutils:commons-dbutils:1.8.1")

    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation("ch.qos.logback:logback-classic:1.4.11") // ← это провайдер для SLF4J


}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Test>("apiAndUiTest") {
    useJUnitPlatform {
        includeTags("API | UI")  // OR — запустит оба тега
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    outputs.upToDateWhen { false }
    systemProperty("chromeoptions.args", "--headless=new")  // добавь эту строку
}