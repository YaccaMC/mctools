plugins {
    id("java")
}

group = "me.yaccamc.mctools"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("com.squareup.okhttp3:okhttp:5.1.0")
    implementation("net.lingala.zip4j:zip4j:2.11.5")
}

tasks.test {
    useJUnitPlatform()
}
