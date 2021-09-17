tasks.register<GradleBuild>("preCommit") {
    description = "Runs all tasks needed to verify commit"
    group = "git hooks"
    tasks = listOf("detekt")
    doLast {
        println("Task preCommit finished sucessfully")
    }
}
