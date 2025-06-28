package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.presentation.components.cards.EducationCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun EducationSection(education: List<Education>, isLargeScreen: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("Education")
        
        education.forEach { edu ->
            EducationCard(edu)
        }
    }
}