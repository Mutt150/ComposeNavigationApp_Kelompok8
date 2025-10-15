
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigationapp.ui.screens.Note

//@Composable
//fun DetailScreen(navController: NavController, id: String?) {
//    Column(
//        Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Detail Item", style =
//            MaterialTheme.typography.headlineSmall)
//        Spacer(Modifier.height(12.dp))
//        Text("ID diterima: $id", style =
//            MaterialTheme.typography.bodyLarge)
//        Spacer(Modifier.height(20.dp))
//        Button(onClick = { navController.popBackStack() }) {
//            Text("Kembali")
//        }
//    }
//}

@Composable
fun DetailScreen(navController: NavController, note: Note?) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (note == null) {
            Text("Note tidak ditemukan", style = MaterialTheme.typography.headlineSmall)
        } else {
            Text(note.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(12.dp))
            Text(note.content, style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(20.dp))
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }
    }
}
