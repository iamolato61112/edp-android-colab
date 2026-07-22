package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Light Theme Colors
val LightPrimary = Color(0xFF771C1B)
val LightOnPrimary = Color(0xFFFFFFFF)
val LightPrimaryContainer = Color(0xFFE9C9C8)
val LightSecondary = Color(0xFF9E4744)
val LightSurface = Color(0xFFFFFFFF)
val LightOnSurfaceVariant = Color(0xFF5A4D4C)

// Dark Theme Colors
val DarkPrimary = Color(0xFFE0A3A0)
val DarkOnPrimary = Color(0xFF511313)
val DarkPrimaryContainer = Color(0xFF651817)
val DarkSecondary = Color(0xFFD49B99)
val DarkSurface = Color(0xFF1A1110)
val DarkOnSurfaceVariant = Color(0xFFC9B8B7)

@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = DarkPrimary,
            onPrimary = DarkOnPrimary,
            primaryContainer = DarkPrimaryContainer,
            secondary = DarkSecondary,
            surface = DarkSurface,
            onSurfaceVariant = DarkOnSurfaceVariant
        )
    } else {
        lightColorScheme(
            primary = LightPrimary,
            onPrimary = LightOnPrimary,
            primaryContainer = LightPrimaryContainer,
            secondary = LightSecondary,
            surface = LightSurface,
            onSurfaceVariant = LightOnSurfaceVariant
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            titleLarge = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        ),
        shapes = Shapes(
            medium = RoundedCornerShape(16.dp)
        ),
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                ProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Region B: Avatar + Badge
            Box(
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.amolato),
                    contentDescription = "Profile Avatar",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
                // Status Badge
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50))
                        .padding(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(2.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(Color(0xFF4CAF50))
                        )
                    }
                }
            }

            // Region C: Name & Role
            Text(
                "Iniego T. Amolato",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                "Android Developer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Region D: Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Message")
                }
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Follow")
                }
            }

            // Region E: Stats Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("99", style = MaterialTheme.typography.titleLarge)
                        Text("Followers", style = MaterialTheme.typography.bodyMedium)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("99", style = MaterialTheme.typography.titleLarge)
                        Text("Following", style = MaterialTheme.typography.bodyMedium)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("99", style = MaterialTheme.typography.titleLarge)
                        Text("Posts", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            // Region F: Info Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("iamolato61112@liceo.edu.ph", style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Barra Opol, MisOr", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenLightPreview() {
    ProfileTheme(darkTheme = false) {
        ProfileScreen()
    }
}

@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenDarkPreview() {
    ProfileTheme(darkTheme = true) {
        ProfileScreen()
    }
}
