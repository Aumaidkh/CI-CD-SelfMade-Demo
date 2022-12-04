package com.implecode.ci_cd_demo_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.implecode.ci_cd_demo_project.HelperMethods.calculateSum
import com.implecode.ci_cd_demo_project.ui.theme.CICDDemoProjectTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CICDDemoProjectTheme {

                var number1 by remember{
                    mutableStateOf("0")
                }


                var number2 by remember{
                    mutableStateOf("0")
                }

                var sum by remember {
                    mutableStateOf("Enter the two numbers")
                }


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppCenter.start(application,"5ef53e1d-2c4e-4246-99c2-84262fc81482",Analytics::class.java,Crashes::class.java)
                    Box(contentAlignment = Alignment.Center) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(text = sum)
                            Spacer(modifier = Modifier.height(24.dp))
                            TextField(value = number1, onValueChange ={ number1 = it}, label = {
                                Text(text = "Number 1")
                            })
                            Spacer(modifier = Modifier.height(24.dp))
                            TextField(value = number2, onValueChange ={ number2 = it}, label = {
                                Text(text = "Number 2")
                            })
                            Spacer(modifier = Modifier.height(34.dp))
                            Button(onClick = {
                                 sum = "The Result is: ${calculateSum(number1, number2)}"
                            }) {
                                Text(text = "Calculate")
                            }
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
    CICDDemoProjectTheme {
        Greeting("Android")
    }
}