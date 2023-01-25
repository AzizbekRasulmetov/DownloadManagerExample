package com.azizbek.downloadmanagerexample

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.azizbek.downloadmanagerexample.downlaod.AndroidDownloader
import com.azizbek.downloadmanagerexample.ui.theme.DownloadManagerExampleTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val download = AndroidDownloader(this.applicationContext)
        setContent {
            DownloadManagerExampleTheme {
                // A surface container using the 'background' color from the theme

                val inputUrl = remember { mutableStateOf("") } //adb shell input text "https://pl-coding.com/wp-content/uploads/2022/04/pic-squared.jpg"

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Greeting("Android")
                        TextField(value = inputUrl.value, modifier = Modifier.fillMaxWidth(), onValueChange = {
                            inputUrl.value = it
                        })
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            onClick = { download.download(inputUrl.value) }, modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Download")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DownloadManagerExampleTheme {
        Greeting("Android")
    }
}