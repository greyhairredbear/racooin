plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
    id(Plugins.PROTOBUF) version BuildPluginsVersions.PROTOBUF
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

android {
    namespace = "com.greyhairredbear.racooin"

    compileSdk = 34

    defaultConfig {
        minSdk = 26
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        warningsAsErrors = true
        abortOnError = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Core.KOTLINX_COROUTINES)
    implementation(Protobuf.PROTOBUF_JAVA_LITE)
    implementation(Android.ANDROIDX_DATASTORE)

    implementation(Android.ANDROIDX_CORE_KTX)
    implementation(Android.ANDROIDX_ACTIVITY)
    implementation (GoogleLibs.ANDROID_MATERIAL)

    testImplementation(Testing.KOTEST_RUNNER)
    testImplementation(Testing.KOTEST_JUNIT_RUNNER)
    testImplementation(Testing.KOTEST_ASSERTIONS)
    testImplementation(Testing.KOTEST_EXTENSIONS_ARROW)
    testImplementation(Testing.KOTEST_PROPERTIES)
    testImplementation(Testing.MOCKK)
    testImplementation(Testing.KOTLINX_COROUTINES_TEST)

    androidTestImplementation(AndroidTesting.ANDROIDX_TEST_RUNNER)
    androidTestImplementation(AndroidTesting.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(AndroidTesting.ANDROIDX_TEST_RULES)
}

protobuf {
    protoc {
        artifact = Protobuf.PROTOBUF_PROTOC
    }

    // Generates the java Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
    // for more information.
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}
