import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories { gradleScriptKotlin() }
    dependencies { classpath(kotlinModule("gradle-plugin")) }
}


allprojects {
    group = "fr.elgregos.guitar"
    version = "1.0.0-SNAPSHOT"

    repositories {
        gradleScriptKotlin()
    }
}


// Configure all KotlinCompile tasks on each sub-project
subprojects {

    tasks.withType<KotlinCompile> {
        println("Configuring $name in project ${project.name}...")
        kotlinOptions {
            suppressWarnings = true
        }
    }
}

apply {
    plugin("base")
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}