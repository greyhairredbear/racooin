plugins {
    id(Plugins.LIB_JAVA)
    id(Plugins.LIB_KOTLIN)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    api(Core.ARROW_CORE)
    implementation(Core.STD_LIB)
    implementation(Core.KOTLINX_COROUTINES)

    testImplementation(Testing.KOTEST_RUNNER)
    testImplementation(Testing.KOTEST_JUNIT_RUNNER)
    testImplementation(Testing.KOTEST_ASSERTIONS)
    testImplementation(Testing.KOTEST_EXTENSIONS_ARROW)
    testImplementation(Testing.KOTEST_PROPERTIES)
    testImplementation(Testing.MOCKK)
    testImplementation(Testing.KOTLINX_COROUTINES_TEST)
}
