import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.gradle.jvm.tasks.Jar
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginExtension
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

val springBootVersion = "3.4.3"  // Исправлено на существующую версию
val springCloudVersion = "2024.0.0"  // Исправлено на существующую версию

plugins {
    id("org.springframework.boot") version "3.4.3" apply false  // Исправлено
    id("io.spring.dependency-management") version "1.1.7" apply false
    kotlin("jvm") version "1.9.21" apply false
}

allprojects {
    group = "com.ecommerce"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    // Настройка Java версии - ТОЛЬКО ОДИН СПОСОБ
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    // Spring Dependency Management
    extensions.configure<DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        }
    }

    // Зависимости
    dependencies {
        // Lombok
        "compileOnly"("org.projectlombok:lombok")
        "annotationProcessor"("org.projectlombok:lombok")
        "testCompileOnly"("org.projectlombok:lombok")
        "testAnnotationProcessor"("org.projectlombok:lombok")

        // Logging
        "implementation"("org.springframework.boot:spring-boot-starter-logging")
        "implementation"("net.logstash.logback:logstash-logback-encoder:7.4")

        // Testing
        "testImplementation"("org.springframework.boot:spring-boot-starter-test")
        "testImplementation"("org.mockito:mockito-inline:5.2.0")
        "testImplementation"("org.testcontainers:testcontainers:1.19.4")
    }

    // Настройка BootJar и Jar
    tasks.withType<BootJar> {
        enabled = false
    }
    tasks.withType<Jar> {
        enabled = true
    }
}

subprojects.filter { it.name != "shared" }.forEach {
    it.tasks.withType<BootJar> {
        enabled = true
    }
    it.tasks.withType<Jar> {
        enabled = false
    }
}

tasks.register("buildAllServices") {
    dependsOn(
        ":api-gateway:build",
        ":services:user-service:build"
    )
}

tasks.register("test") {
    dependsOn(subprojects.map { it.tasks.named("test") })
}