plugins {
    `java-library`
    id("com.atlassian.performance.tools.gradle-release").version("0.7.1")
}

tasks.wrapper {
    gradleVersion = "6.7"
    distributionType = Wrapper.DistributionType.BIN
}

configurations.all {
    resolutionStrategy {
        activateDependencyLocking()
        failOnVersionConflict()
    }
}

dependencies {
    implementation("net.jcip:jcip-annotations:1.0")
    implementation("io.atlassian.util.concurrent:atlassian-util-concurrent:4.0.1")
    implementation("org.postgresql:postgresql:42.2.18")
    implementation("org.apache.commons:commons-lang3:3.11")
    testImplementation("junit:junit:4.12")
    testImplementation("org.assertj:assertj-core:3.18.1")
    testImplementation("org.mockito:mockito-core:3.6.0")
}

tasks.compileJava {
    options.compilerArgs.add("-Xlint:deprecation")
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.withType<Test> {
    reports {
        junitXml.isEnabled = true
    }
}

group = "com.atlassian.db.replica"

gradleRelease {
    atlassianPrivateMode = true
}
