import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "seg3102-team3"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.junit.platform:junit-platform-suite:1.8.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.cucumber:cucumber-java8:7.3.3")
	testImplementation("io.cucumber:cucumber-spring:7.3.3")
	testImplementation("io.cucumber:cucumber-junit-platform-engine:7.3.3")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:14.0.0")
	testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:14.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}