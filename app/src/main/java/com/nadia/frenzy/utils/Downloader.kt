package com.nadia.frenzy.utils

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

object Downloader {

    fun downloadImage(context: Context, url : String){
        val request = DownloadManager.Request(Uri.parse(url))
        request.setTitle("Download Image")
        request.setDescription("Download Image from Frenzy app")
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "frenzy")
        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
        manager!!.enqueue(request)
    }
}