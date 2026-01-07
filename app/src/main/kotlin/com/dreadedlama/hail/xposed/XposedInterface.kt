package com.dreadedlama.hail.xposed

import com.dreadedlama.hail.BuildConfig
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam

class XposedInterface : IXposedHookLoadPackage {
    @Throws(Throwable::class)
    override fun handleLoadPackage(loadPackageParam: LoadPackageParam) {
        if (!loadPackageParam.isFirstApplication) {
            return
        }

        if (loadPackageParam.packageName == BuildConfig.APPLICATION_ID) {
            return
        }

        LaunchAppHook(loadPackageParam.classLoader).startHook()
    }

    abstract class BaseHook(protected val classLoader: ClassLoader) {
        abstract fun startHook()
    }
}
