package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
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

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { uriHandler.openUri("mailto:${contactInfo.email}") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(FeatherIcons.Mail, contentDescription = "Email")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Email")
                    }

                    OutlinedButton(
                        onClick = { uriHandler.openUri(contactInfo.linkedin) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(FeatherIcons.Linkedin, contentDescription = "LinkedIn")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("LinkedIn")
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { uriHandler.openUri(contactInfo.github) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(FeatherIcons.Github, contentDescription = "GitHub")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("GitHub")
                    }

                    OutlinedButton(
                        onClick = { uriHandler.openUri(contactInfo.twitter) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(FeatherIcons.Twitter, contentDescription = "Twitter")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Twitter")
                    }
                }
            }
        }
    }
}