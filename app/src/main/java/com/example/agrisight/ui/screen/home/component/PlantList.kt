package com.example.agrisight.ui.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.agrisight.components.PlantItem
import com.example.agrisight.data.remote.response.PlantsItem

@Composable
fun PlantList(
    modifier: Modifier = Modifier,
    plants: List<PlantsItem>,
    onClick: (String) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier.heightIn(max = 150.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(plants) { plant ->
            PlantItem(
                plant = plant,
                onClick = onClick
            )
        }
    }
}