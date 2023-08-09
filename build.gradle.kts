import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    id("org.jetbrains.kotlin.multiplatform").version("1.9.0")
}

kotlin {
    explicitApi = ExplicitApiMode.Warning

    jvm {
        jvmToolchain(11)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js {
        nodejs {
            testTask(Action {
                useMocha {
                    timeout = "0"
                }
            })
        }

        useCommonJs()
        binaries.library()
        generateTypeScriptDefinitions()
    }
}
