pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
		// 네이버지도 SDK repository (복수 URL 시도)
		maven {
			url = uri("https://repository.map.naver.com/archive/maven")
		}
		maven {
			url = uri("https://naver.jfrog.io/artifactory/maven/")
		}
	}
}

rootProject.name = "hospitalapp"
include(":app")
