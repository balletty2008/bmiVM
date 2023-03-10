package com.example.bmivm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmivm.ui.theme.BmivmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmivmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BodyMassIndex()
                }
            }
        }
    }
}

@Composable
fun BodyMassIndex(bmiViewModel: BmiViewModel=viewModel()) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {                       //this: ColumnScope --take away
        Text(
            text = "Body mass index",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = bmiViewModel.heightInput,
            onValueChange = { bmiViewModel.changeHeightInput(it) }, //Update value if changed.
            label = { Text(text = stringResource(id = R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = bmiViewModel.weightInput,
            onValueChange = { bmiViewModel.changeWeightInput(it) }, //Update value if changed.
            label = { Text(text = stringResource(id = R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = stringResource(id = R.string.result, bmiViewModel.bmi.value)  //value
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BmivmTheme {
        BodyMassIndex()
    }
}