plugins {
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("java")
}

group = "com.aaa"
version = "1.0.0"

java{
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    //implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    //implementation("org.springframework.cloud:spring-cloud-starter-netflix-zuul")
    //implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("mysql:mysql-connector-java:5.1.38")
    
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    val springCloudVersion: String by project
    
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}
