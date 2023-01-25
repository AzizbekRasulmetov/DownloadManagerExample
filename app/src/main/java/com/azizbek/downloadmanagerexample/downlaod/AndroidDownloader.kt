package com.azizbek.downloadmanagerexample.downlaod

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi

class AndroidDownloader(private val context: Context) : IDownload {

    @RequiresApi(Build.VERSION_CODES.M)
    private val downloadManager = context.getSystemService(DownloadManager::class.java) as DownloadManager


    @RequiresApi(Build.VERSION_CODES.M)
    override fun download(url: String): Long {
        val request = DownloadManager.Request((Uri.parse(url)))
            .setMimeType("image/jpeg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("image.jpeg")
            .setDescription("Image downloaded")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "image.jpeg")
        return downloadManager.enqueue(request)
    }
}