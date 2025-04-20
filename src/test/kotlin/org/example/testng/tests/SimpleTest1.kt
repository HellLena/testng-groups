package org.example.testng.tests

import mu.KLogging
import org.example.testng.config.TestGroups.GROUP1
import org.example.testng.config.TestGroups.GROUP2
import org.testng.annotations.Test

@Test(
    testName = "Simple test #1"
)
class SimpleTest1 {
    @Test(groups = [GROUP1])
    fun testGroup1() {
        logger.debug { "Running test #1 for groups: $GROUP1" }
    }

    @Test(groups = [GROUP2])
    fun testGroup2() {
        logger.debug { "Running test #1 for groups: $GROUP2" }
    }

    @Test(groups = [GROUP1, GROUP2])
    fun testGroup1And2() {
        logger.debug { "Running test #1 for groups: $GROUP1, $GROUP2" }
    }

    companion object : KLogging()
}
