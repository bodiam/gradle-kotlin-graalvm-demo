package org.example.graalvm.python

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value
import org.junit.jupiter.api.Test

class PythonTest {

    @Test
    fun executeJavascript() {
        Context.create().use { context ->
            val function: Value = context.eval("js", "x => x+1")
            assert(function.canExecute())
            val x: Int = function.execute(41).asInt()
            assert(x == 42)
        }
    }

    @Test
    fun executePython() {
        Context.create().use { context ->
            val function: Value = context.eval("python", "lambda x: x + 1")
            assert(function.canExecute())
            val x: Int = function.execute(41).asInt()
            assert(x == 42)
        }
    }
}