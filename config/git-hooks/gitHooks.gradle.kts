tasks.register<Copy>("copyGitHooks") {
    description = "Copy git hooks from $rootDir/config/git-hooks to .git folder"
    from("$rootDir/config/git-hooks") {
        include("**/*.sh")
        rename("(.*).sh", "$1")
    }
    into("$rootDir/.git/hooks")
}

tasks.register<Exec>("installGitHooks") {
    description = "Installs pre-commit git hooks from $rootDir/config/git-hoots to project"
    group = "git hooks"
    workingDir = rootDir
    commandLine = listOf("chmod")
    args(listOf("-R", "+x", ".git/hooks"))
    dependsOn(setOf("copyGitHooks"))
    doLast {
        println("Installed git hooks successfully")
    }
}
