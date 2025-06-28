package com.ranjan.myportfolio.presentation.components.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.NavigationSection

@Composable
fun TopNavigationBar(
    navigationSections: List<NavigationSection>,
    selectedSection: String,
    onSectionSelected: (String) -> Unit,
    isCompact: Boolean
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 4.dp
    ) {
        if (isCompact) {
            LazyRow(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(navigationSections) { section ->
                    FilterChip(
                        onClick = { onSectionSelected(section.name) },
                        label = { 
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = section.icon,
                                    contentDescription = section.name,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(section.name)
                            }
                        },
                        selected = selectedSection == section.name
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                navigationSections.forEach { section ->
                    TextButton(
                        onClick = { onSectionSelected(section.name) },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = if (selectedSection == section.name) 
                                MaterialTheme.colorScheme.primary 
                            else MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = section.icon,
                                contentDescription = section.name,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                section.name, 
                                fontWeight = if (selectedSection == section.name) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }
    }
}