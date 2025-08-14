plugins {
    java
    `maven-publish`
}

group = "me.yaccamc.mctools"
version = "0.1.1"

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.test {
    useJUnitPlatform()
}

java {
    withJavadocJar()
    withSourcesJar()

    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}

publishing {
    repositories {
        maven("https://repo.menthamc.com/repository/maven-releases/") {
            credentials(PasswordCredentials::class)
            name = "yacca"
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("com.squareup.okhttp3:okhttp:5.1.0")
    implementation("net.lingala.zip4j:zip4j:2.11.5")
}
