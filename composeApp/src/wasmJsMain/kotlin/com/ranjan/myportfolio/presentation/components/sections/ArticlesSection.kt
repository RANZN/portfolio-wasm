package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.presentation.components.cards.ArticleCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle

@Composable
fun ArticlesSection(articles: List<Article>, isLargeScreen: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        SectionTitle("Articles")
        
        articles.forEach { article ->
            ArticleCard(article)
        }
    }
}