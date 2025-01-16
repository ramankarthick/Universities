package com.app.universities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.universities.model.UniversitiesViewModel
import com.app.universities.repository.Universities
import com.app.universities.ui.theme.UniversitiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: UniversitiesViewModel = hiltViewModel()
            UniversitiesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UniversityListScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UniversitiesTheme {
        Greeting("Android")
    }
}

@Composable
fun UniversityListScreen(viewModel: UniversitiesViewModel) {
    val universities = viewModel.universities
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Universities", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 30.sp))
        LazyColumn {
            items(universities) { university ->
                UniversityListItem(university)
            }
        }
    }
}

@Composable
fun UniversityListItem(university: Universities) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = university.name, fontWeight = FontWeight.Bold)
        Text(text = university.country)
    }
}