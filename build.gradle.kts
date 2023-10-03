plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "edu.cegepvicto"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
}

application {
    mainClass.set("edu.cegepvicto.LanceurKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)

}