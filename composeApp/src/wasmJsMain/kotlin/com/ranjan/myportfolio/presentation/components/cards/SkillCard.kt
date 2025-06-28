package com.ranjan.myportfolio.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Skill

@Composable
fun SkillCard(skill: Skill) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = skill.icon,
                    contentDescription = skill.name,
                    modifier = Modifier.size(20.dp)
                )
                Text(skill.name, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.weight(1f))
                Text("${(skill.level * 100).toInt()}%", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { skill.level },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}