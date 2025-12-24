package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.presentation.components.cards.ProjectCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.ui.design.DesignSystem

@Composable
fun ProjectsSection(projects: List<Project>, isLargeScreen: Boolean) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitle("Projects")
        
        val columns = if (isLargeScreen) 2 else 1
        val chunkedProjects = if (columns > 1) {
            projects.chunked((projects.size + columns - 1) / columns)
        } else {
            listOf(projects)
        }
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
            modifier = Modifier.fillMaxWidth()
        ) {
            chunkedProjects.forEach { projectGroup ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
                ) {
                    projectGroup.forEach { project ->
                        ProjectCard(project)
                    }
                }
            }
        }
    }
}