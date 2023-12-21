package com.example.agrisight.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agrisight.R
import com.example.agrisight.ui.theme.colorPrimary
import com.example.agrisight.ui.theme.ghostWhite
import com.example.agrisight.ui.theme.lightGray
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.util.Constants.ARTICLE_SECTION_TITLE
import com.example.agrisight.util.Constants.CARD_DESCRIPTION
import com.example.agrisight.util.Constants.CARD_TITLE
import com.example.agrisight.util.Constants.GREEN_HOUSE
import com.example.agrisight.util.Constants.LEARNING_CARD_BUTTON
import com.example.agrisight.util.Constants.PLANT_SECTION_TITLE
import com.example.agrisight.util.Constants.VIEW_ALL

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    plants: List<PlantsItem>,
    articles: List<ArticlesItem>,
    navigateToPlantListScreen: () -> Unit,
    navigateToPlantDetailScreen: (String) -> Unit,
    navigateToArticleListScreen: () -> Unit,
    navigateToArticleDetailScreen: (String) -> Unit
) {
    Surface(modifier = modifier.fillMaxSize(), color = colorPrimary) {
        Card(
            colors = CardDefaults.cardColors(containerColor = ghostWhite),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = modifier.size(120.dp),
                                painter = painterResource(R.drawable.green_house),
                                contentDescription = GREEN_HOUSE
                            )
                            Column(
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = CARD_TITLE,
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                                    textAlign = TextAlign.End,
                                    fontSize = 14.sp
                                )
                                Text(
                                    modifier = modifier.padding(top = 6.dp, bottom = 12.dp),
                                    text = CARD_DESCRIPTION,
                                    color = lightGray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                                    textAlign = TextAlign.End,
                                    fontSize = 12.sp,
                                    lineHeight = 18.sp
                                )
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(containerColor = colorPrimary)
                                ) {
                                    Text(
                                        text = LEARNING_CARD_BUTTON,
                                        fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                                    )
                                }
                            }
                        }
                    }
                }
                HomeSection(
                    title = PLANT_SECTION_TITLE,
                    viewAll = VIEW_ALL,
                    navigateToListScreen = { navigateToPlantListScreen() }
                ) {
                    PlantList(
                        plants = plants,
                        onClick = navigateToPlantDetailScreen
                    )
                }
                HomeSection(
                    title = ARTICLE_SECTION_TITLE,
                    viewAll = VIEW_ALL,
                    navigateToListScreen = { navigateToArticleListScreen() }
                ) {
                    ArticleList(
                        articles = articles,
                        onCLick = navigateToArticleDetailScreen
                    )
                }
            }
        }
    }
}