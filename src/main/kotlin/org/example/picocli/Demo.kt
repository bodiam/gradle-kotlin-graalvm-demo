package org.example.picocli

import picocli.CommandLine
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@CommandLine.Command(
    name = "demo",
    subcommands = [DemoCommand::class]
)
class Demo : Callable<Int> {
    override fun call(): Int = 0
}

fun main(args: Array<String>) = when {
    args.isEmpty() -> CommandLine(Demo()).usage(System.err)
    else -> exitProcess(CommandLine(Demo()).execute(*args))
}

@CommandLine.Command(
    name="demo",
    description = ["Demo of Picocli, Kotlin and Gradle on GraalVM"]
)
class DemoCommand : Runnable {
    override fun run() {
        println("Demo success!")
    }

}