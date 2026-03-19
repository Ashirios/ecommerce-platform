plugins{
    id("java-library")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar"){
    enabled = false
}

tasks.getByName<Jar>("jar"){
    enabled = true
}

dependencies{
    //Spring
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    //Validatiom
    api("org.springframework.boot:spring-boot-starter-validation")

    
    //Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test{
    useJUnitPlatform()
}