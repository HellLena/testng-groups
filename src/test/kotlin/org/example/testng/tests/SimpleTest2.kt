package org.example.testng.tests

import mu.KLogging
import org.example.testng.config.TestGroups.GROUP1
import org.example.testng.config.TestGroups.GROUP3
import org.testng.annotations.Test

@Test(
    testName = "Simple test #2",
    groups = [GROUP1],
)
class SimpleTest2 {
    @Test(groups = [GROUP3])
    fun testGroup1And3() {
        logger.debug { "Running test #2 for groups: $GROUP1, $GROUP3" }
    }

    companion object : KLogging()
}
