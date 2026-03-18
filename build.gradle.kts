import org.springframework.boot.gradle.tasks.bundling.BootJar

val springBootVersion = "4.0.3"
val springCloudversion = "2025.0.1"

plugins{
    id("org.springframework.boot") version "4.0.3" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
    kotlin("jvm") version "1.9.21" apply false
}

allprojects{
    group = "com.ecommerce"
    version = "1.0.0"

    repositories{
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }
}

subprojects{
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibilty = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21 
    }

    dependencies{
        //Lombok
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testCompileOnly("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")

        //Logs
        implementation("org.springframework.boot:sprint-boot-starter-logging")
        implementation("nets.logstash.logback:logstash-logback-encoder:7.4")

        //Testing
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.mockito:mockito-inline:5.2.0")
        testImplementation("org.testcontainers:testcontainers:1.19.4")

    }

    dependencyManagement{
        imports{
            mavenBom("org.springframework.cloud:sping-cloud-dependencies:$spingCloudVersion")

        }
    }

    tasks.withType<BootJar>("bootJar"){
        enabled = false
    }

    tasks.withType<Jar>("jar"){
        enabled = true
    }
}

//configurations
configer(subprojects.filter{ it.name != "shared"}){
    tasks.withType<BootJar>("bootJar"){
        enabled = true
    }

    tasks.withType<Jar>("jar"){
       enabled = false
    }
}

//services
tasks.register("buildAllServices"){
    dependsOn(
        ":api-gateway:build",
        ":services:user-service:build"
    )
}

tasks.register("test"){
    dependsOn(subprojects.map{ ${it.path}:test })
}