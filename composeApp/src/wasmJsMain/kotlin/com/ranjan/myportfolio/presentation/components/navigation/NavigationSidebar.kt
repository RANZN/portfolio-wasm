package com.ranjan.myportfolio.presentation.components.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import org.jetbrains.compose.resources.painterResource
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.compose_multiplatform

@Composable
fun NavigationSidebar(
    profile: Profile,
    navigationSections: List<NavigationSection>,
    selectedSection: String,
    onSectionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxHeight(),
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileSection(profile = profile)
            
            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))
            
            navigationSections.forEach { section ->
                NavigationDrawerItem(
                    icon = { 
                        Icon(
                            imageVector = section.icon,
                            contentDescription = section.name
                        )
                    },
                    label = { Text(section.name) },
                    selected = selectedSection == section.name,
                    onClick = { onSectionSelected(section.name) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun ProfileSection(profile: Profile) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = profile.name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profile.title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}