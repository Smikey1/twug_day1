package com.twugteam.admin.day1

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.twugteam.admin.day1.di.BaseApp
import com.twugteam.admin.day1.di.Computer
import com.twugteam.admin.day1.di.UserRepository
import com.twugteam.admin.day1.ui.theme.Day1Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var computer: Computer

    @Inject
    lateinit var userRepository:UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day1Theme {

                // A surface container using the 'background' color from the theme
                computer.getStarted()
                userRepository.saveUser()
                App()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.HomeScreen.route
    ) {
        composable(NavRoute.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(NavRoute.MenuScreen.route) {
            MenuScreen(navController)
        }

        composable(NavRoute.LoginScreen.route) {
            LoginScreen(navController)
        }
    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var rememberMe = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Login Screen", color = Color.White)
                },
                modifier = Modifier.background(Color.Blue)

            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Email Field
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Email") },
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = "Email")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                // Password Field
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(Icons.Default.Lock, contentDescription = "Password")
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        // Handle login action
                    }),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                // Remember Me Switch
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Remember Me", modifier = Modifier.weight(1f))
                    Switch(
                        checked = rememberMe.value,
                        onCheckedChange = { isChecked ->
                            rememberMe.value = isChecked
                        }
                    )

                    Checkbox(
                        checked = rememberMe.value,
                        onCheckedChange = { isChecked ->
                            rememberMe.value = isChecked
                        }
                    )
                }

                // Login Button
                Button(
                    onClick = {
                        // Handle login button click
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Login")
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Green),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }

                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                }
            }
        }
    )
}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Button in the center
        Button(
            onClick = {
                      navController.navigate(NavRoute.LoginScreen.route)
            },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("First")
        }
    }
}


@Composable
fun MenuScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Button in the center
        Button(
            onClick = {  },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("Menu")
        }
    }
}

@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun Preview() {
    Day1Theme {
        App()
    }
}
