package com.akame.permission

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

object PermissionManger {

    interface PermissionCallBack {
        fun success()

        fun fail(permissions: ArrayList<String>)
    }

    fun requestPermission(
        activity: FragmentActivity,
        permissions: Array<String>,
        permissionCallBack: PermissionCallBack
    ) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            //6.0以下系统 直接返回成功 不需要动态获取权限
            permissionCallBack.success()
        } else {
            val permissionFragment = PermissionFragment()
            permissionFragment.arguments = Bundle().apply {
                putStringArray("permissions", permissions)
            }
            permissionFragment.permissionCallBack = permissionCallBack
            activity.supportFragmentManager.beginTransaction()
                .add(permissionFragment, activity::class.java.simpleName).commit()
        }
    }
}