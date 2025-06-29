package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.SimpleIcons
import compose.icons.feathericons.*
import compose.icons.simpleicons.*
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun ContactSection(contactInfo: ContactInfo, isLargeScreen: Boolean) {
    val uriHandler = LocalUriHandler.current

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("Contact Me")

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Let's work together!",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "I'm always interested in new opportunities and exciting projects. Feel free to reach out!",
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Create list of available contact methods
                val contactMethods = buildList {
                    // Email (always available)
                    add(
                        ContactMethod(
                            icon = FeatherIcons.Mail,
                            label = "Email",
                            action = { uriHandler.openUri("mailto:${contactInfo.email}") }
                        )
                    )
                    
                    // LinkedIn (always available)
                    add(
                        ContactMethod(
                            icon = SimpleIcons.Linkedin,
                            label = "LinkedIn",
                            action = { uriHandler.openUri(contactInfo.linkedin) }
                        )
                    )
                    
                    // GitHub (always available)
                    add(
                        ContactMethod(
                            icon = SimpleIcons.Github,
                            label = "GitHub",
                            action = { uriHandler.openUri(contactInfo.github) }
                        )
                    )
                    
                    // Twitter (only if available)
                    contactInfo.twitter?.let { twitterUrl ->
                        add(
                            ContactMethod(
                                icon = SimpleIcons.Twitter,
                                label = "Twitter",
                                action = { uriHandler.openUri(twitterUrl) }
                            )
                        )
                    }
                    
                    // Medium (only if available)
                    contactInfo.medium?.let { mediumUrl ->
                        add(
                            ContactMethod(
                                icon = SimpleIcons.Medium,
                                label = "Medium",
                                action = { uriHandler.openUri(mediumUrl) }
                            )
                        )
                    }
                }

                if (isLargeScreen) {
                    // Large screen - arrange in rows (2 columns)
                    val chunkedMethods = contactMethods.chunked(2)
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        chunkedMethods.forEach { rowMethods ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                rowMethods.forEach { method ->
                                    OutlinedButton(
                                        onClick = method.action,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Icon(
                                            imageVector = method.icon,
                                            contentDescription = method.label,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(method.label)
                                    }
                                }
                                // Add empty space if odd number of methods in the row
                                if (rowMethods.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else {
                    // Small screen - single column layout
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        contactMethods.forEach { method ->
                            OutlinedButton(
                                onClick = method.action,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = method.icon,
                                    contentDescription = method.label,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(method.label)
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class ContactMethod(
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val label: String,
    val action: () -> Unit
)