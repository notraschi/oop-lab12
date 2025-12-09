plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.159.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("it.unibo.es2.Test")
}

tasks.javadoc {
    isFailOnError = false
}
