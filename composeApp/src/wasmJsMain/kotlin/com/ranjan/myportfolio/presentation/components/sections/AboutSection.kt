package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.data.models.Skill
import compose.icons.FeatherIcons
import compose.icons.SimpleIcons
import compose.icons.feathericons.ArrowRight
import compose.icons.simpleicons.Github
import compose.icons.simpleicons.Linkedin
import compose.icons.simpleicons.Medium
import compose.icons.simpleicons.Twitter

@Composable
fun AboutSection(
    profile: Profile,
    contactInfo: ContactInfo,
    skills: List<Skill>,
    articles: List<Article>,
    onSectionSelected: (NavigationSection) -> Unit,
    isLargeScreen: Boolean
) {
    val uriHandler = LocalUriHandler.current

    Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
        // Profile Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = profile.name,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = profile.title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                
                profile.aboutDescription.forEach { paragraph ->
                    Text(
                        text = paragraph,
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 24.sp
                    )
                }
            }
        }

        // Follow Me Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Follow Me On",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                // Create list of available social media platforms
                val socialMediaPlatforms = buildList {
                    // LinkedIn (always available)
                    add(
                        SocialMediaPlatform(
                            icon = SimpleIcons.Linkedin,
                            label = "LinkedIn",
                            url = contactInfo.linkedin
                        )
                    )

                    // Medium (only if available)
                    contactInfo.medium?.let { mediumUrl ->
                        add(
                            SocialMediaPlatform(
                                icon = SimpleIcons.Medium,
                                label = "Medium",
                                url = mediumUrl
                            )
                        )
                    }

                    // Twitter (only if available)
                    contactInfo.twitter?.let { twitterUrl ->
                        add(
                            SocialMediaPlatform(
                                icon = SimpleIcons.Twitter,
                                label = "Twitter",
                                url = twitterUrl
                            )
                        )
                    }

                    // GitHub (always available)
                    add(
                        SocialMediaPlatform(
                            icon = SimpleIcons.Github,
                            label = "GitHub",
                            url = contactInfo.github
                        )
                    )
                }

                if (isLargeScreen) {
                    // Large screen - horizontal layout
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        socialMediaPlatforms.forEach { platform ->
                            SocialMediaButton(
                                icon = platform.icon,
                                label = platform.label,
                                url = platform.url,
                                uriHandler = uriHandler,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                } else {
                    // Small screen - adaptive grid layout based on available platforms
                    val chunkedPlatforms = socialMediaPlatforms.chunked(2)
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        chunkedPlatforms.forEach { rowPlatforms ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                rowPlatforms.forEach { platform ->
                                    SocialMediaButton(
                                        icon = platform.icon,
                                        label = platform.label,
                                        url = platform.url,
                                        uriHandler = uriHandler,
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                // Add empty space if odd number of platforms in the row
                                if (rowPlatforms.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }

        // Skills Preview Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Top Skills",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(
                        onClick = { onSectionSelected(NavigationSection.SKILLS) }
                    ) {
                        Text("View More")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(FeatherIcons.ArrowRight, contentDescription = "View More", modifier = Modifier.size(16.dp))
                    }
                }
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(skills.take(5)) { skill ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = skill.icon,
                                    contentDescription = skill.name,
                                    modifier = Modifier.size(20.dp),
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Text(
                                    text = skill.name,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }
        }

        // Articles Preview Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Latest Articles",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(
                        onClick = { onSectionSelected(NavigationSection.ARTICLES) }
                    ) {
                        Text("View More")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(FeatherIcons.ArrowRight, contentDescription = "View More", modifier = Modifier.size(16.dp))
                    }
                }
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    articles.take(2).forEach { article ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = article.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = article.summary,
                                    style = MaterialTheme.typography.bodyMedium,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = article.date,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text("•", color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    Text(
                                        text = article.readTime,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class SocialMediaPlatform(
    val icon: ImageVector,
    val label: String,
    val url: String
)

@Composable
private fun SocialMediaButton(
    icon: ImageVector,
    label: String,
    url: String,
    uriHandler: UriHandler,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = { uriHandler.openUri(url) },
        modifier = modifier.height(56.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }
    }
}