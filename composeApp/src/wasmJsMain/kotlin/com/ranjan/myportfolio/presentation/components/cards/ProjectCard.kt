package com.ranjan.myportfolio.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Project

@Composable
fun ProjectCard(project: Project) {
    val uriHandler = LocalUriHandler.current
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = { uriHandler.openUri(project.link) }
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = project.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(project.technologies) { tech ->
                    AssistChip(
                        onClick = { },
                        label = { Text(tech, fontSize = 12.sp) }
                    )
                }
            }
        }
    }
}