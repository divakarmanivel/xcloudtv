package com.divakar.xcloudtv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.foundation.PivotOffsets
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.ListItem
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.NonInteractiveSurfaceDefaults
import androidx.tv.material3.RadioButton
import androidx.tv.material3.Surface
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LocaleSelector(
    isExpanded: Boolean,
    onClose: () -> Unit,
    onLocaleChange: (String) -> Unit,
    content: @Composable () -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(isExpanded) {
        if (isExpanded) {
            focusRequester.requestFocus()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        content()

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.scrim.copy(alpha = 0.5f))
            ) {
                Surface(
                    Modifier
                        .fillMaxHeight()
                        .width(300.dp)
                        .padding(12.dp)
                        .align(Alignment.End),
                    colors = NonInteractiveSurfaceDefaults
                        .colors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    TvLazyColumn(
                        modifier = Modifier
                            .padding(12.dp)
                            .focusRequester(focusRequester)
                            .focusProperties {
                                exit = {
                                    onClose()
                                    FocusRequester.Default
                                }
                            },
                        pivotOffsets = PivotOffsets(parentFraction = 0.2f)
                    ) {
                        item {
                            Text(
                                text = "Locale & language",
                                modifier = Modifier.padding(20.dp),
                                fontSize = 20.sp
                            )
                        }

                        item {
                            Column(
                                Modifier.selectableGroup()
                            ) {
                                locales.forEach {
                                    val isSelected = it == LocalLocale.current

                                    ListItem(
                                        selected = isSelected,
                                        onClick = { onLocaleChange(it) },
                                        modifier = Modifier.semantics(mergeDescendants = true) { },
                                        trailingContent = {
                                            RadioButton(selected = isSelected, onClick = { })
                                        }
                                    ) {
                                        Text(text = it)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}