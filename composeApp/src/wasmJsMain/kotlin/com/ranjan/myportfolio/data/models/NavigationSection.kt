package com.ranjan.myportfolio.data.models

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FeatherIcons
import compose.icons.feathericons.*

enum class NavigationSection(
    val title: String,
    val icon: ImageVector
) {
    ABOUT("About", FeatherIcons.User),
    SKILLS("Skills", FeatherIcons.Star),
    PROJECTS("Projects", FeatherIcons.Briefcase),
    ARTICLES("Articles", FeatherIcons.FileText),
    EDUCATION("Education", FeatherIcons.BookOpen),
    CONTACT("Contact", FeatherIcons.Mail);

    companion object {
        fun fromString(name: String): NavigationSection? {
            return entries.find { it.title.equals(name, ignoreCase = true) }
        }

        fun fromUrlHash(hash: String): NavigationSection {
            return fromString(hash) ?: ABOUT
        }
    }
}