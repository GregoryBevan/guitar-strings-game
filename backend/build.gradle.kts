buildscript {
	val kotlinVersion = "1.1.0"
	val springBootVersion = "2.0.0.BUILD-SNAPSHOT"

	repositories {
		jcenter()
		maven { setUrl("https://repo.spring.io/snapshot") }
		maven { setUrl("https://repo.spring.io/milestone") }
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
		classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
	}
}

apply {
	plugin("kotlin")
	plugin("kotlin-spring")
	plugin("org.springframework.boot")
}

repositories {
	jcenter()
	maven { setUrl("https://repo.spring.io/snapshot") }
	maven { setUrl("https://repo.spring.io/milestone") }
}

dependencies {
	compile(kotlinModule("stdlib"))
	compile(kotlinModule("reflect"))
	compile("org.springframework.boot:spring-boot-starter-aop")
	//compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("org.springframework.boot:spring-boot-starter-jersey")
	compile("org.springframework.boot:spring-boot-starter-web")
	testCompile("org.springframework.boot:spring-boot-starter-test")
}