package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Test

class CadastroAndroidTests {

    @Test
    fun deveMostrarTodosOsCamposNecessariosParaCriarUmUsuario() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_email)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherTodosOsCamposECadastrarUmUsuario(){
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(withId(R.id.activity_formulario_cadastro_usuario)).perform(typeText("teste"))
        onView(withId(R.id.activity_formulario_cadastro_email)).perform(typeText("teste@gmail.com"))
        onView(withId(R.id.activity_formulario_cadastro_senha)).perform(typeText("123456"))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).perform(click())

    }


}