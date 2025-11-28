package br.com.alura.orgs

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProdutosAndroidTests() {

    @get:Rule
    val rule = ActivityScenarioRule(ListaProdutosActivity::class.java)

    @Before
    fun preparaAmbiente() {
        AppDatabase.instancia(InstrumentationRegistry.getInstrumentation().targetContext)
            .clearAllTables()
    }

    @Test
    fun devemMostrarONomeDoAplicativoNaTelaDeListagem() {

        onView(withText("Orgs"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun deveTerTodosOsCamposNecessariosParaCriarUmProduto() {
        clicaNoFab()

        onView(withId(R.id.activity_formulario_produto_nome))
            .check(matches(isDisplayed()))

        onView(withId(R.id.activity_formulario_produto_descricao))
            .check(matches(isDisplayed()))

        onView(withId(R.id.activity_formulario_produto_valor))
            .check(matches(isDisplayed()))

        clicaNoBotaoSalvar()
    }



    @Test
    fun deveSerCapazDePreencherTodosOsCamposEApertarOBotaoDeSalvar() {
        clicaNoFab()

        preencheCampos("Banana Prata", "Banana Prata", "6.99")

        clicaNoBotaoSalvar()
    }

    @Test
    fun deveSerCapazDeEditarUmProduto() {
        clicaNoFab()

        preencheCampos("Banana Prata", "Da feira", "6.99")

        clicaNoBotaoSalvar()

        onView(withText("Banana Prata"))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.menu_detalhes_produto_editar)).perform(click())

        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                replaceText("Banana Nanica"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                replaceText("Vendinha"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                replaceText("9.99"),
                closeSoftKeyboard()
            )

        clicaNoBotaoSalvar()

        onView(withText("Banana Nanica")).check(matches(isDisplayed()))


    }

    private fun clicaNoBotaoSalvar() {
        onView(withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(click())
    }
    private fun preencheCampos(nome: String, descricao: String, valor : String) {
        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                typeText(nome),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                typeText(descricao),
                closeSoftKeyboard()
            )

        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                typeText(valor),
                closeSoftKeyboard()
            )
    }

    private fun clicaNoFab() {
        onView(withId(R.id.activity_lista_produtos_fab))
            .perform(click())
    }
}