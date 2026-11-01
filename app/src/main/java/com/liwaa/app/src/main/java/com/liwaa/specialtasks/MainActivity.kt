package com.liwaa.specialtasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.liwaa.specialtasks.data.Section
import com.liwaa.specialtasks.ui.screens.HomeScreen
import com.liwaa.specialtasks.ui.screens.SectionScreen
import com.liwaa.specialtasks.ui.theme.LiwaaBlack
import com.liwaa.specialtasks.ui.theme.LiwaaGold
import com.liwaa.specialtasks.ui.theme.LiwaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiwaaTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    AppRoot()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot() {
    var current by rememberSaveable { mutableStateOf<Section?>(null) }

    BackHandler(enabled = current != null) { current = null }

    Scaffold(
        containerColor = LiwaaBlack,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = current?.title ?: "لواء المهمات الخاصة الأول",
                        color = LiwaaGold,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    if (current != null) {
                        IconButton(onClick = { current = null }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "رجوع",
                                tint = LiwaaGold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LiwaaBlack,
                    titleContentColor = LiwaaGold
                )
            )
        }
    ) { padding ->
        val section = current
        if (section == null) {
            HomeScreen(
                modifier = Modifier.padding(padding),
                onOpen = { current = it }
            )
        } else {
            SectionScreen(
                section = section,
                modifier = Modifier.padding(padding)
            )
        }
    }
}
