package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import org.junit.Assert
import org.junit.Test
import timber.log.Timber

class LogHandlerTest {
    lateinit var testTree: TestTree

    @Test
    fun `given a log message is debug then should be logged as debug`() {
        initLogHandler()
        LogHandler.d(logMessage)
        val lastLoggedEvent = testTree.logs.last()

        Assert.assertEquals(logMessage, lastLoggedEvent.message)
        Assert.assertEquals(Priorities.DEBUG.priorityLevel, lastLoggedEvent.priority)
    }

    @Test
    fun `given a log message is warning then should be logged as warning`() {
        initLogHandler()
        LogHandler.w(logMessage)
        val lastLoggedEvent = testTree.logs.last()

        Assert.assertEquals(logMessage, lastLoggedEvent.message)
        Assert.assertEquals(Priorities.WARNING.priorityLevel, lastLoggedEvent.priority)
    }

    @Test
    fun `given a log message is error then should be logged as error`() {
        initLogHandler()
        LogHandler.e(throwable = null, message = logMessage)
        val lastLoggedEvent = testTree.logs.last()

        Assert.assertEquals(logMessage, lastLoggedEvent.message)
        Assert.assertEquals(Priorities.ERROR.priorityLevel, lastLoggedEvent.priority)
    }

    @Test
    fun `given a log throwable then should be logged as error`() {
        initLogHandler()
        val throwable = NullPointerException()
        LogHandler.e(throwable = throwable)
        val lastLoggedEvent = testTree.logs.last()

        Assert.assertEquals(throwable, lastLoggedEvent.t)
        Assert.assertEquals(Priorities.ERROR.priorityLevel, lastLoggedEvent.priority)
    }

    @Test
    fun `given a log message is info then should be logged as info`() {
        initLogHandler()
        LogHandler.i(throwable = null, message = logMessage)
        val lastLoggedEvent = testTree.logs.last()

        Assert.assertEquals(logMessage, lastLoggedEvent.message)
        Assert.assertEquals(Priorities.INFO.priorityLevel, lastLoggedEvent.priority)
    }

    private fun initLogHandler() {
        testTree = TestTree()
        LogHandler.init(testTree)
    }

    companion object {
        const val logMessage = "This is a simple log message"

        /**
         * Enum containing all log priority levels
         */
        enum class Priorities(val priorityLevel: Int) {
            DEBUG(3),
            INFO(4),
            WARNING(5),
            ERROR(6)
        }
    }
}

/**
 * This class is used to mock timber tree for test purposes
 */
class TestTree : Timber.Tree() {
    /**
     * Simulates the console log history stack
     */
    val logs = mutableListOf<Log>()

    /**
     * Add a message to the internal history stacktrace stack
     */
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        logs.add(Log(priority, tag, message, t))
    }

    /**
     * Modeling a log message to add into the history stacktrace stack
     */
    data class Log(val priority: Int, val tag: String?, val message: String, val t: Throwable?)
}
