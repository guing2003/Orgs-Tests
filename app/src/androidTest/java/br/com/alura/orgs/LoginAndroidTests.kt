package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class LoginAndroidTests() {

    @Test
    fun devemMostrarONomeDoAplicativoNaTelaDeLogin() {

        launch(LoginActivity::class.java)

        onView(withText("Orgs")).check(matches(isDisplayed()))

    }

    @Test
    fun deveMostrarTodosOsCamposNecessariosParaLogin() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario)).check(matches(isDisplayed()))

        onView(withId(R.id.activity_login_senha)).check(matches(isDisplayed()))

        onView(withId(R.id.activity_login_botao_entrar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencheTodosOsCamposNecessariosParaRealizarLogin() {
        launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario))
            .perform(
                typeText("Teste"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_login_senha))
            .perform(
                typeText("123456"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_login_botao_entrar))
            .perform(click())

    }
}