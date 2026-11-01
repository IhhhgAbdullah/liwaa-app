package com.liwaa.specialtasks.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.liwaa.specialtasks.ui.theme.LiwaaRed
import com.liwaa.specialtasks.ui.theme.LiwaaWhite

@Composable
fun NewsTicker(items: List<String>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(LiwaaRed)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Text(
            text = items.joinToString("     ●     "),
            color = LiwaaWhite,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Clip,
            modifier = Modifier.basicMarquee()
        )
    }
}
