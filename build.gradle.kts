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

//buildscript {
//	ext {
//		kotlinVersion = '1.1.0'
//		springBootVersion = '2.0.0.BUILD-SNAPSHOT'
//	}
//	repositories {
//		mavenCentral()
//		maven { url "https://repo.spring.io/snapshot" }
//		maven { url "https://repo.spring.io/milestone" }
//	}
//	dependencies {
//		classpath(kotlinModule("gradle-plugin", ${kotlinVersion}))
//		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
//		//classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
//		classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
//	}
//}

//subprojects() {
//
//	apply {
//		plugin("kotlin")
//		plugin("kotlin-spring")
//		plugin("eclipse")
//		plugin("org.springframework.boot")
//	}
//
//	repositories {
//		gradleScriptKotlin()
//	}
//
//	dependencies {
//		compile(kotlinModule("stdlib", kotlin_version))
//		testCompile("junit:junit:4.11")
//		testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
//	}
//
//}

//jar {
//	baseName = 'guitar-strings-game'
//	version = '1.0.0-SNAPSHOT'
//}
//
//sourceCompatibility = 1.8
//
//repositories {
//	mavenCentral()
//	maven { url "https://repo.spring.io/snapshot" }
//	maven { url "https://repo.spring.io/milestone" }
//}
//
//
//dependencies {
//	compile('org.springframework.boot:spring-boot-starter-aop')
//	compile('org.springframework.boot:spring-boot-starter-data-jpa')
//	compile('org.springframework.boot:spring-boot-starter-jersey')
//	compile('org.springframework.boot:spring-boot-starter-web')
//	compile("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
//	compile("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
//	testCompile('org.springframework.boot:spring-boot-starter-test')
//}
