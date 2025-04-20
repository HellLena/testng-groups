package org.example.testng.config

import org.testng.IAlterSuiteListener
import org.testng.xml.XmlMethodSelector
import org.testng.xml.XmlSuite

/**
 * This implementation is an alternative to xml configuration.
 * It just adds groups method selector [GroupsMethodSelector] to every test method.
 * !Important: this method selector should have priority higher than standard [XmlMethodSelector]
 *             that's why it was set to MAX value.
 */
class GroupsAlterSuiteListener : IAlterSuiteListener {
    override fun alter(suites: MutableList<XmlSuite>) {
        val methodSelector = XmlMethodSelector()
        methodSelector.setElement(GroupsMethodSelector::class.qualifiedName, Int.MAX_VALUE.toString())

        suites.forEach { suite ->
            suite.tests.forEach { test ->
                test.methodSelectors.add(methodSelector)
            }
        }
    }
}
