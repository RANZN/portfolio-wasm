package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.presentation.components.cards.ProjectCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun ProjectsSection(projects: List<Project>, isLargeScreen: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("Projects")
        
        val columns = if (isLargeScreen) 2 else 1
        val chunkedProjects = projects.chunked((projects.size + columns - 1) / columns)
        
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            chunkedProjects.forEach { projectGroup ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    projectGroup.forEach { project ->
                        ProjectCard(project)
                    }
                }
            }
        }
    }
}