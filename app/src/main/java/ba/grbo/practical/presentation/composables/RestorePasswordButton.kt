package ba.grbo.practical.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ba.grbo.practical.R

@Composable
fun RestorePasswordButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    CustomButton(
        modifier = modifier,
        text = R.string.restore_password,
        enabled = enabled,
        onClick = onClick
    )
}