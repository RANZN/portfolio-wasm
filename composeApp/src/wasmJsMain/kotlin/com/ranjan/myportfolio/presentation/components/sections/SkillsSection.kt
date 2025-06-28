package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Skill
import com.ranjan.myportfolio.presentation.components.cards.SkillCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun SkillsSection(skills: List<Skill>, isLargeScreen: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("Skills")
        
        val columns = if (isLargeScreen) 2 else 1
        val chunkedSkills = skills.chunked((skills.size + columns - 1) / columns)
        
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            chunkedSkills.forEach { skillGroup ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    skillGroup.forEach { skill ->
                        SkillCard(skill)
                    }
                }
            }
        }
    }
}