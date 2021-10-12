plugins {
    id(Plugins.LIB_JAVA)
    id(Plugins.LIB_KOTLIN)
    kotlin(Plugins.SERIALIZATION) version BuildPluginsVersions.KOTLIN
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Core.KOTLINX_COROUTINES) // TODO: remove?

    implementation(Utils.KOTLIN_SERIALIZATION)

    implementation(Server.KTOR_CLIENT_CORE)
    implementation(Server.KTOR_CLIENT_ANDROID)
    implementation(Server.KTOR_CLIENT_SERIALIZATION)
    implementation(Server.KTOR_CLIENT_LOGGING)
    implementation(Server.LOGBACK)

    testImplementation(Testing.KOTEST_RUNNER)
    testImplementation(Testing.KOTEST_JUNIT_RUNNER)
    testImplementation(Testing.KOTEST_ASSERTIONS)
    testImplementation(Testing.KOTEST_EXTENSIONS_ARROW)
    testImplementation(Testing.KOTEST_PROPERTIES)
    testImplementation(Testing.MOCKK)
    testImplementation(Testing.KOTLINX_COROUTINES_TEST)
}
