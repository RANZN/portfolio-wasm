package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun AboutSection(profile: Profile, isLargeScreen: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("About Me")
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                profile.aboutDescription.forEach { paragraph ->
                    Text(
                        text = paragraph,
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 28.sp
                    )
                    if (paragraph != profile.aboutDescription.last()) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}