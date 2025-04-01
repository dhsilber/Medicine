package app.medicines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.medicines.ui.Navigation
import app.medicines.ui.theme.MedicinesTheme

class MedicinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicinesTheme {
                Navigation()
            }
        }
    }
}
