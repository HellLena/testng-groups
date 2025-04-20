plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.11.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-testng:2.1.20")

    testImplementation("io.github.microutils:kotlin-logging:3.0.5")
    testImplementation("ch.qos.logback:logback-classic:1.5.18")
}

tasks.test {
    useTestNG {
        val groups = System.getProperty("groups")
        if (groups != null) {
            println("provided test groups: $groups")
            includeGroups = groups.split(",").map { it.trim() }.toSet()
        }
        // Special listener for test method groups.
        // Just comment out this line to see the default TestNG behaviour for method selection by groups.
        listeners.add("org.example.testng.config.GroupsAlterSuiteListener")
    }
    testLogging {
        showStandardStreams = true
    }
}
kotlin {
    jvmToolchain(20)
}