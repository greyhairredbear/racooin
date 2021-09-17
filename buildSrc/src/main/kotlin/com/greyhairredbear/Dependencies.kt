import Versions.KOTEST_VERSION
import Versions.MOCKK_VERSION
import Versions.KOTLIN_COROUTINES_VERSION
import Core.KOTLINX_GROUP
import Versions.ANDROID_MATERIAL_VERSION
import Versions.ARROW_VERSION
import Versions.BUILD_TOOLS_VERSION
import Versions.COMPOSE_VERSION
import Versions.KTOR_VERSION
import Versions.SUPPORT_ACTIVITY_VERSION

object Versions {
    const val BUILD_TOOLS_VERSION = "7.0.2"
    const val KOTLIN_COROUTINES_VERSION = "1.5.1"

    const val ARROW_VERSION = "0.13.2"
    const val KTOR_VERSION = "1.6.2"

    const val KOTEST_VERSION = "4.6.2"
    const val MOCKK_VERSION = "1.12.0"

    const val COMPOSE_VERSION = "1.0.1"
    const val SUPPORT_ACTIVITY_VERSION = "1.4.0-alpha01"
    const val APP_COMPAT_VERSION = "1.2.0"
    const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
    const val CORE_KTX_VERSION = "1.6.0"
    const val ANDROID_MATERIAL_VERSION = "1.4.0"

    const val ANDROIDX_TEST_EXT_VERSION = "1.1.2"
    const val ANDROIDX_TEST_VERSION = "1.3.0"
    const val ESPRESSO_CORE_VERSION = "3.3.0"
}

object BuildPluginsVersions {
    const val ANDROID_GRADLE_PLUGIN = "7.0.2"
    const val DETEKT = "1.18.1"
    const val KOTLIN = "1.5.21"
}

object Plugins {
    const val KOTLIN = "org.jetbrains.kotlin.jvm"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val ANDROID = "android"

    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:$BUILD_TOOLS_VERSION"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildPluginsVersions.KOTLIN}"
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"

}

object Sdk {
    const val COMPILE_SDK_VERSION = 31
    const val TARGET_SDK_VERSION = 31
    const val MIN_SDK_VERSION = 23
}

object Core {
    private const val ARROW_GROUP = "io.arrow-kt"
    const val KOTLINX_GROUP = "org.jetbrains.kotlinx"

    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val KOTLINX_COROUTINES = "$KOTLINX_GROUP:kotlinx-coroutines-core:$KOTLIN_COROUTINES_VERSION"

    const val ARROW_CORE = "$ARROW_GROUP:arrow-core:$ARROW_VERSION"
    const val ARROW_FX = "$ARROW_GROUP:arrow-fx:$ARROW_VERSION"
    const val ARROW_OPTICS = "$ARROW_GROUP:arrow-optics:$ARROW_VERSION"
    const val ARROW_SYNTAX = "$ARROW_GROUP:arrow-syntax:$ARROW_VERSION"
    const val ARROW_META = "$ARROW_GROUP:arrow-meta:$ARROW_VERSION"
}

object Server {
    private const val KTOR_GROUP = "io.ktor"

    const val KTOR_CLIENT_CORE = "$KTOR_GROUP:ktor-client-core:$KTOR_VERSION"
    const val KTOR_CLIENT_CIO = "$KTOR_GROUP:ktor-client-cio:$KTOR_VERSION" // TODO: needed?
    const val KTOR_CLIENT_ANDROID = "$KTOR_GROUP:ktor-client-android:$KTOR_VERSION"
    const val KTOR_CLIENT_SERIALIATION = "$KTOR_GROUP:ktor-client-serialization:$KTOR_VERSION"
}

object SupportLibs {
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "com.android.support.constraint:constraint-layout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val ANDROIDX_ACTIVITY = "androidx.activity:activity-compose:$SUPPORT_ACTIVITY_VERSION"
}

object Compose {
    private const val COMPOSE_UI_GROUP = "androidx.compose.ui"
    private const val COMPOSE_MAT_GROUP = "androidx.compose.material"
    private const val COMPOSE_FOUNDATION_GROUP = "androidx.compose.foundation"

    const val COMPOSE_UI = "$COMPOSE_UI_GROUP:ui:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL = "$COMPOSE_MAT_GROUP:material:$COMPOSE_VERSION"
    const val COMPOSE_UI_TOOLING = "$COMPOSE_UI_GROUP:ui-tooling:$COMPOSE_VERSION"
    const val COMPOSE_UI_TOOLING_PREVIEW = "$COMPOSE_UI_GROUP:ui-tooling-preview:$COMPOSE_VERSION"
    const val COMPOSE_FOUNDATION = "$COMPOSE_FOUNDATION_GROUP:foundation:$COMPOSE_VERSION"
}

object GoogleLibs {
    const val ANDROID_MATERIAL = "com.google.android.material:material:$ANDROID_MATERIAL_VERSION"
}

object Testing {
    private const val KOTEST_GROUP = "io.kotest"
    const val KOTEST_RUNNER = "$KOTEST_GROUP:kotest-runner-junit5-jvm:$KOTEST_VERSION"
    const val KOTEST_JUNIT_RUNNER = "$KOTEST_GROUP:kotest-runner-junit5:$KOTEST_VERSION"
    const val KOTEST_ASSERTIONS = "$KOTEST_GROUP:kotest-assertions-core-jvm:$KOTEST_VERSION"
    const val KOTEST_PROPERTIES = "$KOTEST_GROUP:kotest-property-jvm:$KOTEST_VERSION"

    const val MOCKK = "io.mockk:mockk:$MOCKK_VERSION"

    const val KOTLINX_COROUTINES_TEST = "$KOTLINX_GROUP:kotlinx-coroutines-test:$KOTLIN_COROUTINES_VERSION"
}

object AndroidTesting {
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST_VERSION}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST_VERSION}"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_EXT_VERSION}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"
}
