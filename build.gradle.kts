plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.6.0"
    application
}

group = "edu.cegepvicto"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(kotlin("reflect"))
}

application {
    mainClass.set("edu.cegepvicto.architectures.LanceurKt")
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