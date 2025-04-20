package org.example.testng.config

import org.testng.IMethodSelector
import org.testng.IMethodSelectorContext
import org.testng.ITestNGMethod

/**
 * This implementation filters out tests which does not contain ALL of required groups to include.
 */
class GroupsMethodSelector : IMethodSelector {
    override fun includeMethod(
        context: IMethodSelectorContext,
        method: ITestNGMethod,
        isTestMethod: Boolean,
    ): Boolean {
        if (!method.isTest) return true
        return method.xmlTest.includedGroups.isEmpty()
                || method.groups.toSet().containsAll(method.xmlTest.includedGroups)
    }

    override fun setTestMethods(p0: MutableList<ITestNGMethod>?) {
        // nothing to do
    }
}
