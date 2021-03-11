package com.akame.permissionmanager

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.akame.permission.PermissionManger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionManger.requestPermission(this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                object : PermissionManger.PermissionCallBack {
                    override fun success() {
                        Toast.makeText(this@MainActivity, "权限获取成功", Toast.LENGTH_SHORT).show()
                    }

                    override fun fail(permissions: ArrayList<String>) {
                        Toast.makeText(this@MainActivity, "权限获取失败  $permissions", Toast.LENGTH_SHORT).show()
                    }
                })
    }
}