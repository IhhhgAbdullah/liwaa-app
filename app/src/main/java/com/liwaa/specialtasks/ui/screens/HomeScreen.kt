package com.liwaa.specialtasks.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.liwaa.specialtasks.R
import com.liwaa.specialtasks.data.SampleTicker
import com.liwaa.specialtasks.data.Section
import com.liwaa.specialtasks.ui.components.NewsTicker
import com.liwaa.specialtasks.ui.theme.LiwaaGold
import com.liwaa.specialtasks.ui.theme.LiwaaMuted
import com.liwaa.specialtasks.ui.theme.LiwaaRed
import com.liwaa.specialtasks.ui.theme.LiwaaSurface

@Composable
fun HomeScreen(onOpen: (Section) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        NewsTicker(items = SampleTicker)

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Image(
                    painter = painterResource(R.drawable.logo_liwaa),
                    contentDescription = "شعار اللواء",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
            }

            items(Section.entries) { section ->
                SectionCard(section = section, onClick = { onOpen(section) })
            }
        }
    }
}

@Composable
fun SectionCard(section: Section, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = LiwaaSurface),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(LiwaaRed)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = section.title,
                    color = LiwaaGold,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = section.subtitle,
                    color = LiwaaMuted,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
