package ba.grbo.practical.presentation.screens.login

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.grbo.core.domain.Email
import ba.grbo.core.domain.Password
import ba.grbo.practical.R
import ba.grbo.practical.framework.mics.DEFAULT
import ba.grbo.practical.framework.theme.PracticalTheme
import ba.grbo.practical.presentation.PracticalActivity
import ba.grbo.practical.presentation.composables.CredentialScreen
import ba.grbo.practical.presentation.composables.EmailInput
import ba.grbo.practical.presentation.composables.Header
import ba.grbo.practical.presentation.composables.LoginButton
import ba.grbo.practical.presentation.composables.PasswordInput
import ba.grbo.practical.presentation.composables.RestorePassword
import ba.grbo.practical.presentation.composables.SignUp
import ba.grbo.practical.presentation.composables.ThirdPartyLoginButtons
import ba.grbo.practical.presentation.composables.keyboardAsState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    email: Email,
    password: Password,
    loading: Boolean,
    @StringRes feedback: Int,
    onEmailChange: (String) -> Unit,
    onResetEmailButtonClicked: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordTextClicked: () -> Unit,
    onPasswordVisibilityButtonClicked: () -> Unit,
    onResetPasswordButtonClicked: () -> Unit,
    onLoginButtonClicked: () -> Unit,
    onGoogleLoginButtonClicked: () -> Unit,
    onFacebookLoginButtonClicked: () -> Unit,
    onSignUpTextClicked: () -> Unit
) {
    // (LocalContext.current as PracticalActivity).fire

    CredentialScreen(
        modifier = modifier,
        loading = loading,
    ) {
        val keyboardOpened by keyboardAsState()
        val spacer by animateDpAsState(if (keyboardOpened) 12.dp else 24.dp)
        val specialSpacer by animateDpAsState(if (keyboardOpened) 18.dp else 36.dp)
        val fixedSpacer = 24.dp

        Header(
            modifier = Modifier.fillMaxWidth(),
            header = R.string.login,
            feedback = feedback,
            enabled = !loading
        )

        Spacer(modifier = Modifier.height(spacer))

        val focusManager = LocalFocusManager.current
        EmailInput(
            modifier = Modifier.fillMaxWidth(),
            email = email,
            enabled = !loading,
            onEmailChange = onEmailChange,
            onResetEmailButtonClicked = onResetEmailButtonClicked,
            onImeActionButtonClicked = { focusManager.moveFocus(FocusDirection.Down) }
        )

        Spacer(modifier = Modifier.height(spacer))

        PasswordInput(
            modifier = Modifier.fillMaxWidth(),
            password = password,
            enabled = !loading,
            imeAction = ImeAction.Done,
            onPasswordChange = onPasswordChange,
            onPasswordVisibilityButtonClicked = onPasswordVisibilityButtonClicked,
            onResetPasswordButtonClicked = onResetPasswordButtonClicked,
            onImeActionButtonClicked = onLoginButtonClicked
        )

        Spacer(modifier = Modifier.height(spacer / 2))

        RestorePassword(
            modifier = Modifier.align(Alignment.End),
            enabled = !loading,
            onClick = onForgotPasswordTextClicked
        )

        Spacer(modifier = Modifier.height(fixedSpacer))

        LoginButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = !loading,
            onClick = onLoginButtonClicked
        )

        Spacer(modifier = Modifier.height(specialSpacer))

        ThirdPartyLoginButtons(
            modifier = Modifier.fillMaxWidth(),
            enabled = !loading,
            onGoogleLoginButtonClicked = onGoogleLoginButtonClicked,
            onFacebookLoginButtonClicked = onFacebookLoginButtonClicked
        )

        Spacer(modifier = Modifier.height(spacer))

        SignUp(
            enabled = !loading,
            onSignUpTextClicked = onSignUpTextClicked
        )

        Spacer(modifier = Modifier.height(spacer / 2))
    }
}

@Preview(
    name = "loaded",
    showBackground = true
)
@Preview(
    name = "loaded",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginScreenLoadedPreview() {
    PracticalTheme {
        Surface {
            LoginScreen(
                email = Email(
                    value = "grbo.dev@gmail.com",
                    isError = false,
                    errorMessage = Int.DEFAULT
                ),
                password = Password(
                    value = "123",
                    masked = true,
                    isError = false,
                    errorMessage = Int.DEFAULT
                ),
                loading = false,
                feedback = Int.DEFAULT,
                onEmailChange = {},
                onResetEmailButtonClicked = {},
                onPasswordChange = {},
                onForgotPasswordTextClicked = {},
                onPasswordVisibilityButtonClicked = {},
                onResetPasswordButtonClicked = {},
                onLoginButtonClicked = {},
                onGoogleLoginButtonClicked = {},
                onFacebookLoginButtonClicked = {},
                onSignUpTextClicked = {}
            )
        }
    }
}

@Preview(
    name = "loading",
    showBackground = true
)
@Preview(
    name = "loading",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginScreenLoadingPreview() {
    PracticalTheme {
        Surface {
            LoginScreen(
                email = Email(
                    value = "grbo.dev@gmail.com",
                    isError = false,
                    errorMessage = Int.DEFAULT
                ),
                password = Password(
                    value = "123",
                    masked = true,
                    isError = false,
                    errorMessage = Int.DEFAULT
                ),
                loading = true,
                feedback = Int.DEFAULT,
                onEmailChange = {},
                onResetEmailButtonClicked = {},
                onPasswordChange = {},
                onForgotPasswordTextClicked = {},
                onPasswordVisibilityButtonClicked = {},
                onResetPasswordButtonClicked = {},
                onLoginButtonClicked = {},
                onGoogleLoginButtonClicked = {},
                onFacebookLoginButtonClicked = {},
                onSignUpTextClicked = {}
            )
        }
    }
}