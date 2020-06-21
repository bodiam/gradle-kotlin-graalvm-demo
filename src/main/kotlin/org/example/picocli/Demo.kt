package org.example.picocli

import picocli.CommandLine
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@CommandLine.Command(
    name = "demo",
    subcommands = [TextCommand::class]
)
class Demo : Callable<Int> {
    override fun call(): Int = 0
}

fun main(args: Array<String>) = when {
    args.isEmpty() -> CommandLine(Demo()).usage(System.err)
    else -> exitProcess(CommandLine(Demo()).execute(*args))
}

@CommandLine.Command(
    name="text",
    description = ["Demo of Picocli, Kotlin and Gradle on GraalVM"]
)
class TextCommand : Runnable {
    override fun run() {

        val resource = Demo::class.java.getResource("/demo.txt")
        val content  = resource.readText()

        println("Demo success! $content")
    }
}